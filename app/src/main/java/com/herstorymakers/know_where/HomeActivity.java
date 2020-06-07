package com.herstorymakers.know_where;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnEmpDetails;
    Button btnChat;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnEmpDetails = findViewById((R.id.idEmpDetails));
        btnChat = findViewById((R.id.idChat));
        btnLogout = findViewById(R.id.idlogout);

        btnEmpDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent empdetailsintent = new Intent(HomeActivity.this, EmpDetailsActivity.class);
                startActivity(empdetailsintent);
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "https://web-chat.global.assistant.watson.cloud.ibm.com/preview.html?region=eu-gb&integrationID=16e1daea-04c2-43dc-9378-60a7429120b4&serviceInstanceID=6d19775f-c7bb-44a0-9ac6-5d3cf3f9bd21";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}