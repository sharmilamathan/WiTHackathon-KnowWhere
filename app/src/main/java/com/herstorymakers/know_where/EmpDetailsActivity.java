package com.herstorymakers.know_where;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class EmpDetailsActivity extends AppCompatActivity {

    Button btnHome;
    String JString = "";
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_details);

        btnHome = findViewById((R.id.idHome));
        data = (TextView) findViewById(R.id.idEmpDetails);

        fetchData process = new fetchData();
        process.execute();

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeintent = new Intent(EmpDetailsActivity.this, HomeActivity.class);
                startActivity(homeintent);
            }
        });

    }
}