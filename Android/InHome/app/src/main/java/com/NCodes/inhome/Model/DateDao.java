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
import androidx.room.Update;

import java.util.List;

@Dao
public interface DateDao {

    @Insert
    void insert(Date addedDate);

    @Update
    void update(Date updatedDate);

    @Delete
    void delete(Date deletedDate);

    // returns a list of all long value dates for a specific alarm by that alarms ID.
    @Query("SELECT * FROM alarm_table WHERE alarmID = :alarmID")
    public List<AlarmWithDates> getAllDates(long alarmID);

    // returns the top ordered entry from an alarm's set of dates
    // this is the next activation which should occur.
    @Query("SELECT date FROM date_table WHERE parentAlarmID = :alarmID ORDER BY date ASC LIMIT 1")
    long getNextFire(long alarmID);
}
