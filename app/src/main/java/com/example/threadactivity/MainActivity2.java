package com.example.threadactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Switch switch1;
    Button btn2;
    TextView tv2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        switch1 = findViewById(R.id.switch1);
        btn2 = findViewById(R.id.btn2);
        tv2 = findViewById(R.id.tv2);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Thread Name 2", Thread.currentThread().getName());
                        synchronized (this){
                            try {
                                wait(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv2.setText("This is running "+ Thread.currentThread().getName());
                            }
                        });



                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity2.this, "This is " + Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
                            }
                        },10000);
   //                     tv2.setText("This is running "+ Thread.currentThread().getName());
    //                    Log.i("Download","download successfull");
                    }
                };
   //             runnable.run();
   //             Log.i("Thread Name 1", Thread.currentThread().getName());
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });

    }
}