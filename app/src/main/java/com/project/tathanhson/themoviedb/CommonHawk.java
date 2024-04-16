package com.project.tathanhson.themoviedb;

import androidx.annotation.NonNull;

import com.orhanobut.hawk.Hawk;

public class CommonHawk {
    public void putHawkData(int event) {
        Hawk.put("DATA", event);
    }

    public int getHawkData() {
        return Hawk.get("DATA", 0);
    }

    public void deleteHawkData(@NonNull String key) {
        Hawk.delete(key);
    }

    public void deleteHawkDataAll(@NonNull String key) {
        Hawk.deleteAll();
    }

}
