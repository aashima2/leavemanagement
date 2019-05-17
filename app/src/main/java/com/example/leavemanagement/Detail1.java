package com.example.leavemanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Detail1 extends AppCompatActivity {

    Button Edit;
    LeaveDatabase ld;
    Button add;
    Button delete, xyz;

    int ab, pos;
    String cd, ef , gh;// changes made


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);

        ld =  new LeaveDatabase(this);
        final EditText editText1 =  (EditText) findViewById(R.id.et_d2);
        final EditText editText2 = (EditText) findViewById(R.id.et_d1);
        final EditText editext3 = (EditText) findViewById(R.id.et_d3);
        final EditText editText4 = (EditText) findViewById(R.id.et_d4); // changes made
        xyz = (Button) findViewById(R.id.btn_navigator2);

        delete = (Button) findViewById(R.id.btn_delete);
        Cursor res = ld.getData();
        Intent intent = getIntent();
        if(intent != null) {
            ab = intent.getIntExtra("A", 0);
            cd = intent.getStringExtra("B");
            ef = intent.getStringExtra("C");
            gh = intent.getStringExtra("D"); // changes made
            pos = intent.getIntExtra("Position", 0);
        }

        editText1.setText(ab + "");
        editText2.setText(cd);
        editext3.setText(ef);
        editText4.setText(gh);//changes made
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 boolean delete = ld.deletedata(editText1.getText().toString(),editText2.getText().toString(),editext3.getText().toString(),
                          editText4.getText().toString());//changes made


                 if(delete == true){
                     Toast.makeText(Detail1.this,"deleted  successfully",Toast.LENGTH_LONG).show();
                     Intent detail1intent =   new Intent(Detail1.this,Updateddata.class);
                     startActivity(detail1intent);
                 }
            }
        });

        add  = (Button) findViewById(R.id.btn_Addition);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insert = ld.insertdata(editText1.getText().toString(),editText2.getText().toString(),editext3.getText().toString(),
                                 editText4.getText().toString());//changes made

                if(insert == true){
                    Toast.makeText(Detail1.this,"detail inserted successfully",Toast.LENGTH_LONG).show();
                    Intent detail1intent =   new Intent(Detail1.this,Updateddata.class);
                    startActivity(detail1intent);


                }
                else{
                    Toast.makeText(Detail1.this," detail Not Submitted",Toast.LENGTH_LONG).show();
                   Intent detail1intent =   new Intent(Detail1.this,Updateddata.class);
                    startActivity(detail1intent);
                }

            }
        });

        Edit = (Button) findViewById(R.id.btn_Submit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean update  = ld.updatedata(editText1.getText().toString(),editText2.getText().toString(),editext3.getText().toString(),
                        editText4.getText().toString());// changes made
                if(update == true){
                    Toast.makeText(Detail1.this,"Edited successfully",Toast.LENGTH_LONG).show();
                    Intent detail1intent =   new Intent(Detail1.this,Updateddata.class);
                    startActivity(detail1intent);
                }
                else{
                    Toast.makeText(Detail1.this," Not Edited  Submitted",Toast.LENGTH_LONG).show();
                    Intent detail1intent =   new Intent(Detail1.this,Updateddata.class);
                    startActivity(detail1intent);
                }

            }
        });



        xyz.setOnClickListener(new View.OnClickListener() { //changes1
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(editText1.getText().toString().trim());


//              Cursor var = ld.getData1();
//var.moveToPosition(pos);

                Intent intent1 = new Intent(Detail1.this, LeavesDetails.class);
                Log.d("id", "onClick: var "+ editText1.getText().toString());
//         intent1.putExtra("C",var.getString(0));

                intent1.putExtra("xyzId",Integer.valueOf(editText1.getText().toString()));
                startActivity(intent1);
            }
        });
    }



 }

