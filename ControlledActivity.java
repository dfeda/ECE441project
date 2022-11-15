package com.example.securucar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class ControlledActivity extends AppCompatActivity {
    private Button autonomousButtonInControlled;
    private Button logoutButtonInControlled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_controlled);

        autonomousButtonInControlled = (Button) findViewById(R.id.autonomousButtonInControlled);
        logoutButtonInControlled = (Button) findViewById(R.id.logoutButtonInControlled);
        autonomousButtonInControlled.setOnClickListener(v -> openAutonomousActivity());
        logoutButtonInControlled.setOnClickListener(v -> attemptLogout());
    }

    public void openAutonomousActivity() {
        Intent intent = new Intent(this, AutonomousActivity.class);
        startActivity(intent);
    }

    public void attemptLogout() {
        Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}