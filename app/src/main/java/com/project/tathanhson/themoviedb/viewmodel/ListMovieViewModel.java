package com.project.tathanhson.themoviedb.viewmodel;

import com.project.tathanhson.themoviedb.model.api.res.MovieRes;

import java.util.ArrayList;
import java.util.List;

public class ListMovieViewModel extends BaseViewModel{
    public static final String TAG = ListMovieViewModel.class.getName();
    public static final String KEY_API_LIST_MOVIE = "KEY_API_LIST_MOVIE";

    private final List<MovieRes.Results> resultsList = new ArrayList<>();

    private int page = 0;
    public void getMovieList() {
        page++;
        getAPI().getListMovies(page).enqueue(initHandleResponse(KEY_API_LIST_MOVIE));
    }

    @Override
    protected void handleSuccess(String key, Object body) {
        if (key.equals(KEY_API_LIST_MOVIE)){
            MovieRes movieRes = (MovieRes) body;
            callback.apiSucsess(KEY_API_LIST_MOVIE, movieRes);
        }
    }


    public void addToResultListMovies(List<MovieRes.Results> results) {
        resultsList.addAll(results);
    }

    public List<MovieRes.Results> getResultsList() {
        return resultsList;
    }
}
