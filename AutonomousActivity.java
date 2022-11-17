package com.example.securucar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;


public class AutonomousActivity extends AppCompatActivity {
    private Button controlledButtonInAutonomous;
    private Button logoutButtonInAutonomous;
    VideoView cameraOutputAutonomous; //CHECK
    MediaController mediaController; //CHECK

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_autonomous);

        controlledButtonInAutonomous = (Button) findViewById(R.id.controlledButtonInAutonomous);
        logoutButtonInAutonomous = (Button) findViewById(R.id.logoutButtonInAutonomous);
        cameraOutputAutonomous = (VideoView)findViewById(R.id.cameraOutputAutonomous);

        controlledButtonInAutonomous.setOnClickListener(v -> openControlledActivity());
        logoutButtonInAutonomous.setOnClickListener(v -> attemptLogout());

        playStream("http://10.136.137.118:8090");
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
/*
    //TODO: check this code below
    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response;

        MyClientTask(String addr, int port) {
            dstAddress = addr;
            dstPort = port;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                Socket socket = new Socket(dstAddress, dstPort);
                InputStream inputStream = socket.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream =
                        new ByteArrayOutputStream(1024);
                byte[] buffer = new byte[1024];

                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }

                socket.close();
                response = byteArrayOutputStream.toString("UTF-8");

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
    } */

    private void playStream(String src){
        Uri UriSrc = Uri.parse(src);
        if(UriSrc == null){
            Toast.makeText(AutonomousActivity.this,
                    "UriSrc == null", Toast.LENGTH_LONG).show();
        }else{
            cameraOutputAutonomous.setVideoURI(UriSrc);
            mediaController = new MediaController(this);
            cameraOutputAutonomous.setMediaController(mediaController);
            cameraOutputAutonomous.start();

            Toast.makeText(AutonomousActivity.this,
                    "Connect: " + src,
                    Toast.LENGTH_LONG).show();
        }
    }
}