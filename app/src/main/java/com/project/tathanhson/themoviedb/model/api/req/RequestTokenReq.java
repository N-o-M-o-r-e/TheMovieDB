package com.project.tathanhson.themoviedb.model.api.req;

import com.google.gson.annotations.SerializedName;

public class RequestTokenReq {
    @SerializedName("request_token")
    public String requestToken;

    public RequestTokenReq(String requestToken){
        this.requestToken = requestToken;
    }
}
