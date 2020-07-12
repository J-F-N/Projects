package com.example.inhome;

public class card {

    private int alarmImage;
    private String title;
    private String when;

    //constructor
    public card(int alarmImage, String title, String when){
        this.alarmImage = alarmImage;
        this.title = title;
        this.when = when;
    }

    //getters
    public int getAlarmImage() {return alarmImage;}
    public String getTitle() {return title;}
    public String getWhen() {return when;}

    //setters
    public void setAlarmImage(int alarmImage) {this.alarmImage = alarmImage;}
    public void setTitle(String title) {this.title = title;}
    public void setWhen(String when) {this.when = when;}
}
