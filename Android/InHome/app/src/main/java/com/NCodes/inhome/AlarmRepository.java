/*
Author: John Neigel
Created: 10/28/2020
Description: AlarmRepository is an abstraction layer to serve as a single point of access to
application data.
 */

package com.NCodes.inhome;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.NCodes.inhome.Model.Alarm;
import com.NCodes.inhome.Model.AlarmDB;
import com.NCodes.inhome.Model.AlarmDao;
import com.NCodes.inhome.Model.AlarmWithDates;
import com.NCodes.inhome.Model.Date;
import com.NCodes.inhome.Model.DateDao;
import java.util.List;
import java.util.concurrent.Executor;

public class AlarmRepository {
    private AlarmDao repoAlarmDao;
    private DateDao repoDateDao;
    private LiveData<List<Alarm>> allAlarms;
    DBExecutor executor;

    public AlarmRepository(Application application) {
        DBExecutor executor = new DBExecutor();
        AlarmDB alarmDB = AlarmDB.getInstance(application);
        repoAlarmDao = alarmDB.alarmDao();
        repoDateDao = alarmDB.dateDao();
        allAlarms = repoAlarmDao.getAllAlarms();
    }

    void insertAlarm(Alarm addedAlarm) {
        executor.execute(new RunAlarmInsert(addedAlarm, repoAlarmDao));
    }

    void updateAlarm(Alarm updatedAlarm) {
        executor.execute(new RunAlarmUpdate(updatedAlarm, repoAlarmDao));
    }

    void updateAlarmFire(Alarm updatedAlarm) {
        executor.execute(new RunUpdateAlarmFire(updatedAlarm, repoAlarmDao));
    }

    void deleteAlarm(Alarm deletedAlarm) {
        executor.execute(new RunAlarmDelete(deletedAlarm, repoAlarmDao));
    }

    public LiveData<List<Alarm>> getAllAlarms(Alarm alarm) {
        return allAlarms;
    }

    void insertDate(Date insertedDate) {
        executor.execute(new RunInsertDate(insertedDate, repoDateDao));
    }

    void deleteDate(Date deletedDate) {
        executor.execute(new RunDeleteDate(deletedDate, repoDateDao));
    }

    long getNextFire(long alarmID) {
        return repoDateDao.getNextFire(alarmID);
    }

    List<AlarmWithDates> getAllDates(long alarmID) {
        return repoDateDao.getAllDates(alarmID);
    }

    private static class DBExecutor implements Executor {

        @Override
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private static class RunAlarmInsert implements Runnable {

        private Alarm alarm;
        private AlarmDao alarmDao;

        RunAlarmInsert(Alarm alarm, AlarmDao alarmDao) {
            this.alarm = alarm;
            this.alarmDao = alarmDao;
        }

        @Override
        public void run() {
            alarmDao.insertAlarm(alarm);
        }
    }

    private static class RunAlarmUpdate implements Runnable {

        private Alarm alarm;
        private AlarmDao alarmDao;

        RunAlarmUpdate(Alarm alarm, AlarmDao alarmDao) {
            this.alarm = alarm;
            this.alarmDao = alarmDao;
        }

        @Override
        public void run() {
            alarmDao.updateAlarm(alarm);
        }
    }

    private static class RunUpdateAlarmFire implements Runnable {

        private Alarm alarm;
        private AlarmDao alarmDao;

        RunUpdateAlarmFire(Alarm alarm, AlarmDao alarmDao) {
            this.alarm = alarm;
            this.alarmDao = alarmDao;
        }

        @Override
        public void run() {
            alarmDao.updateAlarmFire(alarm);
        }
    }

    private static class RunAlarmDelete implements Runnable {

        private Alarm alarm;
        private AlarmDao alarmDao;

        RunAlarmDelete(Alarm alarm, AlarmDao alarmDao) {
            this.alarm = alarm;
            this.alarmDao = alarmDao;
        }

        @Override
        public void run() {
            alarmDao.deleteAlarm(alarm);
        }
    }

    private static class RunInsertDate implements Runnable {

        private Date date;
        private DateDao dateDao;

        RunInsertDate(Date date, DateDao dateDao) {
            this.date = date;
            this.dateDao = dateDao;
        }

        @Override
        public void run() {
            dateDao.insertDate(date);
        }
    }

    private static class RunDeleteDate implements Runnable {

        private Date date;
        private DateDao dateDao;

        RunDeleteDate(Date date, DateDao dateDao) {
            this.date = date;
            this.dateDao = dateDao;
        }

        @Override
        public void run() {
            dateDao.deleteDate(date);
        }
    }
}
