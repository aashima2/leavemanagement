package com.example.leavemanagement;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Status extends AppCompatActivity {

    LeaveDatabase ld;
    ListView ls2;
    String  Approveid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        final String name = getIntent().getStringExtra("name");
        Approveid = getIntent().getStringExtra("id");
        Toast.makeText(this, "id" + Approveid, Toast.LENGTH_SHORT).show();
        ld = new LeaveDatabase(this);
        ls2 = (ListView) findViewById(R.id.approvename);

//        String name = ld.getApproveStatusName("name"){
//            if(name.equals(null)){
//
//            Toast.makeText(Status.this,"No data",Toast.LENGTH_LONG).show();
//        }else{
//                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List);
//                 ls2.setAdapter(listAdapter);
//            }
//
//        }

        Cursor Name = ld.getApproveStatusName("name");
        List <String> List= new ArrayList<>();
        while(Name.moveToNext()){
            if(Name.getString(0).equals(Approveid)){
                //  List.add Name.getString(1);
                  List.add(Name.getString(1));
            Toast.makeText(this, "id" + Name.getString(0), Toast.LENGTH_SHORT).show();
                if( List.isEmpty()){
                    Toast.makeText(this, "No  data", Toast.LENGTH_SHORT).show();
                }
//                else{
//                    Toast.makeText(this, "Error in adding data", Toast.LENGTH_SHORT).show();
//                }
            }
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List);
        ls2.setAdapter(listAdapter);



        ls2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // put the data of Showingstatus and get it in Viewing status  Activity


            }
        });



   }
}
