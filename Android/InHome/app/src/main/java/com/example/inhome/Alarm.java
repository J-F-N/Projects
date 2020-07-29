package com.example.inhome;

import java.util.ArrayList;

public abstract class Alarm {

    protected int alarmID;              //unique alarm identifier
    protected int alarmImage;           //image to show alarm type
    protected String title;
    protected String when;   //todo remove after specific alarms are implemented
    protected String description;
    protected int hour;
    protected int minute;

    //getters
    public abstract int getAlarmImage();
    public abstract String getTitle();
    public abstract int getAlarmID();

    public abstract int getHour();
    public abstract int getMinute();

    //setters
    public abstract void setAlarmImage(int alarmImage);
    public abstract void setTitle(String title);
    public abstract void setDescription(String description);
    public abstract void setAlarmID(int alarmID);
    public abstract void setHour(int hour);
    public abstract void setMinute(int minute);

    //todo remove after testing
    public abstract void changeText (String text);
}
