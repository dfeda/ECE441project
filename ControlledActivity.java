package com.example.securucar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class ControlledActivity extends AppCompatActivity {
    private Button autonomousButtonInControlled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_controlled);

        autonomousButtonInControlled = (Button) findViewById(R.id.autonomousButtonInControlled);
        autonomousButtonInControlled.setOnClickListener(v -> openAutonomousActivity());
    }

    public void openAutonomousActivity() {
        Intent intent = new Intent(this, AutonomousActivity.class);
        startActivity(intent);
    }
}