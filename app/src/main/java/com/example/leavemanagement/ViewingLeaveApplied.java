package com.example.leavemanagement;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ViewingLeaveApplied extends AppCompatActivity {
    LeaveDatabase ld;
   String id;
    String startdate;
 String name;
    String enddate;
    String to;
    String reason;
    private Button approve;




    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing_leave_applied);
//
        TextView txtstartdata = (TextView) findViewById(R.id.vtstartdate);
        TextView txtenddata = (TextView) findViewById(R.id.vtenddate);

//        TextView Date = (TextView) findViewById(R.id.vtstartdate);
//        TextView Date1 = (TextView) findViewById(R.id.vtenddate);
        TextView  txtto = (TextView) findViewById(R.id.vtTo);
        TextView txtReason = (TextView) findViewById(R.id.vtReason);


//        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
//        String date_n1 = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());


        ld = new LeaveDatabase(this);

        Cursor res = ld.getusers1();
         Intent intent = getIntent();
         if(intent != null){
//             startdate = intent.getIntExtra("StartDate",0);
//             Log.d("TAG", "onCreate: startdate format "+startdate);
//             enddate = intent.getIntExtra("Enddate",1);

             id = intent.getStringExtra("id");
             name = intent.getStringExtra("name");
             startdate = intent.getStringExtra("StartDate");
            enddate = intent.getStringExtra("Enddate");
             to = intent.getStringExtra("To");
             reason = intent.getStringExtra("Reason");

         }
//
         txtstartdata.setText(startdate );
         txtenddata.setText(enddate );
//        Date.setText( date_n);
//         Date1.setText(date_n1);

         txtto.setText(to );
         txtReason.setText(reason);
           approve = (Button) findViewById(R.id.Approve);
           approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean insertstatus = ld.insertApprovestatus(id,name,startdate,enddate,to,reason);
                Toast.makeText(ViewingLeaveApplied.this, "Successfully approve", Toast.LENGTH_SHORT).show();

                boolean delete = ld.deletestatus(id,name,startdate,enddate,to,reason);

                Toast.makeText(ViewingLeaveApplied.this, " Approve data Successfully deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewingLeaveApplied.this,UsersnameListing.class);
                startActivity(intent);
                finish();
            }
        });

        final Button notapprove = (Button) findViewById(R.id.NotApprove);
        notapprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               approve.setVisibility(View.INVISIBLE);
               notapprove.setText("NOT APPROVED");
               notapprove.setEnabled(false);
                Toast.makeText(ViewingLeaveApplied.this, " Leave Not Approve", Toast.LENGTH_SHORT).show();


                boolean delete = ld.deletestatus(id,name,startdate,enddate,to,reason);

                Toast.makeText(ViewingLeaveApplied.this, " Leave Not Approve Successfully deleted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ViewingLeaveApplied.this,UsersnameListing.class);
                startActivity(intent);
                finish();

            }
        });

    }



}
