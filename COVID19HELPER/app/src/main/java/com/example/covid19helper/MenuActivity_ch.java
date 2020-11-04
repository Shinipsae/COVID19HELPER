package com.example.covid19helper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity_ch extends AppCompatActivity {

    ImageButton selftestButton;
    ImageButton enterqrButton;
    ImageButton alarmButton;
    ImageButton preventionButton;
    ImageButton kButton;
    ImageButton engButton;
    ImageButton jaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ch); // 화면 나타내기

        selftestButton = (ImageButton) findViewById(R.id.selftestButton);
        enterqrButton = (ImageButton) findViewById(R.id.enterqrButton);
        alarmButton = (ImageButton) findViewById(R.id.alarmButton);
        preventionButton = (ImageButton) findViewById(R.id.preventionButton);
        kButton = (ImageButton) findViewById(R.id.kButton);
        engButton = (ImageButton) findViewById(R.id.engButton);
        jaButton = (ImageButton) findViewById(R.id.jaButton);

        selftestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://hcs.eduro.go.kr/"));
                startActivity(intent);
            }
        });

        enterqrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://nid.naver.com/login/privacyQR?term=on"));

                startActivity(intent);
            }
        });

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity_ch.class);
                startActivity(intent);
            }
        });

        preventionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://bot.dialogflow.com/620e1c6a-6b7c-4f7d-be9c-111ea46898a5"));
                startActivity(intent);
            }
        });

        kButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });

        engButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity_eng.class);
                startActivity(intent);
                finish();
            }
        });

        jaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity_ja.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
