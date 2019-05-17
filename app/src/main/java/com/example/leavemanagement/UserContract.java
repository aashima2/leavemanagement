package com.example.leavemanagement;

import android.provider.BaseColumns;



public class UserContract {

    static  final String TABLE_NAME7 = "User";

    public static class  Columns{
        public static  final String USERID = BaseColumns._ID;
        public static  final String USERNAME = " uName ";
        public static  final String USERPASSWORD = " uPassword ";
        public static  final String  EMPNAME = " empname ";
        public static  final String  EMPDEPARTMENT = " empdepartment ";
//        public  static  final String ESTATUS = " estatus ";


        private Columns(){

        }
    }

}
