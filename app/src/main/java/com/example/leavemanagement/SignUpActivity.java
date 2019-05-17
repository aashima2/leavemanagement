package com.example.leavemanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class SignUpActivity extends AppCompatActivity {

    Button singup;

    LeaveDatabase ld = new LeaveDatabase(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText et1 =  (EditText) findViewById(R.id.et_user_id);
        final EditText et2 = (EditText) findViewById(R.id.et_user_name);
        final EditText et3 = (EditText) findViewById(R.id.et_password);
        singup = (Button) findViewById(R.id.btn_signup);

       singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean insert =  ld.insertdata(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
//
//                if(insert == true){
//
//
//
//                    Toast.makeText(getApplicationContext(),"Sign up completed", Toast.LENGTH_LONG).show();
//
//
//                   //creating intent for sending user to detail account setup activity.
//                    Intent detailIntent = new Intent(SignUpActivity.this,DetailActivity.class);
//                    //passing user id to details activity for detail account setup
//                    detailIntent.putExtra("user_id",et1.getText().toString());
//                    startActivity(detailIntent);
//                }else{
//                    Toast.makeText(getApplicationContext()," Data Not Inserted",Toast.LENGTH_LONG).show();
//                }

            }

        });


    }
}
