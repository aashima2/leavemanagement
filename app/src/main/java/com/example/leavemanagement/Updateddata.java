package com.example.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Updateddata extends AppCompatActivity {
    Button Data;
    Button Orgdata;
    Button edited;
    Button deldata;
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateddata);

        Button logout =(Button) findViewById(R.id.btn_Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Updatedintent = new Intent(Updateddata.this,MainActivity.class);
                startActivity(Updatedintent);
                Toast.makeText(Updateddata.this, " Admin Logged Out successfully ", Toast.LENGTH_LONG).show();

            }
        });

        Button Orgdata = (Button) findViewById(R.id.btn_ViewOriginalData);
        Orgdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Updatedintent = new Intent(Updateddata.this,listing.class);
                startActivity(Updatedintent);

            }
        });



    }


}
