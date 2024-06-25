package com.weatherapp_in_android_studio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    String name, email, phone;
    String roomType, CheckinDate, CheckoutDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView textView = findViewById(R.id.tv1);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        CheckinDate = getIntent().getStringExtra("CheckIn");
        CheckoutDate = getIntent().getStringExtra("CheckOut");

        textView.setText(
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "CheckinDate: " + CheckinDate + "\n" +
                "CheckoutDate: " + CheckoutDate + "\n"
        );
    }
}