package com.project.tathanhson.themoviedb.viewmodel;

import android.util.Log;

import com.project.tathanhson.themoviedb.model.api.res.DetailMoviesRes;
import com.project.tathanhson.themoviedb.view.fragment.MovieDetailFragment;

public class MovieDetailVM extends BaseViewModel{
    public static final String TAG = MovieDetailFragment.class.getName();
    private static final String KEY_GET_DETAIL_MOVIE = "KEY_GET_DETAIL_MOVIE";
    public void getMovieDetail(int id) {
        Log.i(TAG, "getMovieDetail: "+id);
        getAPI().getDetailMovie(id).enqueue(initHandleResponse(KEY_GET_DETAIL_MOVIE));
    }


}
