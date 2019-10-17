package com.example.tamana.airlinereservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//timerTask code begins
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish(); //finish method.
                startActivity(new Intent(MainActivity.this, BookFlight.class));//start activity launches findflights class.
            }
        };//end of Timer task

        Timer opening = new Timer(); //instance of timer

        opening.schedule(task, 7000); //timer scheduled for 5 seconds.

    }

}
