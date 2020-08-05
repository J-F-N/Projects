/**************************Alarm****************************************
 Description: Abstract superclass to AlarmDate and AlarmWeekly. Holds
 data fields for values common to both subclasses and method signatures
 for later implementation in subclasses.
 ***********************************************************************
 Created Date: 07/15/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/27/2020
 **********************************************************************/
package com.example.inhome;

public abstract class Alarm {

    protected int alarmID;          // unique alarm identifier
    protected int alarmImage;       // image to show alarm type
    protected String title;         // user entered title of the alarm
    protected String description;   // user entered description of the alarm
    protected int hour;             // the hour the alarm will sound
    protected int minute;           // the minute the alarm will sound

    // getters
    public abstract int getAlarmImage();
    public abstract String getTitle();
    public abstract int getAlarmID();
    public abstract int getHour();
    public abstract int getMinute();
    public abstract String getDescription();

    // setters
    public abstract void setAlarmImage(int alarmImage);
    public abstract void setTitle(String title);
    public abstract void setDescription(String description);
    public abstract void setAlarmID(int alarmID);
    public abstract void setHour(int hour);
    public abstract void setMinute(int minute);
}
