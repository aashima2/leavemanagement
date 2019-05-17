package com.example.leavemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.os.Build.ID;
import static com.example.leavemanagement.DetailContract.Columns.DETAIL_ID;
import static com.example.leavemanagement.DetailContract.Columns.EMP_ID;
import static com.example.leavemanagement.DetailContract.Columns.EMP_NAME;
import static com.example.leavemanagement.DetailContract.Columns.END_DATE;
import static com.example.leavemanagement.DetailContract.Columns.REASON;
import static com.example.leavemanagement.DetailContract.Columns.START_DATE;
import static com.example.leavemanagement.DetailContract.Columns.U_USER_ID;
import static com.example.leavemanagement.DetailContract.TABLE_NAME1;
import static com.example.leavemanagement.EmpLeaveContract.Columns.Startdate;
import static com.example.leavemanagement.EmployeeContract.Columns.Name;
import static com.example.leavemanagement.EmployeeContract.Columns._ID;

public class LeaveDatabase extends SQLiteOpenHelper {


    public DetailContract detailContract;
    private static final String TAG = "LeaveDatabase";

    public static final String DATABASE_NAME = "Leavemanagement.db";

    public static final int DATABASE_VERSION = 27;

    public static LeaveDatabase instance = null;

    public LeaveDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "LeaveDatabase:constructor");
    }

    static LeaveDatabase getInstance(Context context) {
        if (instance == null) {
            Log.d(TAG, "getInstance: creating new instance");
            instance = new LeaveDatabase(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //initializing  detailContact

        detailContract = new DetailContract();


        Log.d(TAG, "onCreate: starts");
        String sSql;
        String sSql1;
        String sSql2;
        String sSql3;
      String sSql4;
       String sSql5;
       String sSql6;
       String sSql7;
       String sSql8;


       sSql4 = "CREATE TABLE " + EmployeeContract.TABLE_NAME4 + "("
                 +  _ID + " INTEGER  PRIMARY KEY NOT NULL , "
                 + EmployeeContract.Columns.Name + " TEXT NOT NULL ,"
                 + EmployeeContract.Columns.Department + " TEXT NOT NULL, "
                 + EmployeeContract.Columns.Status + " TEXT  NOT NULL);"; // need to be changed  when required
        Log.d(TAG , sSql4);
        db.execSQL(sSql4);


        sSql5 = "CREATE TABLE " + EmpLeaveContract.TABLE_NAME5 + "("
                + EmpLeaveContract.Columns._ID + " INTEGER PRIMARY KEY NOT NULL , " // changed
                + EmpLeaveContract.Columns.Startdate +  " INTEGER NOT NULL, "
                + EmpLeaveContract.Columns.Enddate + " INTEGER  NOT NULL, "
                + EmpLeaveContract.Columns.Reason + " TEXT NOT NULL );";
        Log.d(TAG, sSql5);
        db.execSQL(sSql5);

        // Users Table

        sSql6 = "CREATE TABLE " + UserContract.TABLE_NAME7 + "("
                + UserContract.Columns.USERID  + " INTEGER PRIMARY KEY NOT NULL ,"
                + UserContract.Columns.USERNAME + " TEXT NOT NULL,"
                + UserContract.Columns.USERPASSWORD  + " TEXT NOT NULL, "
                + UserContract.Columns.EMPNAME + " TEXT NOT NULL,"
                + UserContract.Columns.EMPDEPARTMENT + " TEXT NOT NULL);";

        Log.d(TAG , sSql6);
        db.execSQL(sSql6);

//leave apply

        sSql7 = " CREATE TABLE " + Empapplyformcontract.TABLE_NAME8 + "("
                + Empapplyformcontract.Columns.USERID  + " INTEGER PRIMARY KEY NOT NULL, "
                + Empapplyformcontract.Columns.USERNAME + " TEXT  NOT NULL,"
                + Empapplyformcontract.Columns.STARTDATE + " DATE NOT NULL, "
                + Empapplyformcontract.Columns.ENDDATE + " DATE NOT NULL, "
                + Empapplyformcontract.Columns.TO + " TEXT NOT NULL, "
                + Empapplyformcontract.Columns.Reason + " TEXT NOT NULL);";

        Log.d(TAG,sSql7);
        db.execSQL(sSql7);


        //for status Approve or not
        sSql8 = " CREATE TABLE " + showingStatusContract.TABLE_NAME9 + "("
                + showingStatusContract.Columns.USERID  + " INTEGER PRIMARY KEY NOT NULL, "
                + showingStatusContract.Columns.USERNAME + " TEXT NOT NULL,"
                + showingStatusContract.Columns.STARTDATE + " DATE NOT NULL, "
                + showingStatusContract.Columns.ENDDATE + " DATE NOT NULL, "
                + showingStatusContract.Columns.TO + " TEXT NOT NULL, "
                + showingStatusContract.Columns.Reason + " TEXT NOT NULL);";
        Log.d(TAG, sSql8);
        db.execSQL(sSql8);

        Log.d(TAG, "onCreate: ends");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: starts");
        db.execSQL("DROP TABLE IF EXISTS " + EmployeeContract.TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + EmpLeaveContract.TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + UserContract.TABLE_NAME7);
        db.execSQL("DROP TABLE IF EXISTS " + Empapplyformcontract.TABLE_NAME8);
        db.execSQL("DROP TABLE IF EXISTS " +showingStatusContract.TABLE_NAME9);
        onCreate(db);

    }

    public  boolean insertdata(String _id, String name , String department , String status ){ // changes done
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv =  new ContentValues();
        cv.put(_ID , _id );
        cv.put(EmployeeContract.Columns.Name , name);
        cv.put(EmployeeContract.Columns.Department , department);
        cv.put(EmployeeContract.Columns.Status , status );// changes done

        long result = db.insert(EmployeeContract.TABLE_NAME4,null,cv);
        if(result == -1)
        {
            return  false;
       }
        else{
            return  true;
        }
    }

    public  Cursor  getData(){
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + EmployeeContract.TABLE_NAME4,null);
        return  cursor;

    }

    public  Cursor  getData1(){
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + EmpLeaveContract.TABLE_NAME5,null);
        return  cursor;

    }

    public Cursor getusers(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * FROM " + UserContract.TABLE_NAME7 , null);
        return cursor;
    }

    public Cursor getusers1() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * FROM " + Empapplyformcontract.TABLE_NAME8, null);
        return cursor;
    }
//    public Cursor getData2(int _id){
//        Log.d(TAG, "getData2: In get data2");
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(EmpLeaveContract.TABLE_NAME5, new String[]{ EmpLeaveContract.Columns._ID,EmpLeaveContract.Columns.Startdate
//                        ,EmpLeaveContract.Columns.Enddate,EmpLeaveContract.Columns.Reason},EmpLeaveContract.Columns._ID + "=?",new String[]{String.valueOf(_id)},null,
//                          null,null,null);
//
//         cursor.moveToFirst();
//
//         return  cursor;
//    }




 public  boolean updatedata(String _id, String  name , String department , String status){ // changes done
     Log.d(TAG, "updatedata: updation started");
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(EmployeeContract.Columns._ID , _id);
        cv.put(EmployeeContract.Columns.Name , name);
        cv.put(EmployeeContract.Columns.Department , department);
        cv.put(EmployeeContract.Columns.Status , status);// changes done

     long result1 = db.update(EmployeeContract.TABLE_NAME4 , cv, EmployeeContract.Columns._ID  + "=" + _id,null);
     Log.d(TAG, "updatedata: updation ends");
       return true;


 }

 public  boolean  deletedata (String _id , String name , String department , String status ){ // changes done
     Log.d(TAG, "deletedata:   deletion starts");

     SQLiteDatabase db = this.getWritableDatabase();
     long result2 = db.delete(EmployeeContract.TABLE_NAME4 , EmployeeContract.Columns._ID + "=" +_id, null);
     Log.d(TAG, "deletedata: deletion ends");
     return  true;
 }

 // Employee perspective

    public  boolean insertemp( String _id ,String startdate, String enddate , String reason){ // changed
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put(EmpLeaveContract.Columns._ID , _id); // changed
        cv.put(EmpLeaveContract.Columns.Startdate , startdate);
        cv.put(EmpLeaveContract.Columns.Enddate , enddate);
        cv.put(EmpLeaveContract.Columns.Reason , reason);

        long result3 = db.insert(EmpLeaveContract.TABLE_NAME5,null,cv);
        if(result3 == -1)
        {
            return  false;
        }
        else{
            return  true;
        }
    }

   public boolean updateemp( String _id ,String startdate , String enddate , String reason){//changed
       Log.d(TAG, "updatedata: updation started");
       SQLiteDatabase db = this.getReadableDatabase();

       ContentValues cv = new ContentValues();
       cv.put(EmpLeaveContract.Columns._ID , _id);//changed
       cv.put(EmpLeaveContract.Columns.Startdate ,startdate);
       cv.put(EmpLeaveContract.Columns.Enddate,enddate);
       cv.put(EmpLeaveContract.Columns.Reason , reason);

       long result4 = db.update(EmpLeaveContract.TABLE_NAME5 , cv, EmpLeaveContract.Columns._ID  + "=" + _id,null);
       Log.d(TAG, "updatedata: updation ends");
       return true;


   }

    public  boolean  deleteemp ( String _id ,String startdate , String enddate , String reason){//changed
        Log.d(TAG, "deletedata:   deletion starts");

        SQLiteDatabase db = this.getWritableDatabase();
        long result5 = db.delete(EmpLeaveContract.TABLE_NAME5, EmpLeaveContract.Columns._ID+ "=" + _id, null);
        Log.d(TAG, "deletedata: deletion ends");
        return  true;
    }

    //user insert

    public  boolean insertuser(String userid , String username , String userpassword , String empname , String  empdepartment ){
        SQLiteDatabase db = this.getWritableDatabase();
      ContentValues cv = new ContentValues();
      cv.put(UserContract.Columns.USERID , userid);
      cv.put(UserContract.Columns.USERNAME , username);
      cv.put(UserContract.Columns.USERPASSWORD , userpassword);
      cv.put(UserContract.Columns.EMPNAME, empname);
      cv.put(UserContract.Columns.EMPDEPARTMENT, empdepartment);
//      cv.put(UserContract.Columns.ESTATUS , estatus);

        long result6 = db.insert(UserContract.TABLE_NAME7,null,cv);
        if(result6 == -1)
        {
            return  false;
        }
        else{
            return  true;
        }
    }

//    public boolean deleteuser(String)

    // leave apply insertion

    public  boolean  insertleave( String id ,String name, String startdate , String enddate , String to , String reason ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put(Empapplyformcontract.Columns.USERID ,id );
        cv.put(Empapplyformcontract.Columns.USERNAME , name);
        cv.put(Empapplyformcontract.Columns.STARTDATE , startdate);
        cv.put(Empapplyformcontract.Columns.ENDDATE , enddate);
        cv.put(Empapplyformcontract.Columns.TO , to );
        cv.put(Empapplyformcontract.Columns.Reason , reason);

        long result7 = db.insert(Empapplyformcontract.TABLE_NAME8 , null,cv);

        if(result7 == -1){
            return  false;
        }
        else{
            return  true;
        }
    }

    //for status Approve

    public  boolean  insertApprovestatus( String id ,String name, String startdate , String enddate , String to , String reason ) {
        Log.d(TAG, "insertApprovestatus: status Approve");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(showingStatusContract.Columns.USERID, id);
        cv.put(showingStatusContract.Columns.USERNAME, name);
        cv.put(showingStatusContract.Columns.STARTDATE, startdate);
        cv.put(showingStatusContract.Columns.ENDDATE, enddate);
        cv.put(showingStatusContract.Columns.TO, to);
        cv.put(showingStatusContract.Columns.Reason, reason);

        long result8 = db.insert(showingStatusContract.TABLE_NAME9, null, cv);

        if (result8 == -1) {
            return false;
        } else {
            return true;
        }
    }

    // deleting status when approve

   public boolean deletestatus (String id ,String name, String startdate , String enddate , String to , String reason ){
       Log.d(TAG, "deletestatus:  Approve Leave delete starts");
       SQLiteDatabase db = getWritableDatabase();
       long  result9 = db.delete(Empapplyformcontract.TABLE_NAME8,Empapplyformcontract.Columns.USERID+ "=" + id, null);
       Log.d(TAG, "deletestatus: Approve Leave delete ends");
       return  true;

   }





public List <String>  getUserName(){

        List <String> uname = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
    String selectQuery = "SELECT  * FROM " + UserContract.TABLE_NAME7;
    Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            Log.d(TAG, "getUserName: cursor started");
            do{
                uname.add(cursor.getString(1));
            }while(cursor.moveToNext());
            cursor.close();

        }
        return  uname;
    }
    // only leave applied users

    public List <String>  getLeaveUserName(){

        List <String> uname = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Empapplyformcontract.TABLE_NAME8;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            Log.d(TAG, "getULeaveuserName: cursor started");
            do{
                uname.add(cursor.getString(1));
            }while(cursor.moveToNext());
            cursor.close();

        }
        return  uname;
    }

    // only status approve

    public Cursor getApproveStatusName(String name){
        List <String> Name = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = " SELECT * FROM " + showingStatusContract.TABLE_NAME9;
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        return  cursor;
//        if(cursor.moveToFirst()){
//            Log.d(TAG, "getApproveStatusName: status cursor started");
//            do{
//                Name.add(cursor.getString(1));
//            }while(cursor.moveToNext());
//             cursor.close();
//        }
//        return Name;
    }
//    public  List<String> getApproveStatusName(String name) {
//        List<String> Name = new ArrayList<>();
//        Log.d(TAG, "getApproveStatusName:   approvestatusnamestarts ");
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(showingStatusContract.TABLE_NAME9, new String[]{showingStatusContract.Columns.USERNAME}, showingStatusContract.Columns.USERNAME + "=?", new String[]{name},
//               null, null, null);
//////        Cursor cursor = db.query(showingStatusContract.TABLE_NAME9, new String[]{showingStatusContract.Columns.USERID}, showingStatusContract.Columns.USERNAME + "=?", new String[]{name},
//////                null, null, null);
//        cursor.moveToNext();
//            Name.add(cursor.getString(0));
//
//        return  Name;
//    }



    // getting of id

    public String  getid(String name){
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.query(UserContract.TABLE_NAME7, new String[]{ UserContract.Columns.USERID}, UserContract.Columns.USERNAME +"=?", new String[]{name},
                null,null,null);
        cursor.moveToNext();

        String res = cursor.getString(0);
        return  res;
    }
    public Cursor getLeavedata(String name){
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.query(Empapplyformcontract.TABLE_NAME8, new String[]{ Empapplyformcontract.Columns.STARTDATE,Empapplyformcontract.Columns.ENDDATE,Empapplyformcontract.Columns.TO
                ,Empapplyformcontract.Columns.Reason}, UserContract.Columns.USERNAME +"=?", new String[]{name},
                null,null,null);
        cursor.moveToNext();

        return  cursor;
    }
    // geting name

//    public String getname(String id){
//        SQLiteDatabase db  = this.getReadableDatabase();
//        Cursor cursor = db.query(UserContract.TABLE_NAME7, new String[]{ UserContract.Columns.USERNAME}, UserContract.Columns.USERID +"=?", new String[]{id},
//                null,null,null);
//        cursor.moveToNext();
//
//        String res = cursor.getString(0);
//        return  res;
//
//    }

    String  getpass(String name){
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.query(UserContract.TABLE_NAME7, new String[]{ UserContract.Columns.USERPASSWORD}, UserContract.Columns.USERNAME +"=?", new String[]{name},
                null,null,null);
        cursor.moveToNext();

        String res = cursor.getString(0);
        return res;
    }


}

