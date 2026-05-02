package com.example.swayamai;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager manager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "swayam_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                channelId,
                "Swayam AI Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(channel);
        }

        Notification.Builder builder =
        new Notification.Builder(this)
        .setContentTitle("Swayam AI")
        .setContentText("Test Notification 🚀")
        .setSmallIcon(android.R.drawable.ic_dialog_info);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(channelId);
        }

        manager.notify(1, builder.build());
    }
}
