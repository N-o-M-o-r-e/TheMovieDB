package com.project.tathanhson.themoviedb.model.api.res;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SessionRes implements Serializable {
    @SerializedName("success")
    public Boolean success;
    @SerializedName("session_id")
    public String sessionId;


    @Override
    public String toString() {
        return "SessionRes{" +
                "success=" + success +
                ", session_id='" + sessionId + '\'' +
                '}';
    }
}
