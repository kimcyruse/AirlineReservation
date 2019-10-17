package com.example.tamana.airlinereservation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class BookFlight extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String Rbn;

    EditText No_Adults,No_Children;
   private TextView DepartingDate, ReturningDate;
    Button ChooseLeavingDate,ChooseReturningDate, SearchFlights;
    Spinner To, From;
    RadioButton Return, OneWay;
    private SharedPreferences sharedPref;
   Integer TotalChildren,TotalAdults;
String ReturnChoice, DepartChoice;
    String airport[] = null;
    String DepartureLocation, ArrivalLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTitle("Enter Flight Details");
        setContentView(R.layout.activity_book_flight);

         ChooseLeavingDate = (Button)findViewById(R.id.buttonLeavingDate);
         ChooseReturningDate = (Button)findViewById(R.id.buttonReturningDate);

        DepartingDate = (TextView)findViewById(R.id.textViewDeparting);
        ReturningDate = (TextView)findViewById(R.id.textViewreturning);

         To = (Spinner)findViewById(R.id.spinnerfromairportcodes);
         From = (Spinner)findViewById(R.id.spinnertoairportcodes);
        No_Children = (EditText) findViewById(R.id.editTextChildren);
        No_Adults = (EditText) findViewById(R.id.editTextAdultsNo);
        SearchFlights = (Button)findViewById(R.id.buttonSearchFlights);
        Return = (RadioButton)findViewById(R.id.radioButtonReturn);
        OneWay = (RadioButton)findViewById(R.id.radioButtonOneWay);

sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
//
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChooseLeavingDate.setVisibility(View.VISIBLE);
                ChooseReturningDate.setVisibility(View.VISIBLE);
                DepartingDate.setVisibility(View.VISIBLE);
                ReturningDate.setVisibility(View.VISIBLE);
            }
        });

        OneWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChooseLeavingDate.setVisibility(View.VISIBLE);
                ChooseReturningDate.setVisibility(View.GONE);
                DepartingDate.setVisibility(View.VISIBLE);
                ReturningDate.setVisibility(View.GONE);


            }
        });


        To.setOnItemSelectedListener(this);


     /*
      *
       ****************************************************
               On Click Listener Button Search Flights.
     ******************************************************
     *
     *
     * */


     SearchFlights.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             //edittext box
             TotalAdults = Integer.parseInt(No_Adults.getText().toString());
             TotalChildren = Integer.parseInt(No_Children.getText().toString());

             //Spinner
             DepartureLocation = From.getSelectedItem().toString();
             ArrivalLocation = To.getSelectedItem().toString();

             //Radiobutton
          //   RbnReturn = Return.getText().toString();
            // RbnOneway = OneWay.getText().toString();

             String Depart_time1 = "7:45am - 12:22pm                 C$568";
             String Depart_time2 = "8:55am - 11:24am                C$552";
             String Depart_time3 = "12:40pm - 3:09pm                 C$552";

             String Depart_Duration1 = "1h27m(Nonstop)";
             String Depart_Duration2 = "1h29m(Nonstop)";
             String Depart_Duration3 = "1h29m(Nonstop)";


             String Return_time1 = "7:45pm - 8:45pm                 C$568";
             String Return_time2 = "6:55pm - 9:24pm                C$552";
             String Return_time3 = "7:40am - 11:32am                 C$552";

             String Return_Duration1 = "1h33m(Nonstop)";
             String Return_Duration2 = "1h29m(Nonstop)";
             String Return_Duration3 = "1h29m(1 Stop, YLW)";

             String FlightButton_1A = "LH1010";
             String FlightButton_1B = "CA3425";
             String FlightButton_1C = "WE1290";

             String FlightButton_2A = "KLM32";
             String FlightButton_2B = "SC4587";
             String FlightButton_2C = "JK400";


             if(Return.isChecked())
             {

                 if (TotalAdults<=6 && TotalChildren<=6)
                 {
                     Rbn = "Return";
                     SharedPreferences.Editor editor = sharedPref.edit();
                     editor.putInt("Key1",TotalAdults);
                     editor.putInt("Key2", TotalChildren);
                     editor.putString("Key3", DepartureLocation);
                     editor.putString("Key4", ArrivalLocation);
                     editor.putString("Key5",Rbn);

                     editor.putString("Key8",Depart_time1);
                     editor.putString("Key9",Depart_time2);
                     editor.putString("Key10",Depart_time3);
                     editor.putString("Key11",Depart_Duration1);
                     editor.putString("Key12",Depart_Duration2);
                     editor.putString("Key13",Depart_Duration3);

                     editor.putString("Key14",Return_time1);
                     editor.putString("Key15",Return_time2);
                     editor.putString("Key16",Return_time3);
                     editor.putString("Key17",Return_Duration1);
                     editor.putString("Key18",Return_Duration2);
                     editor.putString("Key19",Return_Duration3);

                     editor.putString("Key20", FlightButton_1A);
                     editor.putString("Key21", FlightButton_1B);
                     editor.putString("Key22", FlightButton_1C);

                     editor.putString("Key23", FlightButton_2A);
                     editor.putString("Key24", FlightButton_2B);
                     editor.putString("Key25", FlightButton_2C);

                     editor.commit();

                     //Toast.makeText(BookFlight.this, TotalAdults+TotalChildren+DepartureLocation+ArrivalLocation+Rbn,Toast.LENGTH_LONG).show();

                     startActivity(new Intent(BookFlight.this,BookingConfirmation.class));
                 }
                 else {
                     Toast.makeText(BookFlight.this,"Maximum you can buy tickets is 6",Toast.LENGTH_LONG).show();
                 }
             }

             if(OneWay.isChecked())
             {
                 if(TotalAdults<=6 && TotalChildren<=6)
                 {
                     Rbn = "One Way";
                     SharedPreferences.Editor editor = sharedPref.edit();
                     editor.putInt("Key1",TotalAdults);
                     editor.putInt("Key2", TotalChildren);
                     editor.putString("Key3", DepartureLocation);
                     editor.putString("Key4", ArrivalLocation);
                     editor.putString("Key5",Rbn);

                     editor.putString("Key8",Depart_time1);
                     editor.putString("Key9",Depart_time2);
                     editor.putString("Key10",Depart_time3);
                     editor.putString("Key11",Depart_Duration1);
                     editor.putString("Key12",Depart_Duration2);
                     editor.putString("Key13",Depart_Duration3);

                     editor.putString("Key14",Return_time1);
                     editor.putString("Key15",Return_time2);
                     editor.putString("Key16",Return_time3);
                     editor.putString("Key17",Return_Duration1);
                     editor.putString("Key18",Return_Duration2);
                     editor.putString("Key19",Return_Duration3);

                     editor.putString("Key20", FlightButton_1A);
                     editor.putString("Key21", FlightButton_1B);
                     editor.putString("Key22", FlightButton_1C);

                     editor.putString("Key23", FlightButton_2A);
                     editor.putString("Key24", FlightButton_2B);
                     editor.putString("Key25", FlightButton_2C);

                     editor.commit();

                    // Toast.makeText(BookFlight.this, TotalAdults+TotalChildren+DepartureLocation+ArrivalLocation+Rbn,Toast.LENGTH_LONG).show();
                     startActivity(new Intent(BookFlight.this,BookingConfirmation.class));
                 }
                 else {
                     Toast.makeText(BookFlight.this,"Maximum you can purchase tickets is 6",Toast.LENGTH_LONG).show();
                 }


             }




            // startActivity(new Intent(BookFlight.this,BookingConfirmation.class));





         }
     });


     /*
       * //Leaving Date on click listener
       * */
        ChooseLeavingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment dialogFragment = new DatePickerFragmentLeaving();
                dialogFragment.show(getFragmentManager(), "Date Picker");

            }
        });

/*
/Returning Date on Click Listener
 */
        ChooseReturningDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new DatePickerFragmentReturning();
                dialogFragment.show(getFragmentManager(), "Date Picker");
            }
        });


    }//On Create Bundle Instance
/*
*
*
* //Departing Date
 *
 *
 *
 * */
    public static class DatePickerFragmentLeaving extends DialogFragment implements DatePickerDialog.OnDateSetListener {


        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),this,year,month,day);
            calendar.add(Calendar.DATE,60);
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            calendar.add(Calendar.DATE,-60);
            datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
            return datePickerDialog;

        }
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
          final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

           TextView DepartingDate = (TextView)getActivity().findViewById(R.id.textViewDeparting);
            //TextView result = (TextView)getActivity().findViewById(R.id.textViewAnswer);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);
            cal.set(year,month,day,0,0,0);
            Date date = cal.getTime();

            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
            String fmtDate = dateFormat.format(date);
            DepartingDate.setText("" + fmtDate);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("Key6",fmtDate);
            editor.commit();



        }
    }

  /*
    *
    *
    *
    * //Returning Date
     *
     *
     *
     * */

    public static class DatePickerFragmentReturning extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),this,year,month,day);
            calendar.add(Calendar.DATE,60);
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            calendar.add(Calendar.DATE,-60);
            datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
            return datePickerDialog;

        }
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

            TextView ReturningDate = (TextView)getActivity().findViewById(R.id.textViewreturning);
            //TextView result = (TextView)getActivity().findViewById(R.id.textViewAnswer);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);
            cal.set(year,month,day,0,0,0);
            Date date = cal.getTime();

            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
            String fmtDate = dateFormat.format(date);
            ReturningDate.setText("" + fmtDate);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("Key7",fmtDate);
            editor.commit();

        }
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(l==0)//Vancouver
        {
            airport = new String[]{"YRV Revelstoke Airport",
                    "YPR Prince Rupert Airport",
                    "YLW Kelowna International Airport",
                    "YJA Jasper Airport",
                    "YEG Edmonton International Airport"};
        }
        if(l==1)//Revelstoke
        {
            airport = new String[]{"YVR Vancouver International Airport",
                    "YPR Prince Rupert Airport",
                    "YLW Kelowna International Airport",
                    "YJA Jasper Airport",
                    "YEG Edmonton International Airport"};
        }
        if(l==2)//Prince Rupert
        {
            airport = new String[]{"YVR Vancouver International Airport",
                    "YRV Revelstoke Airport",
                    "YLW Kelowna International Airport",
                    "YJA Jasper Airport",
                    "YEG Edmonton International Airport"};
        }
        if(l==3)//kelowna
        {
            airport = new String[]{"YVR Vancouver International Airport",
                    "YPR Prince Rupert Airport",
                    "YRV Revelstoke Airport",
                    "YJA Jasper Airport",
                    "YEG Edmonton International Airport"};
        }
        if(l==4)//jasper
        {
            airport = new String[]{"YVR Vancouver International Airport",
                    "YPR Prince Rupert Airport",
                    "YLW Kelowna International Airport",
                    "YRV Revelstoke Airport",
                    "YEG Edmonton International Airport"};
        }
        if(l==5)//Edmonton
        {
            airport = new String[]{"YVR Vancouver International Airport",
                    "YPR Prince Rupert Airport",
                    "YLW Kelowna International Airport",
                    "YJA Jasper Airport",
                    "YRV Revelstoke Airport"};
        }

        ArrayAdapter<String> adt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,airport);
        From.setAdapter(adt);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}
