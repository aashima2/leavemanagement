package com.example.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminFunctions extends AppCompatActivity {
    Button u_add;

    Button  Leaverequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functions);

        Button u_add = (Button) findViewById(R.id.u_Add);
        u_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Updatedintent = new Intent (AdminFunctions.this,UsersActivity.class);
                startActivity(Updatedintent);
            }
        });

        Button Leaverequest  = (Button) findViewById(R.id.edLeaverequest);
        Leaverequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Updatedintent = new Intent (AdminFunctions.this,UsersnameListing.class);
                startActivity(Updatedintent);


            }
        });


    }
}
