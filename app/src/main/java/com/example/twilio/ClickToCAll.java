package com.example.twilio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ClickToCAll extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_to_call);

        Button callButton = findViewById(R.id.button_call);

        mQueue = Volley.newRequestQueue(this);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("================== Click ========================");
                callTwiml();
            }
        });
    }

    public void callTwiml() {
        System.out.println("================== Click to call ========================");
    }
}
