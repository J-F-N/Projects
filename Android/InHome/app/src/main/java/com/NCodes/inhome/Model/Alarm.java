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
    private long nextFire;

    // constructor
    public Alarm(String title, String description, Long nextFire) {
        this.title = title;
        this.description = description;
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

    public void setId(int id) {
        this.alarmID = id;
    }

    public void setNextFire(long nextFire) {
        this.nextFire = nextFire;
    }
}
