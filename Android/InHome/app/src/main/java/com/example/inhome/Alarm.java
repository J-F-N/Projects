package com.example.inhome;

public class Alarm {

    private int alarmID;    //unique alarm identifier
    private int alarmImage; //image to show alarm type
    private String title;
    private String when;    //date and time of the alarm

    //constructor
    public Alarm(int alarmImage, String title, String when){
        this.alarmImage = alarmImage;
        this.title = title;
        this.when = when;
        alarmID = 0;        //id will be properly assigned from database value
    }

    //getters
    public int getAlarmImage() {return alarmImage;}
    public String getTitle() {return title;}
    public String getWhen() {return when;}

    public int getAlarmID() { return alarmID; }

    //setters
    public void setAlarmImage(int alarmImage) {this.alarmImage = alarmImage;}
    public void setTitle(String title) {this.title = title;}
    public void setWhen(String when) {this.when = when;}
    public void setAlarmID(int alarmID) { this.alarmID = alarmID; }
}
