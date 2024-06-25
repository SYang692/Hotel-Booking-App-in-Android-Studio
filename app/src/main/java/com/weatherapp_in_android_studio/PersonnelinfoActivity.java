package com.weatherapp_in_android_studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonnelinfoActivity extends AppCompatActivity {

    Button savebtn;
    EditText personName;
    EditText phone;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnelinfo);

        savebtn = findViewById(R.id.saveButton);
        personName = findViewById(R.id.personName);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.emailAddress);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonnelinfoActivity.this, RoomInfoActivity.class);
                i.putExtra("name", personName.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                i.putExtra("email", email.getText().toString());
                startActivity(i);
            }
        });

    }
}