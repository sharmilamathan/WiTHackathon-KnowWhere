package com.herstorymakers.know_where;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    String firstUsername = "admin";
    String corrPassword = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById((R.id.idUsername));
        password = findViewById(R.id.idPassword);
        btnLogin = findViewById((R.id.idLogin));

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Empty data provided", Toast.LENGTH_LONG).show();
                }else if(username.getText().toString().equals((firstUsername))){
                     if(password.getText().toString().equals((corrPassword)))
                     {
                         Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                         startActivity(intent);
                     }
                     else{
                         Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_LONG).show();
                     }
                }else{
                    Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}