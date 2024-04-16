package com.project.tathanhson.themoviedb.view.interfaces;

import com.project.tathanhson.themoviedb.model.api.req.AccountReq;
import com.project.tathanhson.themoviedb.model.api.req.RequestTokenReq;
import com.project.tathanhson.themoviedb.model.api.res.AuthenRes;
import com.project.tathanhson.themoviedb.model.api.res.DetailMoviesRes;
import com.project.tathanhson.themoviedb.model.api.res.SessionRes;
import com.project.tathanhson.themoviedb.model.api.res.MovieRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    String API_KEY="b481af25015fa66e47fe76be05cd5844";

    @GET("authentication/token/new?api_key="+API_KEY)
    @Headers("Content-Type: application/json")
    Call<AuthenRes> getAuthen();

    @POST("authentication/token/validate_with_login?api_key="+API_KEY)
    @Headers("Content-Type: application/json")
    Call<AuthenRes> createSession(@Body AccountReq accountReq);

    @POST("authentication/session/new?api_key="+API_KEY)
    @Headers("Content-Type: application/json")
    Call<SessionRes> createSessionID(@Body RequestTokenReq tokenReq);

    @GET("discover/movie?language=en-US&api_key="+API_KEY)
    @Headers("Content-Type: application/json")
    Call<MovieRes> getListMovies(@Query("page") int page);

    @GET("movie/{id}?api_key="+API_KEY)
    @Headers("Content-Type: application/json")
    Call<DetailMoviesRes> getDetailMovie(@Path("id") int id);
}
