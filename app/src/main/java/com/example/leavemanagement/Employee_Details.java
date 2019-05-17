package com.example.leavemanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Employee_Details extends AppCompatActivity {

    Button insert;

     int a;
     String b;
     String c;
     String d;// changes made
     LeaveDatabase ld;
     Intent detailintent1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        TextView t1 = (TextView) findViewById(R.id.txt1);
        TextView t2 = (TextView) findViewById(R.id.txt2);
        TextView t3 = (TextView) findViewById(R.id.txt3);
        TextView t4 = (TextView)  findViewById(R.id.txt4); // changes made



        ld =  new LeaveDatabase(this);

        Cursor res = ld.getData();
        Intent intent = getIntent();
        if(intent != null) {
            a = intent.getIntExtra("A", 0);
            b = intent.getStringExtra("B");
            c = intent.getStringExtra("C");
            d = intent.getStringExtra("D");// changes made

        }

       t1.setText(a + "");
       t2.setText(b);
       t3.setText(c);
       t4.setText(d);//changes made

      final int pos = intent.getIntExtra("Position", 0);


         insert = (Button) findViewById(R.id.btn_navigate);
         insert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                Cursor res = ld.getData();
                 res.moveToPosition(pos);
                  detailintent1 = new Intent(Employee_Details.this, Detail1.class);
                 detailintent1.putExtra("A",res.getInt(0));
                 detailintent1.putExtra("B",res.getString(1));
                 detailintent1.putExtra("C",res.getString(2));
                 detailintent1.putExtra("D",res.getString(3));// changes made
                 startActivity(detailintent1);
                 Toast.makeText(Employee_Details.this,"navigated",Toast.LENGTH_LONG).show();


             }
         });



    }
}
