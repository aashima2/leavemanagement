package com.example.leavemanagement;

import android.provider.BaseColumns;

public class DetailContract {
    static  final String  TABLE_NAME1 = "Detail";

    public static class Columns{
        public static  final String  DETAIL_ID = BaseColumns._ID;
        public static final  String  U_USER_ID ="_UID";
        public static final  String  EMP_NAME = "Name";
        public  static final String  EMP_ID ="_EID";
        public  static  final String START_DATE = "StartDate";
        public  static final String  END_DATE = "EndDate";
        public  static final String  REASON = "Reason";

        private Columns(){

        }
    }
}
