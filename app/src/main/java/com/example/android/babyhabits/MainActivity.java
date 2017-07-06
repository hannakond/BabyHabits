package com.example.android.babyhabits;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.babyhabits.Data.HabitDbHelper;
import com.example.android.babyhabits.Data.HabitContract.HabitEntry;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper mDbHelper = new HabitDbHelper(this);


        mDbHelper.insertHabit(
                "Outdoor play",
                "Natural promotion of wholesome well-being",
                HabitEntry.HABIT_MINUTE_DURATION_S);

        mDbHelper.insertHabit(
                "Reading",
                "A bedtime story or any other book-inspired activity",
                HabitEntry.HABIT_MINUTE_DURATION_M);

        mDbHelper.insertHabit(
                "Music fun",
                "Singing, listening, dancing, instruments playing",
                HabitEntry.HABIT_MINUTE_DURATION_L);

        mDbHelper.insertHabit(
                "Baby sport",
                "Fitness, balance, massage or yoga",
                HabitEntry.HABIT_MINUTE_DURATION_XL);

        Cursor readCursor = mDbHelper.queryAllHabits();

        try {
            while (readCursor.moveToNext()) {
                Log.i(LOG_TAG,
                        "Enhanced habit: " + readCursor.getInt(0) + " - "
                                + readCursor.getString(1) + " - "
                                + readCursor.getString(2) + " - "
                                + readCursor.getInt(3));
            }
        } finally {
            readCursor.close();
        }

    }
}
