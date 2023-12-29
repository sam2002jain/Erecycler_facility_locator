package com.example.erecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class splashactivity extends AppCompatActivity {
    String message = "hello sam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        Log.e(message,"splash activity runs");

        TextView textView = findViewById(R.id.txtviewSplash);
        textView.animate().translationX(2000).setDuration(2000).setStartDelay(1500);
        Thread thread = new Thread(){
            public void run(){
                try{
                    Thread.sleep(4000);
                }catch(Exception e){
                    e.printStackTrace();
                }

                finally{
                    Intent intent = new Intent(splashactivity.this, Welcomeactivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };
        thread.start();


    }
}