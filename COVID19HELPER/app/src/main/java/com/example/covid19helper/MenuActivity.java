package com.example.covid19helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    ImageButton selftestButton;
    ImageButton enterqrButton;
    ImageButton alarmButton;
    ImageButton preventionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); // 화면 나타내기

        selftestButton = (ImageButton) findViewById(R.id.selftestButton);
        enterqrButton = (ImageButton) findViewById(R.id.enterqrButton);
        alarmButton = (ImageButton) findViewById(R.id.alarmButton);
        preventionButton = (ImageButton) findViewById(R.id.preventionButton);

        selftestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelftestActivity.class);
                startActivity(intent);
            }
        });

        enterqrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EnterqrActivity.class);
                startActivity(intent);
            }
        });

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(intent);
            }
        });

        preventionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PreventionActivity.class);
                startActivity(intent);
            }
        });

    }

}
