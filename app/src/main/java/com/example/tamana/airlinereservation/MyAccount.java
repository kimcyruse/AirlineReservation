package com.example.tamana.airlinereservation;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaCodec;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.id.message;

/**
 * C stands for Customer, i.e. Customer First Name, Customer Last Name, Customer Email, Phone.
 */
public class MyAccount extends AppCompatActivity {

DatabaseHelper CustomerDB;

Button Register, RegisteredInfo;
    EditText FName, LName,Email,Phone;
    Spinner title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registration");
        setContentView(R.layout.activity_my_account);



        CustomerDB = new DatabaseHelper(this);

         title = (Spinner) findViewById(R.id.spinner);
         FName = (EditText) findViewById(R.id.editTextFirstName);
        LName = (EditText) findViewById(R.id.editTextLastName);
         Email = (EditText) findViewById(R.id.editTextEmail);
        Phone = (EditText) findViewById(R.id.editTextPhone);
        Register = (Button) findViewById(R.id.buttonRegister);
         RegisteredInfo = (Button) findViewById(R.id.buttonShowData);

AddData();
       // Viewdata();

        RegisteredInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAccount.this, SelectedFlightDetails.class));
            }
        });
    }


    private boolean isValidFirstName(String F_Name)
    {
        if (F_Name != null)
        {
            return true;
        }
        return false;
    }

    private boolean isValidLastName(String L_Name)
    {
        if (L_Name != null)
        {
            return true;
        }
        return false;
    }
    private boolean isValidEmail(String E_mail)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(E_mail);
        return matcher.matches();
    }

    public boolean isValidPhone(String number)
    {
        return android.util.Patterns.PHONE.matcher(number).matches();
    }



    public void AddData() {
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean validFName = true;
                boolean validLName = true;
                boolean validPhone = true;
                boolean validEmail = true;


                String nametitle = title.getSelectedItem().toString();
                String firstname = FName.getText().toString();
                String lastname = LName.getText().toString();
                String phonenumber = Phone.getText().toString();
                String custEmail = Email.getText().toString();


                if(firstname.trim().length() == 0)
                {
                    FName.setError("Please Enter First Name");
                    validFName = false;
                }
                if(lastname.trim().length() == 0)
                {
                    LName.setError("Please Enter Last Name");
                    validLName= false;
                }
                if(!isValidEmail(custEmail))
                {
                    Email.setError("Invalid Email");
                    validEmail = false;
                }
                if(!isValidPhone(phonenumber))
                {
                    Phone.setError("Invalid Phone");
                    validPhone = false;
                }

                if(validFName && validLName && validEmail && validPhone)
                {
                    boolean insertData = CustomerDB.addData(nametitle, firstname, lastname, phonenumber, custEmail);

                    if(insertData == true)
                    {
                        Toast.makeText(MyAccount.this, "Registered Successfully!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MyAccount.this,"Something went wrong ", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });




    }



/*

    public void Viewdata()
    {
        RegisteredInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = CustomerDB.showData();

                if(data.getCount() == 0)
                {
                    //meesage
                    display("No Record Found","");
                    return;

                }

                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext())
                {
                    buffer.append("ID: " + data.getString(0) + "\n");
                    buffer.append("Name: " +data.getString(1)+"\t"+  data.getString(2)+"\t"+ data.getString(3) + "\n");
                    buffer.append("Phone: " + data.getString(4) + "\n");
                    buffer.append("Email: " +data.getString(5) + "\n");

                    display("Customer's Information: ", buffer.toString());

                    //message

                  //  display("Error", "No Data Found.");
                    //return;
                }
            }
        });
    }

    public void display(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
*/
}
