package com.example.leavemanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Empleaves extends AppCompatActivity {
    Button navigate1;

    Button insert;

    int a1;
    int d1;

    int  b1;
    String c1;
    LeaveDatabase ld;
    Intent LeaveDetails1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleaves);
        TextView txt4 = (TextView) findViewById(R.id.txtID); //changed

        TextView txt1 = (TextView) findViewById(R.id.txtStartdate);
        TextView txt2 = (TextView) findViewById(R.id.txtEnddate);
        TextView txt3 = (TextView)  findViewById(R.id.txtReason);


        ld =  new LeaveDatabase(this);

        Cursor res = ld.getData1();
        Intent intent = getIntent();
        if(intent != null) {
            d1 = intent.getIntExtra("D",0);//changed

           a1 = intent.getIntExtra("A", 0);
           b1 = intent.getIntExtra("B" ,0);
            c1 = intent.getStringExtra("C");

        }

        txt4.setText(d1 + "");// changed
        txt1.setText(a1 + "");
        txt2.setText(b1 + "");
        txt3.setText(c1);

        final int pos = intent.getIntExtra("Position", 0);


        Button navigate1 = (Button) findViewById(R.id.btn_navigate1);
        navigate1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              
                Cursor res = ld.getData1();
                res.moveToPosition(pos);
               Intent  LeaveDetails= new Intent(Empleaves.this, LeavesDetails.class);
                Log.d("ajeb", "onClick: "+res.getInt(0));
                LeaveDetails.putExtra("D", res.getInt(0));// changed
                LeaveDetails.putExtra("A",res.getInt(1));
                LeaveDetails.putExtra("B",res.getInt(2));
                LeaveDetails.putExtra("C",res.getString(3));

                startActivity(LeaveDetails);

            }
        });


    }
}
