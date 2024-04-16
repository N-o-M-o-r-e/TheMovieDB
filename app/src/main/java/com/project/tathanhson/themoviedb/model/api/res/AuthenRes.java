package com.project.tathanhson.themoviedb.model.api.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthenRes implements Serializable {
    @SerializedName("success")
    public Boolean success;
    @SerializedName("expires_at")
    public String expiresAt;
    @SerializedName("request_token")
    public String requestToken;

    @Override
    public String toString() {
        return "AuthenRes{" +
                "success=" + success +
                ", expiresAt='" + expiresAt + '\'' +
                ", requestToken='" + requestToken + '\'' +
                '}';
    }
}
