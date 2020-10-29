/*
Author: John Neigel
Created: 10/27/2020
Description: AlarmDao is an interface class for handling
SQLite database CRUD operations of Alarm entries.
 */

package com.NCodes.inhome.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AlarmDao {

    @Insert
    void insertAlarm(Alarm addedAlarm);

    @Update
    void updateAlarm(Alarm updatedAlarm);

    @Update
    @Transaction
    void updateAlarmFire(Alarm updatedAlarm);

    @Delete
    void deleteAlarm(Alarm deletedAlarm);

    @Query("SELECT * FROM alarm_table ORDER BY NEXTFIRE ASC")
    LiveData<List<Alarm>> getAllAlarms();
}
