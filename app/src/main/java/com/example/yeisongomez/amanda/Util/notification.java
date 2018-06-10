package com.example.yeisongomez.amanda.Util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YeisonGomez on 16/01/17.
 */

public class Notification {

    public void notificate(Context ctx, String title, String content, boolean isSoundAlarm, String hour, String day) {

        SimpleDateFormat timeFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
        Calendar time = Calendar.getInstance();
        time.setTime(new Date(System.currentTimeMillis()));
        time.set(Calendar.DAY_OF_WEEK, 2);
        time.set(Calendar.HOUR, 9);
        time.set(Calendar.MINUTE, 56);
        System.out.println(timeFormatter.format(time.getTime()));

        Intent intent = new Intent(ctx.getApplicationContext(), NotificationReciever.class);
        intent.putExtra("title", title);
        intent.putExtra("content", timeFormatter.format(time.getTime()));
        intent.putExtra("sound", isSoundAlarm);

        PendingIntent  pendingIntent = PendingIntent.getBroadcast(ctx.getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) ctx. getSystemService(ctx.ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), 24 * 60 * 60 * 1000, pendingIntent);
        alarm.cancel(pendingIntent);
    }

}
