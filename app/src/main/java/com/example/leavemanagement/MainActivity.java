package com.example.leavemanagement;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    Button Login;
      LeaveDatabase ld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ld = new LeaveDatabase(this);
       final  EditText editText1 = (EditText) findViewById((R.id.etName));
       final  EditText  editText2 = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById( R.id.btnLogin);



       final String abc = String.valueOf(ld.getUserName());
   //    final String fgh = String.valueOf(ld.getPassName());

       Login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               List<String> names = ld.getUserName();
               if(editText1.getText().toString().equals("Admin") && editText2.getText().toString().equals("123")){
                   Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();

                   Intent employeeintent =  new Intent(MainActivity.this,
                        AllUsersActivity.class);

                   startActivity(employeeintent);
                   finish();

               }
//               else if (!editText1.getText().toString().equals("Admin") && !editText2.getText().toString().equals("123")){
//                   Toast.makeText(MainActivity.this, "  Logged in successfully other then Admin", Toast.LENGTH_LONG).show();
//                   Intent empintent =  new Intent(MainActivity.this, EmployeeFunctions.class);
//                  startActivity(empintent);
//               }


               else if(names.contains(editText1.getText().toString())){
                   if(ld.getpass(editText1.getText().toString()).equals(editText2.getText().toString())){
                       Toast.makeText(MainActivity.this, "  User log in Successfully....", Toast.LENGTH_LONG).show();
                       Intent empintent =  new Intent(MainActivity.this, EmployeeFunctions.class);
                       empintent.putExtra("name",editText1.getText().toString());
                       empintent.putExtra("id",ld.getid(editText1.getText().toString()));  // intent to get the id
                       startActivity(empintent);
                       finish();
                   }else{
                       Toast.makeText(MainActivity.this, "Some error", Toast.LENGTH_SHORT).show();
                   }


               }else {
                   Toast.makeText(MainActivity.this, "  Something went wrong ....", Toast.LENGTH_LONG).show();
               }




//               (editText1.getText().toString().equals(abc) && editText2.getText().toString().equals(fgh)){
//                   Toast.makeText(MainActivity.this, "  Logged in successfully User", Toast.LENGTH_LONG).show();
//
//                   Intent empintent =  new Intent(MainActivity.this, EmployeeFunctions.class);
//                  startActivity(empintent);
//               }
//


           }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    }
