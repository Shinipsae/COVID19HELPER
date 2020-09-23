package com.example.covid19helper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{

    Button timeBtn;
    Button timeBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        timeBtn=(Button)findViewById(R.id.time);
        timeBtn2=(Button)findViewById(R.id.time2);

        timeBtn.setOnClickListener(this);
        timeBtn2.setOnClickListener(this);
    }


    private void showToast(String s) {
        Toast toast= Toast.makeText(this, s, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        if(v==timeBtn){
            Calendar c= Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(minute > 10){
                        showToast(hourOfDay+":"+minute+"분에 알람이 설정되었습니다.");
                    }
                    else{
                        showToast(hourOfDay+":"+minute+"0"+"분에 알람이 설정되었습니다.");
                    }

                }

            },hour,minute,false);
            timePickerDialog.show();
        }
        else if(v==timeBtn2){
            Calendar c= Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(minute > 10){
                        showToast(hourOfDay+":"+minute+"분에 알람이 설정되었습니다.");
                    }
                    else{
                        showToast(hourOfDay+":"+minute+"0"+"분에 알람이 설정되었습니다.");
                    }

                }

            },hour,minute,false);
            timePickerDialog.show();
        }
    }
}