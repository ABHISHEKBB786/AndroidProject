package com.example.mydatabase;

import android.app.Application;

import com.firebase.client.Firebase;

public class mydata extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
