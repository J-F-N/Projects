/********* AlarmManager ***************************************************
 Class Description: Class to manage instantiation, retrieval, and deletion from database.
 ************************************************************************/

package com.example.inhome;

import java.util.ArrayList;

//constructor
public class AlarmManager {

    private ArrayList<Alarm> alarmList;

    //constructor
    public AlarmManager() {

        alarmList = new ArrayList<Alarm>();

        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 1", "today"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 2", "Teusday"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 3", "July 14th"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 4", "whenever"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 5", "never"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 1", "today"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 2", "Teusday"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 3", "July 14th"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 4", "whenever"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 5", "never"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 1", "today"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 2", "Teusday"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 3", "July 14th"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 4", "whenever"));
        alarmList.add(new Alarm(R.drawable.ic_baseline_access_alarm_24, "Alarm 5", "never"));

    }
    /********* shareList ***************************************************
     Description: Returns the alarm list as an ArrayList. Used by adapter to
     populate the recyclerview.
     ********** Return *******************************************************
     alarmList: ArrayList containing Alarm Objects.
     ************************************************************************/
    public ArrayList<Alarm> shareList() { return alarmList; }

/********* alarmByID ***************************************************
 Description: Returns an alarm object found by the id param.
 ********** Parameters ***************************************************
 int id: the unique identifier of an alarm stored in the database.
 ********** Return *******************************************************
 Alarm(object) alarm: the alarm retrieved from alarmList.
 ************************************************************************/

    public Alarm getItem (int position) {

        return alarmList.get(position);
    }
}






