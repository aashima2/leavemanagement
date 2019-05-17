package com.example.leavemanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmpListing extends AppCompatActivity {

    LeaveDatabase ld;
    ListView ls1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_listing);

        ld = new LeaveDatabase(this);
        ls1 = (ListView) findViewById(R.id._Empdynamic);

        ArrayList<String> List2 = new ArrayList<>();
        Cursor cursor = ld.getData1();
        if (cursor.getCount() == 0) {
            Toast.makeText(EmpListing.this, "No data", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                List2.add(cursor.getString(0));

                ListAdapter listAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, List2);
                ls1.setAdapter(listAdapter1);
            }
        }

        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor res = ld.getData1();
                res.moveToPosition(position);
                Intent empintent =  new Intent(EmpListing.this,Empleaves.class);
                empintent .putExtra("Position", position);
                empintent .putExtra("D",res.getInt(0));
                empintent .putExtra("A",res.getInt(1));
                empintent .putExtra("B",res.getInt(2));
                empintent .putExtra("C",res.getString(3));
                startActivity(empintent);
            }
        });


    }
}
