/*
Author: John Neigel
Created: 10/27/2020
Description: class to associate date table entries with their
respective alarms.
 */

package com.NCodes.inhome.Model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class AlarmWithDates {

    @Embedded public Alarm alarm;
    @Relation(
            parentColumn = "alarmID",
            entityColumn = "parentAlarmID"
    )

    public List<Date> dateList;
}
