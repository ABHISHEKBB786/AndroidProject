package com.example.mydatabase;

import android.app.Application;

import com.firebase.client.Firebase;


public class comapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
