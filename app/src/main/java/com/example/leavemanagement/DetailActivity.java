package com.example.leavemanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    Button add;
    LeaveDatabase ld = new LeaveDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final EditText et4 =  (EditText) findViewById(R.id.et_Detail_id);
        final EditText et5 = (EditText) findViewById(R.id.et_U_User_id);
        final EditText et6 = (EditText) findViewById(R.id.et_Emp_name);
        final EditText et7 = (EditText) findViewById(R.id.et_Emp_id);
        final EditText et8 = (EditText) findViewById(R.id.et_StartDate);
        final EditText et9 = (EditText) findViewById(R.id.et_EndDate);
        final EditText et10 = (EditText) findViewById(R.id.et_Reason);

        //string to store the value of userid we got from intnet
        final String userid = getIntent().getStringExtra("user_id");






        add = (Button) findViewById(R.id.btn_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean insert = ld.insertdata(et4.getText().toString(),userid,et6.getText().toString() ,
//                        et7.getText().toString(),et8.getText().toString(),et9.getText().toString(), et10.getText().toString());
//
//                if(insert == true){
//                    Toast.makeText(getApplicationContext(),"Data is inserted", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getApplicationContext()," Data Not Inserted",Toast.LENGTH_LONG).show();
//
//                }



            }

        });

    }

}
