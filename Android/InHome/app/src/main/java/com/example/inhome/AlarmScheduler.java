package com.example.inhome;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class AlarmScheduler  {



    void scheduleAlarm(Alarm alarm, long alarmID, Context context) {

        // this is a weekly alarm
        if(alarm.getClass() == AlarmWeekly.class) {

            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.HOUR_OF_DAY, alarm.getHour());
            cal.set(Calendar.MINUTE, alarm.getMinute());
            cal.set(Calendar.SECOND, 0);

            boolean[] dayArray = ((AlarmWeekly) alarm).getDays();

            for(int i = 0; i < dayArray.length; i++) {

                int weekDay = 1;

                if(dayArray[i] == true) {

                    weekDay += i;

                    cal.set(Calendar.DAY_OF_WEEK, weekDay);

                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent(context, AlarmReceiver.class);
                    intent.putExtra("id", alarmID);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, (int)alarmID, intent, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

                }
            }

        }

        // this is a date alarm
        else {


        }
    }
}
