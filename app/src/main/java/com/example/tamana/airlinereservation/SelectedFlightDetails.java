package com.example.tamana.airlinereservation;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SelectedFlightDetails extends AppCompatActivity {
    DatabaseHelper CustomerDB;
    private TextView CustomerInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Flight Summary");
        setContentView(R.layout.activity_selected_flight_details);

        CustomerDB = new DatabaseHelper(this);

        CustomerInfo = (TextView)findViewById(R.id.textViewCustomerInfor);

        final TextView DepartDateDisplay = (TextView)findViewById(R.id.textViewDepartedFlightDate);
        final TextView fromDisplay = (TextView)findViewById(R.id.textViewTo);
        final TextView toDisplay = (TextView)findViewById(R.id.textViewFrom);
        final TextView DepartTime = (TextView)findViewById(R.id.textViewFlight_Time);
        final TextView DepartDuration = (TextView)findViewById(R.id.textViewFlight_Duration);

        final TextView ReturnDateDisplay =(TextView)findViewById(R.id.textViewReturnDetails);
        final TextView FromDisplay = (TextView)findViewById(R.id.textViewReturnFrom);
        final TextView ToDisplay = (TextView)findViewById(R.id.textViewReturnTo);
        final TextView ReturnTime = (TextView)findViewById(R.id.textViewReturnTime);
        final TextView ReturnDuration = (TextView)findViewById(R.id.textViewReturnDuration);



        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        final int adults  = sharedPref.getInt("Key1",0);
        final int children = sharedPref.getInt("Key2",0);
       final String From = sharedPref.getString("Key3", null);
        final String To = sharedPref.getString("Key4", null);
        final String Rbn = sharedPref.getString("Key5", null);
        final String DepartDate = sharedPref.getString("Key6", null);
        final String ReturnDate = sharedPref.getString("Key7", null);

        final String Flight_time1 = sharedPref.getString("Key8", null);
        final String Flight_time2 = sharedPref.getString("Key9", null);
        final String Flight_time3 = sharedPref.getString("Key10", null);
        final String Flight_Duration1 = sharedPref.getString("Key11", null);
        final String Flight_Duration2 = sharedPref.getString("Key12", null);
        final  String Flight_Duration3 = sharedPref.getString("Key13", null);

        final String Return_time1 = sharedPref.getString("Key14", null);
        final String Return_time2 = sharedPref.getString("Key15", null);
        final String Return_time3 = sharedPref.getString("Key16", null);
        final  String Return_Duration1 = sharedPref.getString("Key17", null);
        final  String Return_Duration2 = sharedPref.getString("Key18", null);
        final  String Return_Duration3 = sharedPref.getString("Key19", null);


        if(ReturnDate != null) {
            DepartDateDisplay.setText("" + DepartDate);
            fromDisplay.setText("From           " + To);
            toDisplay.setText("To               " + From);

            DepartTime.setText("" + Flight_time3);
            DepartDuration.setText("" + Flight_Duration3);
            Viewdata();

            ReturnDateDisplay.setText("" + ReturnDate);
            FromDisplay.setText("From           " + From);
            ToDisplay.setText("To               " + To);
            ReturnTime.setText("" + Flight_time1);
            ReturnDuration.setText("" + Flight_Duration1);
            Viewdata();
        }
        else
        {
            DepartDateDisplay.setText("" + DepartDate);
            fromDisplay.setText("From           " + To);
            toDisplay.setText("To               " + From);

            DepartTime.setText("" + Flight_time3);
            DepartDuration.setText("" + Flight_Duration3);
            Viewdata();
        }


    }

    private void Viewdata() {
        Cursor data = CustomerDB.showData();

        if(data.getCount() == 0)
        {
            //meesage
            Toast.makeText(SelectedFlightDetails.this,"No Registration Found",Toast.LENGTH_LONG).show();
            return;

        }

        while (data.moveToNext())
        {
        CustomerInfo.setText("eticket Confirmation  "+"PNR34519"+data.getString(0)+"\n"+
                                "Name: "+data.getString(1)+"\t"+  data.getString(2)+"\t"+ data.getString(3) + "\n"+
                                "Phone: "+data.getString(4)+"\n"+
                                "Email: "+data.getString(5));
    }}
}
