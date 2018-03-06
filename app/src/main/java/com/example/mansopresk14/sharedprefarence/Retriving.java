package com.example.mansopresk14.sharedprefarence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;



public class Retriving extends AppCompatActivity {
    TextView et1,et2,et3,et4,et5;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retriving);
        et1=(TextView)findViewById(R.id.firsttName);
        et2=(TextView)findViewById(R.id.Lastname);
        et3=(TextView)findViewById(R.id.TextEmail);
        et4=(TextView)findViewById(R.id.TextPassword);
        et5=(TextView)findViewById(R.id.TextMobile);
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String fname  = sharedpreferences.getString("Name",null);
        String lname  = sharedpreferences.getString("laName",null);
        String mail = sharedpreferences.getString("Phone",null);
        String pass  =  sharedpreferences.getString("Email",null);
        String number  =  sharedpreferences.getString("pwd",null);
        et1.setText(fname);
        et2.setText(lname);
        et3.setText(mail);
        et4.setText(pass);
        et5.setText(number);





    }
}
