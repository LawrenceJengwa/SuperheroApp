package com.lawrence.superheroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.lawrence.superheroapp.rest.RetrofitClient;
import com.lawrence.superheroapp.rest.model.Id;
import com.lawrence.superheroapp.rest.model.Image;
import com.lawrence.superheroapp.rest.network.GetService;
import com.lawrence.superheroapp.rest.network.glideModule.GlideApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterIdActivity extends AppCompatActivity {

    private TextView mHeroName, mStrength, mSpeed, mPower;
    private TextView mGender, mRace, mWeight, mHeight, mProgressText;
    private ImageView mHeroImage;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_id);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mHeroName = findViewById(R.id.superhero_name);
        mStrength = findViewById(R.id.superhero_strength);
        mSpeed = findViewById(R.id.superhero_speed);
        mPower = findViewById(R.id.superhero_power);
        mGender = findViewById(R.id.superhero_bio_gender);
        mRace = findViewById(R.id.superhero_bio_race);
        mWeight = findViewById(R.id.superhero_bio_weight);
        mHeight = findViewById(R.id.superhero_bio_height);
        mHeroImage = findViewById(R.id.superhero_image);
        mProgressBar = findViewById(R.id.progress_bar_circular);
        mProgressText = findViewById(R.id.progress_bar_text);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        String characterId = extras.getString("characterId");
        final ArrayList<String> responseData = new ArrayList<>();

        mProgressBar.setVisibility(View.VISIBLE);
        GetService service = RetrofitClient.buildService(GetService.class);
        Call<Id> call = service.getCharacterById(characterId);


        call.enqueue(new Callback<Id>() {
            @Override
            public void onResponse(Call<Id> call, Response<Id> response) {
                mProgressBar.setVisibility(View.INVISIBLE);
                mProgressText.setVisibility(View.INVISIBLE);
                assert response.body() != null;

                if (response.body().getPowerstats() == null) {
                    mSpeed.setText("No speed");
                    mPower.setText("No Power");
                }

                mHeroName.setText(String.format("Name: %s", response.body().getName()));
                mStrength.setText(String.format("Strength: %s", response.body().getPowerstats().getStrength()));
                mSpeed.setText(String.format("Speed: %s", response.body().getPowerstats().getSpeed()));
                mPower.setText(String.format("Power: %s", response.body().getPowerstats().getPower()));

                if (response.body().getAppearance() != null) {
                    String gender = response.body().getAppearance().getGender();
                    String race = response.body().getAppearance().getRace();
                    mGender.setText(String.format("Gender: %s", gender));
                    mRace.setText(String.format("Race: %s", race));
                    List<String> height = response.body().getAppearance().getHeight();
                    List<String> weight = response.body().getAppearance().getWeight();
                    String heightInCm = height.get(1);
                    String weightInKg = weight.get(1);
                    mHeight.setText(String.format("Height: %s", heightInCm));
                    mWeight.setText(String.format("Weight: %s", weightInKg));
                }

            }

            @Override
            public void onFailure(Call<Id> call, Throwable t) {
                mProgressBar.setVisibility(View.INVISIBLE);
                mProgressText.setVisibility(View.INVISIBLE);
                Toast.makeText(CharacterIdActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        Call<Image> imageCall = service.getImage(characterId);
        imageCall.enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call, Response<Image> response) {
                mProgressBar.setVisibility(View.INVISIBLE);
                mProgressText.setVisibility(View.INVISIBLE);
                assert response.body() != null;
                GlideApp.with(getApplicationContext())
                        .load(response.body().getUrl())
                        .placeholder(R.drawable.ic_launcher_background)
                        .apply(new RequestOptions().override(400, 400))
                        .timeout(15)
                        .fitCenter()
                        .into(mHeroImage);

            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {
                mProgressBar.setVisibility(View.INVISIBLE);
                mProgressText.setVisibility(View.INVISIBLE);
                Toast.makeText(CharacterIdActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void close(View view) {
        finish();
    }
}
