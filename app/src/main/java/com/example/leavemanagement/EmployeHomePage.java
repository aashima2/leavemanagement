package com.example.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class EmployeHomePage extends AppCompatActivity {
    Button logout;
    Button insert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_home_page);

        Button insert = (Button) findViewById(R.id.Insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leavesintent = new Intent(EmployeHomePage.this,EmpListing.class);
                startActivity(leavesintent);

            }
        });
        Button logout = (Button) findViewById(R.id.btn_emploggedout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Updatedintent = new Intent(EmployeHomePage.this,MainActivity.class);
                startActivity(Updatedintent);
            }
        });
    }
}
