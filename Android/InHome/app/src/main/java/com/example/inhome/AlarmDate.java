package com.example.inhome;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AlarmDate extends Alarm  implements Parcelable {

    ArrayList<Long> dateArrayList;

    public AlarmDate() { dateArrayList = new ArrayList<Long>(); }

    public AlarmDate(int alarmID, int alarmImage, String title, String when, String description, long[] dateArray) {

        this.alarmID = alarmID;
        this.alarmImage = alarmImage;
        this.title = title;
        this.when = when;
        this.description = description;

        for (long l : dateArray) {

            dateArrayList.add(l);
        }
    }

    protected AlarmDate(Parcel in) {

        alarmID = in.readInt();
        alarmImage = in.readInt();
        title = in.readString();
        when = in.readString();
        description = in.readString();
    }

    public static final Creator<AlarmDate> CREATOR = new Creator<AlarmDate>() {
        @Override
        public AlarmDate createFromParcel(Parcel in) {
            return new AlarmDate(in);
        }

        @Override
        public AlarmDate[] newArray(int size) {
            return new AlarmDate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(alarmID);
        parcel.writeInt(alarmImage);
        parcel.writeString(title);
        parcel.writeString(when);
        parcel.writeString(description);
    }

    @Override
    public int getAlarmImage() {
        return alarmImage;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getAlarmID() {
        return alarmID;
    }

    @Override
    public int getHour() { return hour; }

    @Override
    public int getMinute() { return minute; }

    @Override
    public void setAlarmImage(int alarmImage) {
        this.alarmImage = alarmImage;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setAlarmID(int alarmID) {
        this.alarmID = alarmID;
    }

    @Override
    public void setHour(int hour) { this.hour = hour; }

    @Override
    public void setMinute(int minute) { this.minute = minute; }

    public void setDateArrayList(ArrayList<Long> dateArray) {

        dateArrayList.addAll(dateArray);
    }

    @Override
    public void changeText(String text) {
        this.title = text;
    }
}
