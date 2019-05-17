package com.example.leavemanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UsersnameListing extends AppCompatActivity {
    LeaveDatabase ld;
    ListView ls1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersname_listing);

        ld = new LeaveDatabase(this);
        ls1 = (ListView) findViewById(R.id.Userslisting);

//        ArrayList <String>  List =  new ArrayList<>();

        List<String> List ;
        List = ld.getLeaveUserName();
        if(List.isEmpty()){
            Toast.makeText(this, "No leave application", Toast.LENGTH_SHORT).show();
        }else{

            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List);
                ls1.setAdapter(listAdapter);
        }

//
//        Cursor cursor = ld.getusers();
//        if(cursor.getCount() == 0 ){
//
//            Toast.makeText(UsersnameListing.this,"No data",Toast.LENGTH_LONG).show();
//        }else{
//            while(cursor.moveToNext()){
//                Cursor res = ld.getusers1();
//
//
//                if(res.moveToPosition(cursor.getPosition())){
//                    List.add(cursor.getString(1));
//                }
//
//                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List);
//                ls1.setAdapter(listAdapter);
//            }
//
       //}

        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // on item click admin must see  the leave applied by User

                Cursor res = ld.getusers1();
                res.moveToPosition(position);
                Intent employeeintent =  new Intent(UsersnameListing.this,ViewingLeaveApplied.class);
                employeeintent.putExtra("Position", position);
                 employeeintent.putExtra("id",res.getString(0));
                  employeeintent.putExtra("name",res.getString(1));
                employeeintent.putExtra("StartDate",res.getString(2));
                employeeintent.putExtra("Enddate",res.getString(3));
                  employeeintent.putExtra("To",res.getString(4));
                  employeeintent.putExtra("Reason",res.getString(5)); // changes made
                startActivity(employeeintent);
                finish();

            }
        });


    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.user_activity, menu);
//        return super.onCreateOptionsMenu(menu);
//
//
//
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if(id == R.id.u_add){
//            Intent Updatedintent = new Intent (UsersnameListing.this,UsersActivity.class);
//            startActivity(Updatedintent);
//        }
//        return super.onOptionsItemSelected(item);
//
//
//
//    }





}
