package com.example.inhome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int alarmID = intent.getIntExtra("id", -1);

        Intent i = new Intent(context, ActivityAlarmActivation.class);
        i.putExtra("id", alarmID);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
