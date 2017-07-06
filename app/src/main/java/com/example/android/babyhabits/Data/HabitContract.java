package com.example.android.babyhabits.Data;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {}

    public static class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DESCRIPTION = "description";
        public static final String COLUMN_HABIT_MINUTE_DURATION = "duration";

        /*
        *  Possible values for habit duration in minutes
        *  S = 5, M = 10, L = 20, XL = 30
        */
        public static final int HABIT_MINUTE_DURATION_S = 0;
        public static final int HABIT_MINUTE_DURATION_M = 1;
        public static final int HABIT_MINUTE_DURATION_L = 2;
        public static final int HABIT_MINUTE_DURATION_XL = 3;
    }
}
