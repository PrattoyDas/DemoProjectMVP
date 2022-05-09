package com.example.logindemoproject.common;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.example.logindemoproject.FontsOverride;
import com.example.logindemoproject.common.di.component.WingsAppComponent;
import com.example.logindemoproject.common.di.component.DaggerWingsAppComponent;
import com.example.logindemoproject.common.di.module.ContextModule;

public class WingsApplication extends MultiDexApplication {
    private static WingsApplication instance;
    public static final String CHANNEL_1_ID = "channel1";
    public static Context context;
    private WingsAppComponent wingsAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        context = getApplicationContext();
        wingsAppComponent = DaggerWingsAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        FontsOverride.setDefaultFont(this, "DEFAULT", "font/helveticaneuelight.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "font/helveticaneuelight.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "font/helveticaneuelight.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "font/helveticaneuelight.ttf");

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("this is channel 1");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized WingsApplication getInstance() {
        return instance;
    }


    public WingsAppComponent getWingsAppComponent() {
        return wingsAppComponent;
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public static Context getContext() {
        return context;
    }

}
