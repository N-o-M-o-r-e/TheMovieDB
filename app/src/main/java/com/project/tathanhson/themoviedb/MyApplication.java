package com.project.tathanhson.themoviedb;

import android.app.Application;

import androidx.annotation.Nullable;

public class MyApplication extends Application {
    private static MyApplication instance;
    private Storage storage;

    @Nullable
    public static MyApplication getInstance() {
        return instance;
    }

    @Nullable
    public Storage getStorage() {
        return storage;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storage = new Storage();
    }
}
