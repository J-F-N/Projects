package com.NCodes.inhome.Model;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Alarm.class, Date.class}, version = 1)
public  abstract class AlarmDB extends RoomDatabase {

    private static AlarmDB instance;

    public abstract AlarmDao alarmDao();

    public static synchronized AlarmDB getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AlarmDB.class, "alarm_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
