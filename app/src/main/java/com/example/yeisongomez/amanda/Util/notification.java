package com.example.yeisongomez.amanda.Util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YeisonGomez on 16/01/17.
 */

public class Notification {

    public void notificate(Context ctx, String title, String content){
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        System.out.println(timeFormatter.format(time));
        time.setMinutes(time.getMinutes() + 1);

        Intent intent = new Intent(ctx.getApplicationContext(), NotificationReciever.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);

        PendingIntent  pendingIntent = PendingIntent.getBroadcast(ctx.getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) ctx. getSystemService(ctx.ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, time.getTime(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}
