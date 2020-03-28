package com.influence.influencerapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        int splash_timing = 3000;

        TextView textView = findViewById(R.id.TextView_1);
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(), new int[]{Color.BLUE, Color.RED}, new float[]{0, 1}, Shader.TileMode.MIRROR);
        textView.getPaint().setShader(textShader);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, splash_timing);
    }
}
