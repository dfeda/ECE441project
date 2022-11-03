package com.example.securucar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class ModeChoiceActivity extends AppCompatActivity {
    private Button autonomousButton;
    private Button controlledButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_mode_choice);

        autonomousButton = (Button) findViewById(R.id.autonomousButton);
        controlledButton = (Button) findViewById(R.id.controlledButton);
        autonomousButton.setOnClickListener(v -> openAutonomousActivity());
        controlledButton.setOnClickListener(v -> openControlledActivity());
    }

    public void openAutonomousActivity() {
        Intent intent = new Intent(this, AutonomousActivity.class);
        startActivity(intent);
    }

    public void openControlledActivity() {
        Intent intent = new Intent(this, ControlledActivity.class);
        startActivity(intent);
    }
}