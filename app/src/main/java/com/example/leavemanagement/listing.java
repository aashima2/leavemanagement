package com.example.leavemanagement;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listing extends AppCompatActivity {
    LeaveDatabase ld;
    ListView ls;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.listing);
        ld = new LeaveDatabase(this);
        ls = (ListView) findViewById(R.id.Dynamic);

        ArrayList <String> List1 = new ArrayList<>();
        Cursor cursor = ld.getData();
        if(cursor.getCount() == 0){
            Toast.makeText(listing.this,"No data",Toast.LENGTH_LONG).show();
        }else{
            while(cursor.moveToNext()) {
                List1.add(cursor.getString(0));

                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List1);
                ls.setAdapter(listAdapter);
            }
        }

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor res = ld.getData();
                res.moveToPosition(position);
                Intent employeeintent =  new Intent(listing.this,Employee_Details.class);
                employeeintent.putExtra("Position", position);
                employeeintent.putExtra("A",res.getInt(0));
                employeeintent.putExtra("B",res.getString(1));
                employeeintent.putExtra("C",res.getString(2));
                employeeintent.putExtra("D",res.getString(3)); // changes made
                startActivity(employeeintent);
            }
        });

    }
}
