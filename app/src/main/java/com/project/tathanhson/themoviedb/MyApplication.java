package com.project.tathanhson.themoviedb;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;
    private Storage storage;

    public static MyApplication getInstance() {
        return instance;
    }

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
