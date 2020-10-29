/*
Author: John Neigel
Created: 10/27/2020
Description: DateDao is an interface class for handling
SQLite database CRUD operations of Date entries
 */

package com.NCodes.inhome.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DateDao {

    @Insert
    void insertDate(Date addedDate);

    @Delete
    void deleteDate(Date deletedDate);

    // returns a list of all long value dates for a specific alarm by that alarms ID.
    @Query("SELECT * FROM alarm_table WHERE alarmID = :alarmID")
    @Transaction
    List<AlarmWithDates> getAllDates(long alarmID);

    // returns the top ordered entry from an alarm's set of dates
    // this is the next activation which should occur.
    @Query("SELECT date FROM date_table WHERE parentAlarmID = :alarmID ORDER BY date ASC LIMIT 1")
    @Transaction
    long getNextFire(long alarmID);
}
