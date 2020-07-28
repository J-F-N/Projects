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

        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(1, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(2, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(3, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(4, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(5, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(6, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(7, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(8, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(9, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(10, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(11, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(12, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(13, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmList.add(new AlarmWeekly(14, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
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

    public void CreateNewWeekly (int alarmId, int alarmImage, String alarmTitle, String when) {


    }

    public void CreateNewDate (int alarmId, int alarmImage, String alarmTitle, String when) {


        //todo change for alarm dates
    }
}






