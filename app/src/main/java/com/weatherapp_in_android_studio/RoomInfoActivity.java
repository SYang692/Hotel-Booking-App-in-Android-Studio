package com.weatherapp_in_android_studio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class RoomInfoActivity extends AppCompatActivity {

    Calendar myCalendar;
    EditText editText, edCheckOut;
    Button button;

    Spinner spinnerType;
    String name, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");

        myCalendar = Calendar.getInstance();

        editText = (EditText) findViewById(R.id.checkIn);
        edCheckOut = (EditText) findViewById(R.id.checkOut);
        button = (Button) findViewById(R.id.preview);
        spinnerType = findViewById(R.id.spinnerType);

        DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, editText);
            }
        };

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RoomInfoActivity.this, date1, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, edCheckOut);
            }
        };

        edCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RoomInfoActivity.this, date2, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomInfoActivity.this, FinalActivity.class);
                i.putExtra("name", name);
                i.putExtra("phone", phone);
                i.putExtra("email", email);
                i.putExtra("CheckIn", editText.getText().toString());
                i.putExtra("CheckOut", edCheckOut.getText().toString());

                startActivity(i);
            }
        });


    }

    private void updateLabel(Calendar myCalendar, EditText editText){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
}