package com.example.leavemanagement;

import android.content.Intent;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EmployeeFunctions extends AppCompatActivity {
    Button empleaves;
    LeaveDatabase ld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_functions);

         final  String id= getIntent().getStringExtra("id");// get the id..
        final String name = getIntent().getStringExtra("name");
        Toast.makeText(this, "id: "+ id, Toast.LENGTH_SHORT).show();

        Button empleaves = (Button) findViewById(R.id.btn_empLeaves);
        empleaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent empfunctionintent = new Intent(EmployeeFunctions.this,LeaveForm.class);
                empfunctionintent.putExtra("id",id);
                empfunctionintent.putExtra("name",name);


                startActivity(empfunctionintent);
            }
        });
    }

    public String getName(){
          String name = getIntent().getStringExtra("name");
          return  name;
    }
    public String getApproveId(){
         String Approveid = getIntent().getStringExtra("id");
        return  Approveid;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.employeelogout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int id1 = item.getItemId();
        if(id == R.id.e_logout){
            Intent intent =  new Intent(EmployeeFunctions.this,MainActivity.class);
            startActivity(intent);
            finish();

        }else if(id1 == R.id.e_status){
            Intent intent =  new Intent(EmployeeFunctions.this,Status.class);
            String name = getName();
           String Approveid = getApproveId();
            intent.putExtra("name",name);
            intent.putExtra("id",Approveid);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
