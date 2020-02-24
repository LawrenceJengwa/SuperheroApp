package com.lawrence.superheroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lawrence.superheroapp.rest.RetrofitClient;
import com.lawrence.superheroapp.rest.model.Biography;
import com.lawrence.superheroapp.rest.network.GetService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiographyActivity extends AppCompatActivity {

    private TextView mHeroName;
    private TextView mPlaceOfBirth;
    private TextView mFirstAppearance;
    private ImageView mSuperHeroImage;
    private static String TOKEN = "105581651029925";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);

        mHeroName = findViewById(R.id.superheroName);
        mPlaceOfBirth = findViewById(R.id.placeOfBirth);
        mFirstAppearance = findViewById(R.id.first_appearance);

        GetService service = RetrofitClient.buildService(GetService.class);
        Call<List<Biography>> call = service.getBio("70");
        call.enqueue(new Callback<List<Biography>>() {
            @Override
            public void onResponse(Call<List<Biography>> call, Response<List<Biography>> response) {

                List<Biography> biographies = response.body();
                for (Biography biography : biographies){
                    String name = biography.getFullName();
                    String place = biography.getPlaceOfBirth();
                    mHeroName.setText(name);
                    mPlaceOfBirth.setText(place);
                }
            }

            @Override
            public void onFailure(Call<List<Biography>> call, Throwable t) {

            }
        });


    }
}
