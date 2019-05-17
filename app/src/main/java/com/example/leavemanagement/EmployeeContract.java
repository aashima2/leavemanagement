package com.example.leavemanagement;

import android.provider.BaseColumns;

public class EmployeeContract {

    static final String TABLE_NAME4 = "empdetails";

    public static class Columns {
        public static final String _ID = BaseColumns._ID;
        public static final String Name = " Name ";
        public static final String Department = " Department ";
        public static  final String Status = " Status "; // need to be edited when required

        private Columns() {

        }
    }
}
