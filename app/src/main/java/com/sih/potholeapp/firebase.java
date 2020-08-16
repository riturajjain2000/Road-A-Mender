package com.sih.potholeapp;

import android.app.Application;
import com.firebase.client.Firebase;

public class firebase extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }
}
