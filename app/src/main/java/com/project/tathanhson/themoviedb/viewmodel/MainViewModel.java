package com.project.tathanhson.themoviedb.viewmodel;

import android.util.Log;

import com.project.tathanhson.themoviedb.api.req.AccountReq;
import com.project.tathanhson.themoviedb.api.res.AuthenRes;

public class MainViewModel extends BaseViewModel {
    public static final String KEY_API_AUTHEN = "KEY_API_AUTHEN";
    public static final String KEY_API_CREATE_SESSION = "KEY_API_CREATE_SESSION";
    private String userName;
    private String password;

    public void getAuthen(String userName, String password) {
        this.userName = userName;
        this.password = password;
        getAPI().getAuthen().enqueue(initHandleResponse(KEY_API_AUTHEN));
    }

    public void createSession(String requestToken) {
        getAPI().createSession(new AccountReq(userName, password,requestToken)).enqueue(initHandleResponse(KEY_API_AUTHEN));
    }

    public void createSessionId(String requestToken) {
        getAPI().createSession(new AccountReq(userName, password,requestToken)).enqueue(initHandleResponse(KEY_API_AUTHEN));
    }

    @Override
    protected void handleSuccess(String key, Object body) {
        super.handleSuccess(key, body);
        Log.i("AAAAAAAAAAAA", "handleSuccess: "+key);
        Log.i("AAAAAAAAAAAA", "handleSuccess: "+body);
        if (key.equals(KEY_API_AUTHEN)){
            createSession(((AuthenRes)body).requestToken);
        }else
            if (key.equals(KEY_API_CREATE_SESSION)){
            createSessionId();
        }
    }
}
