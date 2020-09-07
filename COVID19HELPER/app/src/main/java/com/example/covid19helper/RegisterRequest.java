package com.example.covid19helper;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 (PHP파일 연동)
    final static private String URL = "http://covid19helper.dothome.co.kr/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String userName, String userYYMMDD, String userSchool, String userID,
                           String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userName", userName);
        map.put("userYYMMDD", userYYMMDD);
        map.put("userSchool", userSchool);
        map.put("userID", userID);
        map.put("userPassword", userPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
