package com.influence.influencerapp;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoUploadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoupload);

        TextView textView = findViewById(R.id.TextView_1);
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(), new int[]{Color.BLUE, Color.RED}, new float[]{0, 1}, Shader.TileMode.MIRROR);
        textView.getPaint().setShader(textShader);
    }
}
