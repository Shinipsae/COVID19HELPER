package com.example.covid19helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText id, pw;
    ImageButton loginButton, signupButton, forgotpwButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 화면 나타내기
        id = (EditText) findViewById(R.id.id);
        pw = (EditText) findViewById(R.id.pw);
        loginButton = (ImageButton) findViewById(R.id.loginButton);
        signupButton = (ImageButton) findViewById(R.id.signupButton);
        forgotpwButton = (ImageButton) findViewById(R.id.forgotpwButton);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MenuActivity.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SignupActivity.class);
                startActivity(intent);
            }
        });

        forgotpwButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), ForgotpwActivity.class);
                startActivity(intent);
            }
        });
     }
}
