package com.project.tathanhson.themoviedb;

public interface OnAPICallback {
    void apiSucsess(String key, Object data);
    void apiError(String key, int code, Object data);
}
