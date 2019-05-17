package com.example.leavemanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
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

public class AllUsersActivity extends AppCompatActivity {
    LeaveDatabase ld;
    ListView ls2;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        ld = new LeaveDatabase(this);
        ls2 = (ListView) findViewById(R.id.allusers);

        ArrayList<String> List = new ArrayList<>();

        Cursor cursor = ld.getusers();
        if (cursor.getCount() == 0) {

            Toast.makeText(AllUsersActivity.this, "No Users", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {

                List.add(cursor.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List);
                ls2.setAdapter(listAdapter);

            }
        }
        ls2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int id1 = item.getItemId();
        int id2 = item.getItemId();

        if(id == R.id.u_add){
            Intent Updatedintent = new Intent (AllUsersActivity.this,UsersActivity.class);
            startActivity(Updatedintent);

        } else if(id1 == R.id.edLeaverequest){
            Intent intent = new Intent(AllUsersActivity.this,UsersnameListing.class);
            startActivity(intent);


        } else if (id2 == R.id.logout){
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
            builder.setMessage("Do you want to close this application ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(AllUsersActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                            Toast.makeText(getApplicationContext(),"you choose yes action for Logout",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();
                            Toast.makeText(getApplicationContext(),"you choose no action for Logout",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Logout");
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }

}




