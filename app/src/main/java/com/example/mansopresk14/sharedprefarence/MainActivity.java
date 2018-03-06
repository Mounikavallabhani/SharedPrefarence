package com.example.mansopresk14.sharedprefarence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstname, password;
    Button register;

    SharedPreferences sharedpreferences;
    // public static final String MyPREFERENCES = ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = (EditText) findViewById(R.id.edifirsttName);
        password = (EditText) findViewById(R.id.editTextPassword);
        register = (Button) findViewById(R.id.buttonSubmit);
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String uname = sharedpreferences.getString("Name", null);
        if (uname != null) {
            Intent it = new Intent(MainActivity.this, NavActivity.class);
            startActivity(it);


        }




    }

    public void login(View v) {
        if (firstname.getText().toString().isEmpty()) {
            firstname.requestFocus();
            firstname.setError("");
        } else if (password.getText().toString().isEmpty()) {
            password.requestFocus();
            password.setError("");

        } else {
            String fname = firstname.getText().toString();

            String pass = password.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("Name", fname);
            editor.putString("pwd", pass);
            editor.commit();

//            if (sharedpreferences != null) {
                Intent it = new Intent(MainActivity.this, NavActivity.class);
                startActivity(it);


            }
        }
    }




