package com.example.twilio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sms extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Button smsButton = findViewById(R.id.button_sms);

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
            }
        });
    }

    public void sendSms() {
        String url = "https://rackley-octopus-5384.twil.io/outbound-sms";
        editText = (EditText) findViewById(R.id.sms_phone);
        String phoneNum = editText.getText().toString();
        System.out.println(phoneNum);
    }
}
