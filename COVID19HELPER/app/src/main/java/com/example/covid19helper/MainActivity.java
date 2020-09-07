package com.example.covid19helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.Response;

public class MainActivity extends AppCompatActivity {

    EditText id, password;
    ImageButton loginButton, signupButton, forgotpwButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 화면 나타내기
        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
        loginButton = (ImageButton) findViewById(R.id.loginButton);
        signupButton = (ImageButton) findViewById(R.id.signupButton);
        forgotpwButton = (ImageButton) findViewById(R.id.forgotpwButton);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { // 로그인 버튼 클릭시
                String userID = id.getText().toString();
                String userPassword = password.getText().toString();

                Response.Listener<String> reponseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                };

                // 넘어감
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { // 회원가입 버튼 클릭시
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        forgotpwButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { // 비밀번호 버튼 잊음 클릭시
                Intent intent = new Intent(MainActivity.this, ForgotpwActivity.class);
                startActivity(intent);
            }
        });
     }
}
