package com.example.backinblack.espressohovedopgave;

import android.app.Application;

import com.localytics.android.Localytics;


public class Localyticshelperclass extends Application {

    @Override
    public void onCreate()
    {
        Localytics.autoIntegrate(this);
        super.onCreate();


    }
}
