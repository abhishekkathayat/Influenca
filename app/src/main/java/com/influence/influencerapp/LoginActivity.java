package com.influence.influencerapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        Button login = findViewById(R.id.Button_1);
        TextView textView = findViewById(R.id.TextView_1);
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(), new int[]{Color.BLUE, Color.RED}, new float[]{0, 1}, Shader.TileMode.MIRROR);
        textView.getPaint().setShader(textShader);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}