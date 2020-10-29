/*
Author: John Neigel
Created: 10/27/2020
Description: Alarms contain all necessary information for when the user
should be notified and a recording played. Alarm is an Room Entity, representing
a row in the SQLite DB. Each Alarm primary key in the DB corresponds to foreign keys
of Long values in the Date table.
 */

package com.NCodes.inhome.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "alarm_table")
public class Alarm {

    // member variables
    @PrimaryKey(autoGenerate = true)
    private int alarmID;

    private String title;
    private String description;
    private String recFilePath; // file path to local directory holding recording for alarm.

    private long nextFire;      // the next date the alarm should fire.
                                // used to schedule the pending intent.

    // constructor
    public Alarm(String title, String description, String recFilePath, long nextFire) {
        this.title = title;
        this.description = description;
        this.recFilePath = recFilePath;
        this.nextFire = nextFire;
    }

    // public methods
    public int getId() {
        return alarmID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getNextFire() {
        return nextFire;
    }

    public String getRecFilePath() {
        return recFilePath;
    }

    public void setId(int id) {
        this.alarmID = id;
    }

    public void setRecFilePath(String recFilePath) {
        this.recFilePath = recFilePath;
    }

    public void setNextFire(long nextFire) {
        this.nextFire = nextFire;
    }
}
