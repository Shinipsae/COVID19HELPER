package com.mirim.covid19helper;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class TimerActivity extends AppCompatActivity {



    private TimePicker tStartTime;

    private TimePicker tStopTime;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        int hour_NumberPicker_id = Resources.getSystem().getIdentifier("hour", "id", "android");

        int minute_NumberPicker_id = Resources.getSystem().getIdentifier("minute", "id", "android");

        NumberPicker hourNumberPicker1 = (NumberPicker)tStartTime.findViewById(hour_NumberPicker_id);

        NumberPicker minuteNumberPicker1 = (NumberPicker)tStartTime.findViewById(minute_NumberPicker_id);

        NumberPicker hourNumberPicker2 = (NumberPicker)tStopTime.findViewById(hour_NumberPicker_id);

        NumberPicker minuteNumberPicker2 = (NumberPicker)tStopTime.findViewById(minute_NumberPicker_id);

        setNumberPickerTextColor(hourNumberPicker1, Color.BLACK);

        setNumberPickerTextColor(hourNumberPicker2, Color.BLACK);

        setNumberPickerTextColor(minuteNumberPicker1, Color.BLACK);

        setNumberPickerTextColor(minuteNumberPicker2, Color.BLACK);



    }



    public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color) {

        final int count = numberPicker.getChildCount();



        for (int i=0;i<count;i++) {

            View child = numberPicker.getChildAt(i);

            if (child instanceof EditText) {

                try {

                    Field selectorWheelPaintField = numberPicker.getClass()

                            .getDeclaredField("mSelectorWheelPaint");

                    selectorWheelPaintField.setAccessible(true);

                    ((Paint) selectorWheelPaintField.get(numberPicker)).setColor(color);

                    ((EditText) child).setTextColor(color);

                    numberPicker.invalidate();

                    return true;

                } catch (NoSuchFieldException e) {

//Log.w("setNumberPickerTextColor", e);

                } catch (IllegalAccessException e) {

//Log.w("setNumberPickerTextColor", e);

                } catch (IllegalArgumentException e) {

//Log.w("setNumberPickerTextColor", e);

                }

            }

        }

        return false;

    }

}