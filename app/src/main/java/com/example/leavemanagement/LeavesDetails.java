package com.example.leavemanagement;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class LeavesDetails extends AppCompatActivity {

Button Apply;
LeaveDatabase ld;
int gh1;//changed
int ab1;
int cd1, ij;
String ef1;
Button Edit1;
Button  Delete1;

private DatePickerDialog.OnDateSetListener mDataSetListener ;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaves_details);

        ld = new LeaveDatabase(this);
        final EditText empet4 = (EditText)  findViewById(R.id.edit_ID);//changed
        final EditText empet1 = (EditText) findViewById(R.id.edit_Start);
        final EditText empet2 = (EditText) findViewById(R.id.edit_end);
        final EditText empet3 = (EditText) findViewById(R.id.edit_reason);





        Intent intent = getIntent();
        if(intent != null) {
          gh1 = intent.getIntExtra("D", 0);//changed
            ab1 = intent.getIntExtra("A", 0);
            cd1 = intent.getIntExtra("B" , 0);
            ef1 = intent.getStringExtra("C");
            ij = intent.getIntExtra("xyzId", -1);

            if(ij==-1){
                ij=gh1;
            }

        }


        empet4.setText(ij + ""); //changed
        empet1.setText(ab1 + "");
        empet2.setText(cd1 + "");
        empet3.setText(ef1);


        empet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal  =  Calendar.getInstance();
                 int year  = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day  = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        LeavesDetails.this ,  android.R.style.Theme_Holo_Light_Dialog_MinWidth ,
                        mDataSetListener, year,month,day );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("TAG", "onDateSet: dd/mm/yyyy: " +  dayOfMonth + "/" +  month+ "/" + year );
                String date =   dayOfMonth  + "/" +  month+ "/" + year;
                empet1.setText(date);

            }
        };



        Button Edit1 = (Button) findViewById(R.id.btn_emp_Edit);
        Edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean  updateemp = ld.updateemp(empet4.getText().toString() ,empet1.getText().toString(),empet2.getText().toString(),empet3.getText().toString());

                if(updateemp == true) {
                    Toast.makeText(LeavesDetails.this, "Edited successfully", Toast.LENGTH_LONG).show();
                    Intent leaveintent = new Intent(LeavesDetails.this, EmployeHomePage.class);
                    startActivity(leaveintent);
                }

            }
        });

        Button Delete1 = (Button) findViewById(R.id.btn_emp_Delete);
        Delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean deleteemp = ld.deleteemp(empet4.getText().toString(),empet1.getText().toString(),empet2.getText().toString(),empet3.getText().toString());
                if(deleteemp == true){
                    Toast.makeText(LeavesDetails.this,"deleted  successfully",Toast.LENGTH_LONG).show();
                    Intent detail1intent =   new Intent(LeavesDetails.this,EmployeHomePage.class);
                    startActivity(detail1intent);
                }
            }
        });


        Button Apply = (Button) findViewById(R.id.btn_emp_apply);
        Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insert1 = ld.insertemp(empet4.getText().toString(), empet1.getText().toString(),empet2.getText().toString(), empet3.getText().toString());

                if(insert1 == true){
                    Toast.makeText(LeavesDetails.this,"Applied successfully",Toast.LENGTH_LONG).show();
                    Intent leaveintent =   new Intent(LeavesDetails.this,EmployeHomePage.class);
                    startActivity(leaveintent);


                }
                else{
                    Toast.makeText(LeavesDetails.this," Not Applied Submitted",Toast.LENGTH_LONG).show();
                    Intent leaveintent =   new Intent(LeavesDetails.this,EmployeHomePage.class);
                    startActivity(leaveintent);
                }


            }
        });
    }
}
