package com.example.mansopresk14.sharedprefarence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistraionPage extends AppCompatActivity {
    EditText firstname,lastname,username,paswword,email,repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion_page);
        firstname=(EditText)findViewById(R.id.edtfirstname);
        lastname=(EditText)findViewById(R.id.edtlastname);
        username=(EditText)findViewById(R.id.edtUsername);
        paswword=(EditText)findViewById(R.id.edtpas);
        repassword=(EditText)findViewById(R.id.edtConfirmPass);
        email=(EditText)findViewById(R.id.edtEmail);
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
    }

    public void register(View v) {
        if (firstname.getText().toString().isEmpty()) {
            firstname.requestFocus();
            firstname.setError("");
        } else if (lastname.getText().toString().isEmpty()) {
            lastname.requestFocus();
            lastname.setError("");

        }
        else if (username.getText().toString().isEmpty()) {
            username.requestFocus();
            username.setError("");

        }
        else if (paswword.getText().toString().isEmpty()) {
            paswword.requestFocus();
            paswword.setError("");

        }
        else if (repassword.getText().toString().isEmpty()) {
            repassword.requestFocus();
            repassword.setError("");

        }
        else if (email.getText().toString().isEmpty()) {
            email.requestFocus();
            email.setError("");

        } else {
            Intent it = new Intent(RegistraionPage.this, MainActivity.class);
            startActivity(it);


        }
    }
}
