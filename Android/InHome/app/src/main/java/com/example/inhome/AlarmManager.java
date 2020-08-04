/**************************CLASS NAME***********************************
 Description: Class to manage Alarm objects during runtime. Also handles
 insertion, retrieval, and deletion of Alarms from database.
 ***********************************************************************
 Created Date: 07/19/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/29/2020
 **********************************************************************/

package com.example.inhome;

import java.util.ArrayList;
import java.util.HashMap;

//constructor
public class AlarmManager {

    int IDCounter = 15; //todo remove after proper id generation is established in DB
    ArrayList<Alarm> alarmList;

    //constructor
    public AlarmManager() {

        alarmList = new ArrayList<Alarm>();
        boolean[] testingArray = {true, true, true, true, true, true, true}; //todo remove after testing

        //todo remove after testing.
        // sample alarms to test RecyclerView
        
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 1", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 2", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 3", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 4", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 5", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 6", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 7", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 8", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 9", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 10", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 11", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 12", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 13", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 14", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 15", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 16", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 17", "a useful alarm", testingArray));
        alarmList.add(new AlarmWeekly(0, R.drawable.ic_baseline_access_alarm_24, "Alarm 18", "a useful alarm", testingArray));
    }

    /********* shareList ***************************************************
     Description: Returns the alarm list as an ArrayList. Used by adapter to
     populate the recyclerview.
     ********** Return *******************************************************
     alarmHashMap: HashMap containing Alarm Objects.
     ************************************************************************/
    public ArrayList<Alarm> shareList() { return alarmList; }
    //public HashMap<Integer, Alarm> shareList() { return alarmHashMap; }

    /********* getItem ***************************************************
     Description: Returns an alarm object found by the key in the HashMap.
     ********** Parameters ***************************************************
     int id: the unique identifier of an alarm stored in the database.
     ********** Return *******************************************************
     Alarm(object) alarm: the alarm retrieved from alarmList.
     ************************************************************************/

    public Alarm getItem (int position) {

        return alarmList.get(position);
    }

    public void addAlarm (Alarm alarm) {

        //todo remove after testing
        // generate an alarmID for the alarm to insert into hashmap
        alarm.alarmID = IDCounter;
        IDCounter++;

        alarmList.add(alarm);
    }

    public void deleteAlarm(int alarmID) { alarmList.remove(alarmID); }
}






