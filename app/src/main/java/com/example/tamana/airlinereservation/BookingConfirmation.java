package com.example.tamana.airlinereservation;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookingConfirmation extends Activity implements View.OnClickListener{

    double CostB = 552;
    double CostC = 552;
   Button a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Select Flight");
        setContentView(R.layout.activity_booking_confirmation);
        a = (Button) findViewById(R.id.A);
       b = (Button) findViewById(R.id.B);
         c = (Button) findViewById(R.id.C);

      //  final Button ConfirmTicket = (Button)findViewById(R.id.buttonConfirmTicket);
        final TextView FlightDetails = (TextView)findViewById(R.id.textViewFlightDetails);




        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        final int adults  = sharedPref.getInt("Key1",0);
        final int children = sharedPref.getInt("Key2",0);

        String To = sharedPref.getString("Key3", null);
        String From = sharedPref.getString("Key4", null);

        final String Rbn = sharedPref.getString("Key5", null);


        String DepartDate = sharedPref.getString("Key6", null);
        String ReturnDate = sharedPref.getString("Key7", null);




        String Flight_time1 = sharedPref.getString("Key8", null);
        String Flight_time2 = sharedPref.getString("Key9", null);
        String Flight_time3 = sharedPref.getString("Key10", null);

        String Flight_Duration1 = sharedPref.getString("Key11", null);
        String Flight_Duration2 = sharedPref.getString("Key12", null);
        String Flight_Duration3 = sharedPref.getString("Key13", null);

        String FlightButton_1A = sharedPref.getString("Key20",null);
        String FlightButton_1B = sharedPref.getString("Key21",null);
        String FlightButton_1C = sharedPref.getString("Key22",null);

        String FlightButton_2A = sharedPref.getString("Key23",null);
        String FlightButton_2B = sharedPref.getString("Key24",null);
        String FlightButton_2C = sharedPref.getString("Key25",null);


        a.setText(FlightButton_1A+"\n"+Flight_time1+"\n"+Flight_Duration1+"\n"+"From: "+From+"\n"+"To: "+To);
        b.setText(FlightButton_1B+"\n"+Flight_time2+"\n"+Flight_Duration2+"\n"+"From: "+From+"\n"+"To: "+To);
        c.setText(FlightButton_1C+"\n"+Flight_time3+"\n"+Flight_Duration3+"\n"+"From: "+From+"\n"+"To: "+To);



a.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(Rbn.equals("Return"))
        {

            startActivity(new Intent(BookingConfirmation.this,FlightsSearched.class));
        }
else {
            startActivity(new Intent(BookingConfirmation.this, MyAccount.class));

        }

    }
});

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rbn.equals("Return"))
                {
                    startActivity(new Intent(BookingConfirmation.this,FlightsSearched.class));
                }
                else {
startActivity(new Intent(BookingConfirmation.this, MyAccount.class));
                }

            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rbn.equals("Return"))
                {
                    startActivity(new Intent(BookingConfirmation.this,FlightsSearched.class));
                }
                else {
                    startActivity(new Intent(BookingConfirmation.this, MyAccount.class));
                }

            }
        });




    }


    @Override
    public void onClick(View view) {

    }
}
