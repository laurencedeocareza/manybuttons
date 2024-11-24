package com.example.manybuttons;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pickers extends AppCompatActivity {
    private TextView pickertxt;
    private Button btnpicker;
    private TextView timetxt;
    private Button btntime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pickers);

        pickertxt = findViewById(R.id.pickerstext);
        btnpicker = findViewById(R.id.datebtn);

        timetxt = findViewById(R.id.timetxt);
        btntime = findViewById(R.id.timebtn);

        btnpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepick();

            }
        });

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void datepick() {
        DatePickerDialog datepicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                pickertxt.setText(String.valueOf(year)+"/"+String.valueOf(month+1)+"/"+String.valueOf(day));
            }
        }, 2024, 0, 1);
        datepicker.show();

        }
    private void timepicker(){
        TimePickerDialog timepicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                timetxt.setText(String.valueOf(hour)+":"+String.valueOf(minute));
            }
        }, 24, 00, true);
        timepicker.show();
    }
}