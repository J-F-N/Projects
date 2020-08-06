package com.example.inhome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.inhome.AlarmContract.*;

import androidx.annotation.Nullable;

public class AlarmDBHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "alarmlist.db";
    public static final int DATABASE_VERSION = 2;

    public AlarmDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_ALARM_TABLE = "CREATE TABLE " +
                AlarmEntry.TABLE_NAME + " (" + AlarmEntry._ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AlarmEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                AlarmEntry.COLUMN_IMAGE + " INTEGER NOT NULL, " +
                AlarmEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
                AlarmEntry.COLUMN_HOUR + " INTEGER NOT NULL, " +
                AlarmEntry.COLUMN_MINUTE + " INTEGER NOT NULL, " +
                AlarmEntry.COLUMN_DAYS + " TEXT NOT NULL," +
                AlarmEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                AlarmEntry.COLUMN_RECORDING + " BLOB NOT NULL" +
                ");";


        db.execSQL(SQL_CREATE_ALARM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + AlarmEntry.TABLE_NAME);
        onCreate(db);
    }
}
