package com.example.tamana.airlinereservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlightsSearched extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Select Return Flight");
        setContentView(R.layout.activity_flights_searched);


        final Button returnA = (Button)findViewById(R.id.ReturnA);
        final Button returnB =(Button)findViewById(R.id.ReturnB);
        final Button returnC = (Button)findViewById(R.id.ReturnC);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        final int adults  = sharedPref.getInt("Key1",0);
        final int children = sharedPref.getInt("Key2",0);

        String To = sharedPref.getString("Key3", null);
        String From = sharedPref.getString("Key4", null);

        final String Rbn = sharedPref.getString("Key5", null);


        String DepartDate = sharedPref.getString("Key6", null);
        String ReturnDate = sharedPref.getString("Key7", null);

        String Return_time1 = sharedPref.getString("Key14", null);
        String Return_time2 = sharedPref.getString("Key15", null);
        String Return_time3 = sharedPref.getString("Key16", null);

        String Return_Duration1 = sharedPref.getString("Key17", null);
        String Return_Duration2 = sharedPref.getString("Key18", null);
        String Return_Duration3 = sharedPref.getString("Key19", null);

        String FlightButton_2A = sharedPref.getString("Key23",null);
        String FlightButton_2B = sharedPref.getString("Key24",null);
        String FlightButton_2C = sharedPref.getString("Key25",null);

        returnA.setText(FlightButton_2A+"\n"+Return_time1+"\n"+Return_Duration1+"\n"+"From: "+To+"\n"+"To: "+From);
        returnB.setText(FlightButton_2B+"\n"+Return_time2+"\n"+Return_Duration2+"\n"+"From: "+To+"\n"+"To: "+From);
        returnC.setText(FlightButton_2C+"\n"+Return_time3+"\n"+Return_Duration3+"\n"+"From: "+To+"\n"+"To: "+From);

        returnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightsSearched.this,MyAccount.class));
            }
        });

        returnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightsSearched.this,MyAccount.class));
            }
        });

        returnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightsSearched.this,MyAccount.class));
            }
        });
    }
}
