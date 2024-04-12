package com.project.tathanhson.themoviedb;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CommonUtils {
    private static final String FILE_SAVE = "pref_saved";
    private static CommonUtils instance;

    @NonNull
    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }

    public void savePref(@Nullable String key, @Nullable String value) {
        SharedPreferences pref = MyApplication.getInstance().getSharedPreferences(FILE_SAVE, Context.MODE_PRIVATE);
        pref.edit().putString(key, value).apply();
    }

    @Nullable
    public String getPref(@Nullable String key) {
        SharedPreferences pref = MyApplication.getInstance().getSharedPreferences(FILE_SAVE, Context.MODE_PRIVATE);
        return pref.getString(key, null);
    }

    public void clearPref(@Nullable String key) {
        SharedPreferences pref = MyApplication.getInstance().getSharedPreferences(FILE_SAVE, Context.MODE_PRIVATE);
        pref.edit().remove(key).apply();
    }
}
