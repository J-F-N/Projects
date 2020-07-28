/********* AlarmManager ***************************************************
 Class Description: Class to manage Alarm objects during runtime. Also handles insertion, retrieval, and deletion of Alarms from database.
 ************************************************************************/

package com.example.inhome;

import java.util.HashMap;

//constructor
public class AlarmManager {

    HashMap<Integer, Alarm> alarmHashMap;

    //constructor
    public AlarmManager() {

        alarmHashMap = new HashMap<Integer, Alarm>();

        alarmHashMap.put(0, new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(1, new AlarmWeekly(1, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(2, new AlarmWeekly(2, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(3, new AlarmWeekly(3, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(4, new AlarmWeekly(4, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(5, new AlarmWeekly(5, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(6, new AlarmWeekly(6, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(7, new AlarmWeekly(7, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(8, new AlarmWeekly(8, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(9, new AlarmWeekly(9, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(10, new AlarmWeekly(10, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(11, new AlarmWeekly(11, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(12, new AlarmWeekly(12, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(13, new AlarmWeekly(13, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
        alarmHashMap.put(14, new AlarmWeekly(14, R.drawable.ic_baseline_access_alarm_24, "Do Something", "sometime"));
    }

    /********* shareList ***************************************************
     Description: Returns the alarm list as an ArrayList. Used by adapter to
     populate the recyclerview.
     ********** Return *******************************************************
     alarmList: ArrayList containing Alarm Objects.
     ************************************************************************/
    public HashMap<Integer, Alarm> shareList() { return alarmHashMap; }

    /********* getItem ***************************************************
     Description: Returns an alarm object found by the key in the HashMap.
     ********** Parameters ***************************************************
     int id: the unique identifier of an alarm stored in the database.
     ********** Return *******************************************************
     Alarm(object) alarm: the alarm retrieved from alarmList.
     ************************************************************************/

    public Alarm getItem (int alarmID) {

        return alarmHashMap.get(alarmID);
    }

    /*public void addAlarm (Alarm alarm) {


        //todo generate an alarmID for the alarm to insert into hashmap
        alarmHashMap.put(alarmID, alarm);
    }*/
}






