package com.example.leavemanagement;

import android.provider.BaseColumns;

public class LeaveManagementContract {
    static  final String   TABLE_NAME2 = "leave_management";

    public static  class Columns{
        public static final String LEAVE_MANAGEMENT_ID = BaseColumns._ID;
        public static final String D_DETAIL_ID = BaseColumns._ID;
        public static  final String DESCRIPTION = "Description";

        private  Columns(){

        }

    }
}
