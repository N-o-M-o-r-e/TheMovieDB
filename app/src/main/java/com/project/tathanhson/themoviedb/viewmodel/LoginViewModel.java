package com.project.tathanhson.themoviedb.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.Nullable;

import com.project.tathanhson.themoviedb.api.req.AccountReq;
import com.project.tathanhson.themoviedb.api.req.RequestTokenReq;
import com.project.tathanhson.themoviedb.api.res.AuthenRes;

public class LoginViewModel extends BaseViewModel {
    public static final String KEY_API_AUTHEN = "KEY_API_AUTHEN";
    public static final String KEY_API_CREATE_SESSION = "KEY_API_CREATE_SESSION";
    public static final String KEY_API_CREATE_SESSION_ID = "KEY_API_CREATE_SESSION_ID";
    private String userName;
    private String password;

    public void getAuthen(@Nullable String userName, @Nullable String password) {
        this.userName = userName;
        this.password = password;
        getAPI().getAuthen().enqueue(initHandleResponse(KEY_API_AUTHEN));
    }

    public void createSession(@Nullable String requestToken) {
        getAPI().createSession(new AccountReq(userName, password,requestToken)).enqueue(initHandleResponse(KEY_API_CREATE_SESSION));
    }

    public void createSessionId(@Nullable String requestToken) {
        getAPI().createSessionID(new RequestTokenReq(requestToken)).enqueue(initHandleResponse(KEY_API_CREATE_SESSION_ID));
    }


    @Override
    protected void handleSuccess( String key, Object body) {
        Log.i("AAAAAAAAAAAA", "handleSuccess: "+key);
        Log.i("AAAAAAAAAAAA", "handleSuccess: "+body);

        switch (key) {
            case KEY_API_AUTHEN:
                createSession(((AuthenRes) body).requestToken);
                break;
            case KEY_API_CREATE_SESSION:
                createSessionId(((AuthenRes) body).requestToken);
                break;
            case KEY_API_CREATE_SESSION_ID:
                callback.apiSucsess(key, body);
                break;
        }
    }
}
