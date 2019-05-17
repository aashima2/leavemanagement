package com.example.leavemanagement;

import android.app.DatePickerDialog;
import android.content.Intent;
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

public class LeaveForm extends AppCompatActivity {

    Button leaveapply;
    private DatePickerDialog.OnDateSetListener mDataSetListener ;
    private  DatePickerDialog.OnDateSetListener m1DataSetListener;
    LeaveDatabase ld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_form);

       final String id = getIntent().getStringExtra("id"); // get the id
         final String name = getIntent().getStringExtra("name");// store the name of that particular id
        Toast.makeText(this, "name:"+name, Toast.LENGTH_SHORT).show();

         ld = new LeaveDatabase(this);
        final EditText  editTextstart = (EditText) findViewById(R.id.editstart);
         final  EditText editTextend = (EditText) findViewById(R.id.editend);
         final  EditText  editTextto = (EditText) findViewById(R.id.edto);
         final  EditText editTextreason = (EditText) findViewById(R.id.editreason);

        editTextstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal  =  Calendar.getInstance();
                int year  = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day  = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        LeaveForm.this ,  android.R.style.Theme_Holo_Light_Dialog_MinWidth ,
                        mDataSetListener, year,month,day  );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month , int dayOfMonth) {
                month = month + 1;
                Log.d("TAG", "onDateSet: dd/mm/yyyy: " +  dayOfMonth + "/" +  month+ "/" + year );
                String date =   dayOfMonth  + "/" +  month+ "/" + year;
                editTextstart.setText(date);

            }
        };

        editTextend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal  =  Calendar.getInstance();
                int year  = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day  = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        LeaveForm.this ,  android.R.style.Theme_Holo_Light_Dialog_MinWidth ,
                        m1DataSetListener, year,month,day );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        m1DataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("TAG", "onDateSet: dd/mm/yyyy: " +  dayOfMonth + "/" +  month+ "/" + year );
                String date =   dayOfMonth  + "/" +  month+ "/" + year;
                editTextend.setText(date);

            }
        };

        Button leaveapply  =  (Button) findViewById(R.id.Leaveapply);

        leaveapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean insertapply  = ld.insertleave(id,name ,editTextstart.getText().toString(),editTextend.getText().toString(),editTextto.getText().toString(),
//                        editTextreason.getText().toString());
                boolean insertapply  = ld.insertleave( id, name, editTextstart.getText().toString(),editTextend.getText().toString(),editTextto.getText().toString(),
                        editTextreason.getText().toString());

                if(insertapply == true)
                {
                    Toast.makeText(LeaveForm.this," Leave applied" , Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LeaveForm.this , "Leave Not applied ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
