/**************************AlarmDate************************************
 Description: Subclass of Alarm. Used to represent an alarm which
 will sound based on dates selected by the user. Implements Parcelable
 interface to allow sending the object back to parent activity.
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
import java.util.ArrayList;

public class AlarmDate extends Alarm  implements Parcelable {

    ArrayList<Long> dateArrayList; //used to store Long form dates selected by user.

    public AlarmDate() { dateArrayList = new ArrayList<Long>(); }

    public AlarmDate(int alarmID, int alarmImage, String title, String description, long[] dateArray) {

        this.alarmID = alarmID;
        this.alarmImage = alarmImage;
        this.title = title;
        this.description = description;

        for (long l : dateArray) {

            dateArrayList.add(l);
        }
    }

    //needed for parcelable interface
    protected AlarmDate(Parcel in) {

        alarmID = in.readInt();
        alarmImage = in.readInt();
        title = in.readString();
        description = in.readString();
        dateArrayList = in.readArrayList(null);
        hour = in.readInt();
        minute = in.readInt();
    }

    //needed for parcelable interface
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
        parcel.writeList(dateArrayList);
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
        return alarmID;
    }

    @Override
    public int getHour() { return hour; }

    @Override
    public int getMinute() { return minute; }

    @Override
    public String getDescription() { return description; }

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

    //used to set this alarms ArrayList of Long dates
    public void setDateArrayList(ArrayList<Long> dateArray) {

        dateArrayList.addAll(dateArray);
    }

    public String datesAsString() {

        StringBuilder arrayString = new StringBuilder();

        arrayString.append("Dates"); // we start this string to indicate this is a date array

        for (int i = 0; i < dateArrayList.size(); i++) {
            arrayString.append(" ").append(dateArrayList.get(i));
        }

        return arrayString.toString();
    }
}
