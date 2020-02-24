package com.lawrence.superheroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lawrence.superheroapp.rest.RetrofitClient;
import com.lawrence.superheroapp.rest.model.Character;
import com.lawrence.superheroapp.rest.model.Result;
import com.lawrence.superheroapp.rest.network.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCharacterActivity extends AppCompatActivity {
    EditText mEnteredId;
    Button searchButton;
    public static String mName;
    public static String mBio;
    public static String mPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_character);

        mEnteredId = findViewById(R.id.searchEntry);
        searchButton = findViewById(R.id.searchButton);



        searchButton.setOnClickListener(new View.OnClickListener() {
            ;
            @Override
            public void onClick(View view) {
                final String sCharacterId = mEnteredId.getText().toString().trim();
                Intent intent = new Intent(SearchCharacterActivity.this, CharacterIdActivity.class);
                intent.putExtra("characterId", sCharacterId);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
