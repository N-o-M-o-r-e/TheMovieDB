package com.project.tathanhson.themoviedb.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.project.tathanhson.themoviedb.api.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseViewModel extends ViewModel {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String TAG ="AAAAAAAAA";
    protected final API getAPI(){
        Retrofit rs = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build())
                .build();
        return rs.create(API.class);
    }

    protected  <T> Callback<T> initHandleResponse(String key) {
        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.code()==200 || response.code()==201){
                    handleSuccess(key ,response.body());
                }else {
                    handleFaild(key, response.code(), response.errorBody());
                }
            }
            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                Log.e("AAAAAAAAAA", "onFailure: "+t.getMessage());
                handleException(key, t);
            }
        };
    }

    protected void handleException(String key, Throwable t) {

    }

    protected void handleFaild(String key, int code, ResponseBody responseBody) {
        Log.e("AAAAAAAA", "handleFaild: "+code);
        if (code==401){
            //authen faild

        }else{
            //something went wrong
        }
    }

    protected void handleSuccess(String key,Object body) {
        //do nothing
    }
}
