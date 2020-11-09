package com.mirim.covid19helper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.mirim.covid19helper.R;


public class LogoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
