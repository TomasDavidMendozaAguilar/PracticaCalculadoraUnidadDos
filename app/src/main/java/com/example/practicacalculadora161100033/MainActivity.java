package com.example.practicacalculadora161100033;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intt = new Intent(MainActivity.this, inicio.class);
                startActivity(intt);
                finish();
            }

        }, 500);



    }
    protected void onDestroy() {
        super.onDestroy();
    }

}