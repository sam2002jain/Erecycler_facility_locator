package com.example.erecycler;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class Welcomeactivity extends AppCompatActivity {
    String message = "hey sam!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeactivity);
        Log.e(message,"Welocme activity invoked");



    }
    public void onbuttonsignupclicked(View view){
        Intent intent = new Intent(Welcomeactivity.this, signupactivity.class);
        startActivity(intent);

    }

    public void onbuttonsigninclicked(View view){
        Intent intent = new Intent(Welcomeactivity.this, HomeActivity.class);
        startActivity(intent);

    }
}