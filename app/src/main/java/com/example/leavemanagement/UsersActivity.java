package com.example.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UsersActivity extends AppCompatActivity {
    Button  u_submit;
    LeaveDatabase ld;
    EditText editTextuname, editTextupasswword;
    String a ,b;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        ld = new LeaveDatabase(this);
        final EditText editTextuid = (EditText) findViewById(R.id.uid1);
         editTextuname = (EditText) findViewById(R.id.u_name1);
         editTextupasswword = (EditText) findViewById(R.id.u_password1);
        final  EditText editTextempname = (EditText) findViewById(R.id.Ename);
        final EditText editTextedepartment = (EditText) findViewById(R.id.EDepartment);
//        final  EditText editTextestatus = (EditText) findViewById(R.id.EStatus);



        a = editTextuname.getText().toString();
        b = editTextupasswword.getText().toString();

//        intent.putExtra("UserName", a);
//        intent.putExtra("UserPass", b);
        Button u_submit = (Button) findViewById(R.id.u_submit);
        u_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insertuser = ld.insertuser(editTextuid.getText().toString(),editTextuname.getText().toString(),editTextupasswword.getText().toString(),
                                   editTextempname.getText().toString(),editTextedepartment.getText().toString());
                if(insertuser == true){
                    Toast.makeText(UsersActivity.this,"user added successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UsersActivity.this,AllUsersActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }else{
                    Toast.makeText(UsersActivity.this,"User not created successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UsersActivity.this,AllUsersActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    public String getUser(){
        return a;
    }

    public String getPass(){
        return b;
    }


}
