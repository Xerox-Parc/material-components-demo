package com.xeroxparc.materialcomponentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.xeroxparc.materialcomponentsdemo.ui.search.ComponentSearchActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent splashScreenIntent = new Intent(SplashScreenActivity.this, ComponentSearchActivity.class);
                startActivity(splashScreenIntent);
                finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }
}