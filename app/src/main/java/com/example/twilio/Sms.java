package com.example.twilio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.HashMap;
import java.util.Map;

public class Sms extends AppCompatActivity {

    EditText editText;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Button smsButton = findViewById(R.id.button_sms);

        mQueue = Volley.newRequestQueue(this);

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("================== Click ========================");
                sendSms();
            }
        });
    }

    public void sendSms() {
        String url = "https://rackley-octopus-5384.twil.io/outbound-sms";
        editText = (EditText) findViewById(R.id.sms_phone);
        String phoneNum = editText.getText().toString();

        System.out.println(phoneNum);

        Map<String, String> params = new HashMap();
        params.put("number", phoneNum);

        JSONObject paramenters = new JSONObject(params);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, paramenters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String success = response.getString("success");
                            System.out.println(success);
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
        });

        mQueue.add(request);
    }
}
