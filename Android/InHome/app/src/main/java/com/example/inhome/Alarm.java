package com.example.inhome;

import java.util.ArrayList;

public abstract class Alarm {

    protected int alarmID;              //unique alarm identifier
    protected int alarmImage;           //image to show alarm type
    protected String title;
    protected String when;   //todo remove after specific alarms are implemented

    //getters
    public abstract int getAlarmImage();
    public abstract String getTitle();
    public abstract String getWhen();

    public abstract int getAlarmID();

    //setters
    public abstract void setAlarmImage(int alarmImage);
    public abstract void setTitle(String title);
    public abstract void setWhen(String when);
    public abstract void setAlarmID(int alarmID);

    //todo remove after testing
    public abstract void changeText (String text);
}
