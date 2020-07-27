package com.example.inhome;

import java.util.ArrayList;

public class AlarmWeekly extends Alarm {

    public AlarmWeekly(int alarmID, int alarmImage, String title, ArrayList<String> when) {

        this.alarmID = alarmID;
        this.alarmImage = alarmImage;
        this.title = title;
        this.when = when;
    }

    @Override
    public int getAlarmImage() {
        return 0;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public ArrayList<String> getWhen() {
        return when;
    }

    @Override
    public int getAlarmID() {
        return 0;
    }

    @Override
    public void setAlarmImage(int alarmImage) {
        this.alarmImage = alarmImage;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setWhen(ArrayList<String> when) {
        this.when = when;
    }

    @Override
    public void setAlarmID(int alarmID) {
        this.alarmID = alarmID;
    }

    @Override
    public void changeText(String text) {
        this.title = text;
    }
}
