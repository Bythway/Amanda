package com.example.yeisongomez.amanda.Util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

import com.example.yeisongomez.amanda.Fragments.ActivitysFragment;
import com.example.yeisongomez.amanda.R;

/**
 * Created by YeisonGomez on 16/01/17.
 */

public class NotificationReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notify = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repiting_intent = new Intent(context, ActivitysFragment.class);
        repiting_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repiting_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        boolean sound = intent.getBooleanExtra("sound", true);
        String content = intent.getStringExtra("content");
        String title = intent.getStringExtra("title");

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        if (sound){
            if(alarmSound == null){
                alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            }
        } else {
            alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(content)
                .setVibrate(new long[] { 300, 300, 300, 300, 300 })
                .setSound(alarmSound)
                .setAutoCancel(true);

        notify.notify(100, builder.build() );
    }
}
