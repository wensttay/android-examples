package com.example.wensttay.notification_example;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import java.util.Random;

public class BroadcastReceiverAlarme extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("NOTIFICATION-EXAMPLE", "BroadcastReceiverAlarme.onReceive()");

        gerarNotificacao(context,
                new Intent(context, MainActivity.class),
                "Ticker Text",
                "ContentTitle Text",
                "ContentText Text",
                "SubText Text");
    }

    public void gerarNotificacao(Context context,
                                 Intent intent,
                                 String ticker,
                                 String contentTitle,
                                 String contentText,
                                 String subText){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker(ticker);
        builder.setContentTitle(contentTitle);
        builder.setContentText(contentText);
        builder.setSubText(subText);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_round));
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setVibrate(new long[]{160, 320, 160, 320});
        builder.setAutoCancel(true);


//        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
//        String[] text = new String[]{"Linha 1", "Linha 2", "Linha 3"};
//        for (String s: text) {
//            inboxStyle.addLine(s);
//        }
//        builder.setStyle(inboxStyle);

//        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
///

        try {
            Notification notification = builder.build();
//            notification.vibrate = new long[]{100, 200, 100, 200};
//            notification.flags = Notification.FLAG_AUTO_CANCEL;

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            notificationManager.notify(new Random().nextInt(1000), notification);

//            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            Ringtone ringtone = RingtoneManager.getRingtone(this, uri);
//            ringtone.play();

        }catch (Exception e){
            Log.i("NOTIFICATION-EXAMPLE", "ERROR: " + e.getMessage());
        }
    }
}
