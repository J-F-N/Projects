package com.example.inhome;

import android.os.Parcel;
import android.os.Parcelable;

public class AlarmDate extends Alarm  implements Parcelable {



    public AlarmDate(int alarmID, int alarmImage, String title, String when, String description) {

        this.alarmID = alarmID;
        this.alarmImage = alarmImage;
        this.title = title;
        this.when = when;
        this.desrciption = description;
    }

    protected AlarmDate(Parcel in) {

        alarmID = in.readInt();
        alarmImage = in.readInt();
        title = in.readString();
        when = in.readString();
        desrciption = in.readString();
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
        parcel.writeString(desrciption);
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
    public String getWhen() {
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
    public void setWhen(String when) {
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
