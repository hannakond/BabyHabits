package com.example.android.babyhabits.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.android.babyhabits.Data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "habit_log.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HABIT_ENHANCED_LOG_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DESCRIPTION + " TEXT, "
                + HabitEntry.COLUMN_HABIT_MINUTE_DURATION + " INTEGER NOT NULL DEFAULT 0)";
        Log.i(LOG_TAG, CREATE_HABIT_ENHANCED_LOG_TABLE);
        db.execSQL(CREATE_HABIT_ENHANCED_LOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void insertHabit(String name, String description, int duration) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitEntry.COLUMN_HABIT_NAME, name);
        habitValues.put(HabitEntry.COLUMN_HABIT_DESCRIPTION, description);
        habitValues.put(HabitEntry.COLUMN_HABIT_MINUTE_DURATION, duration);
        db.insert(HabitEntry.TABLE_NAME, null, habitValues);
    }

    public Cursor queryAllHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_DESCRIPTION,
                HabitEntry.COLUMN_HABIT_MINUTE_DURATION,
        };

        return db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
    }
}


