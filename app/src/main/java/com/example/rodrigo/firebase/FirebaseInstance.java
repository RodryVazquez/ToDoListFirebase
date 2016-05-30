package com.example.rodrigo.firebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Rodrigo on 5/28/2016.
 */
public class FirebaseInstance extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
