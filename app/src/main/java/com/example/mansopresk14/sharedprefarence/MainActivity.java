package com.example.mansopresk14.sharedprefarence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView register = (TextView) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String uname = sharedPreferences.getString("Name", null);

        if (uname != null) {
            Intent intent = new Intent(MainActivity.this, NavActivity.class);
            startActivity(intent);
        }


        register.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               Intent it = new Intent(MainActivity.this, RegistraionPage.class);
                startActivity(it);
            }
        });
   }

    public void login(View v) {
        if (username.getText().toString().isEmpty()) {
            username.requestFocus();
            username.setError("");
        } else if (password.getText().toString().isEmpty()) {
            password.requestFocus();
            password.setError("");

        } else {
            String fname = username.getText().toString();

            String pass = password.getText().toString();
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name", fname);
            editor.putString("pwd", pass);
            editor.commit();


            Intent it = new Intent(MainActivity.this, NavActivity.class);
            startActivity(it);
        }
    }
}




