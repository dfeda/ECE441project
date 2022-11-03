package com.example.securucar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class AutonomousActivity extends AppCompatActivity {
    private Button controlledButtonInAutonomous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_autonomous);

        controlledButtonInAutonomous = (Button) findViewById(R.id.controlledButtonInAutonomous);
        controlledButtonInAutonomous.setOnClickListener(v -> openControlledActivity());
    }

    public void openControlledActivity() {
        Intent intent = new Intent(this, ControlledActivity.class);
        startActivity(intent);
    }
}