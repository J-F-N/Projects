package com.NCodes.inhome.Model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Alarm.class, Date.class}, version = 1)
public  abstract class AlarmDB extends RoomDatabase {

    private static AlarmDB instance;

    public abstract AlarmDao alarmDao();
    public abstract DateDao dateDao();

    public static synchronized AlarmDB getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AlarmDB.class, "alarm_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback) // todo remove before production
                    .build();
        }
        return instance;
    }


    // todo for testing, remove before production
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {

        private AlarmDao alarmDao;

        private PopulateDBAsyncTask(AlarmDB db) {
            alarmDao = db.alarmDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            alarmDao.insertAlarm(new Alarm("title 1", "Desc1", "filepath1", 11111));
            alarmDao.insertAlarm(new Alarm("title 2", "Desc2", "filepath2", 22222));
            alarmDao.insertAlarm(new Alarm("title 3", "Desc3", "filepath3", 33333));
            alarmDao.insertAlarm(new Alarm("title 4", "Desc4", "filepath4", 44444));
            alarmDao.insertAlarm(new Alarm("title 5", "Desc5", "filepath5", 55555));
            alarmDao.insertAlarm(new Alarm("title 6", "Desc6", "filepath6", 66666));
            return null;
        }
    }
    //todo
}
