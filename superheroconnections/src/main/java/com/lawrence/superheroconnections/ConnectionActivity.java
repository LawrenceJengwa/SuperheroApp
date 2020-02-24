package com.lawrence.superheroconnections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lawrence.superheroapp.rest.RetrofitClient;
import com.lawrence.superheroapp.rest.model.Connections;
import com.lawrence.superheroapp.rest.model.Id;
import com.lawrence.superheroapp.rest.network.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionActivity extends AppCompatActivity {

    private EditText mSearchconnection;
    private TextView mName, mGroup, mRelatives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        mSearchconnection = findViewById(R.id.search_connections);
        mName = findViewById(R.id.connection_name);
        mGroup = findViewById(R.id.connection_group);
        mRelatives = findViewById(R.id.connection_relatives);


    }
    public void Search(View view) {
        final String characterId = mSearchconnection.getText().toString().trim();
            GetService service = RetrofitClient.buildService(GetService.class);
            Call<Connections> call = service.getConnections(characterId);
            call.enqueue(new Callback<Connections>() {
                @Override
                public void onResponse(Call<Connections> call, Response<Connections> response) {
                    mSearchconnection.setVisibility(View.INVISIBLE);
                    mName.setText(String.format("Name: %s", response.body().getName()));
                    mGroup.setText(String.format("Group: %s", response.body().getGroupAffiliation()));
                    mRelatives.setText(String.format("Relatives: %s", response.body().getRelatives()));

                }

                @Override
                public void onFailure(Call<Connections> call, Throwable t) {
                    mSearchconnection.setVisibility(View.INVISIBLE);
                    Toast.makeText(ConnectionActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
    }
}

