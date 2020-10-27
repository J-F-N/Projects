package com.NCodes.inhome.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "date_table")
public class Date {

    // member variables
    @PrimaryKey(autoGenerate = true)
    int dateID;

    long parentAlarmID;
    long date;
}
