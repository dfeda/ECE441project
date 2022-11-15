package com.example.securucar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class AutonomousActivity extends AppCompatActivity {
    private Button controlledButtonInAutonomous;
    private Button logoutButtonInAutonomous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_autonomous);

        controlledButtonInAutonomous = (Button) findViewById(R.id.controlledButtonInAutonomous);
        logoutButtonInAutonomous = (Button) findViewById(R.id.logoutButtonInAutonomous);
        controlledButtonInAutonomous.setOnClickListener(v -> openControlledActivity());
        logoutButtonInAutonomous.setOnClickListener(v -> attemptLogout());
    }

    public void openControlledActivity() {
        Intent intent = new Intent(this, ControlledActivity.class);
        startActivity(intent);
    }

    public void attemptLogout() {
        Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}