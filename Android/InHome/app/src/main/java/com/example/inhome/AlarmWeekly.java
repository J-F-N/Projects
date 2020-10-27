/**************************AlarmWeekly**********************************
 Description: Subclass of Alarm. Used to represent an alarm which
 will sound based on weekdays selected by the user. Implements
 Parcelable interface to allow sending the object back to parent
 activity.
 ***********************************************************************
 Created Date: 07/20/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/27/2020
 **********************************************************************/
package com.example.inhome;

import android.os.Parcel;
import android.os.Parcelable;

public class AlarmWeekly extends Alarm implements Parcelable {

    private boolean[] dayArray = new boolean[7]; // used to store the active days of the week

    public AlarmWeekly(int alarmID, int alarmImage, String title, String description, boolean[] dayArray) {

        this.alarmID = alarmID;
        this.alarmImage = alarmImage;
        this.title = title;
        this.description = description;
        System.arraycopy(this.dayArray, 0, dayArray, 0, 7);
    }

    public AlarmWeekly() {}

    //needed for parcelable interface
    protected AlarmWeekly(Parcel in) {

        alarmID = in.readInt();
        alarmImage = in.readInt();
        title = in.readString();
        description = in.readString();
        dayArray = in.createBooleanArray();
        hour = in.readInt();
        minute = in.readInt();
    }

    //needed for parcelable interface
    public static final Creator<AlarmWeekly> CREATOR = new Creator<AlarmWeekly>() {
        @Override
        public AlarmWeekly createFromParcel(Parcel in) {
            return new AlarmWeekly(in);
        }

        @Override
        public AlarmWeekly[] newArray(int size) {
            return new AlarmWeekly[size];
        }
    };



    //needed for parcelable interface
    @Override
    public int describeContents() {
        return 0;
    }

    //needed for parcelable interface
    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(alarmID);
        parcel.writeInt(alarmImage);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeBooleanArray(dayArray);
        parcel.writeInt(hour);
        parcel.writeInt(minute);
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
        return 0;
    }

    @Override
    public int getHour() { return hour; }

    @Override
    public int getMinute() { return minute; }

    @Override
    public String getDescription() { return description; }

    public boolean[] getDays() { return dayArray; };

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

    // set a specific day of the week.
    public void setDays(int position, boolean setting) {

        dayArray[position] = setting;
    }

    // set this alarms active days of the week
    public void setDays(boolean[] sourceArray) {

        System.arraycopy(sourceArray, 0, this.dayArray, 0, 7);
    }

    public String daysAsString() {

        StringBuilder arrayString = new StringBuilder();

        arrayString.append("Days"); // we start this string to indicate this is a weekday array

        for (boolean value: dayArray) {
            arrayString.append(" ").append(value);
        }

        return arrayString.toString();
    }
}
