package com.example.leavemanagement;

import android.provider.BaseColumns;

public class EmpLeaveContract
{
    static final String TABLE_NAME5 = "Leaves";

    public static class Columns {
        public static  final  String  _ID = BaseColumns._ID; // changed
        public static final String Startdate = "Start_date";
        public static final String Enddate = "Enddate";
        public static final String Reason = "Reason";

        private Columns() {

        }
    }

}
