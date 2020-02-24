package com.lawrence.superheroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;

public class LoginActivity extends AppCompatActivity {
    private TextView mStatus;
    private SplitInstallManager mManager;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogin = findViewById(R.id.loginButton);
        mManager = SplitInstallManagerFactory.create(this);
        mStatus = findViewById(R.id.status);

        mLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SearchCharacterActivity.class);
                startActivity(i);
            }
        });

    }
    public void launchFeature(View view) {
        if (mManager.getInstalledModules().contains("superheroconnections")) {
            Intent i = new Intent(
                    "com.lawrence.superherodynamic.superheroconnections.ConnectionActivity");
            startActivity(i);
        } else {
          AlertDialog.Builder dialog = new AlertDialog.Builder(this);
          dialog.setMessage("Feature not installed, click ok to install.");
          dialog.setTitle("Install feature.");
          dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                  installFeature();
              }
          });

        }
    }
    public void installFeature() {

        SplitInstallRequest request =
                SplitInstallRequest
                        .newBuilder()
                        .addModule("superheroconnections")
                        .build();

        mManager.startInstall(request)
                .addOnSuccessListener(new OnSuccessListener<Integer>() {
                    @Override
                    public void onSuccess(Integer sessionId) {
                        Toast.makeText(LoginActivity.this,
                                "Module installation started",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception exception) {
                        Toast.makeText(LoginActivity.this,
                                "Module installation failed" + exception.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

