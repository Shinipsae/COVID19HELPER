package com.example.covid19helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    private EditText name, yymmdd, school, id, password;
    private ImageButton signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); // 화면 나타내기

        // 아이디 값 찾아주기
        name = findViewById(R.id.name);
        yymmdd = findViewById(R.id.yymmdd);
        school = findViewById(R.id.school);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);

        signupButton = findViewById(R.id.signupButton);
    }
}
