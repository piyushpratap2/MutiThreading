package com.example.threadactivity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView tv1,tv2;

    @SuppressLint({"MissingInflatedId", "LongLogTag"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));

            }
        });


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int x= 24;
                int y = 12;
                int z = x/y;
                tv1.setText("dividation is " + z + " " + Thread.currentThread().getName());
            }

        };


        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                int x= 24;
                int y= 12;
                int z = x+y;
                tv2.setText("addition is " + z + " "+ Thread.currentThread().getName());

            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();


        Thread thread2 = new Thread(runnable2);
        thread2.start();



    }

    

}