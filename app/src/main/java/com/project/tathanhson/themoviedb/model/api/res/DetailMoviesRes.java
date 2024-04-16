package com.project.tathanhson.themoviedb.model.api.res;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DetailMoviesRes implements Serializable {
    @SerializedName("title")
    public String title;

    @SerializedName("vote_average")
    public double voteAverage;

    @SerializedName("release_date")
    public String releaseDate;

    @Nullable
    @SerializedName("genres")
    public List<DetailMoviesRes.Genres> genres;

    @SerializedName("overview")
    public String overview;

    @SerializedName("runtime")
    public int runtime;

    @SerializedName("tagline")
    public String tagLine;

    @SerializedName("backdrop_path")
    public String backdropPath;

    @SerializedName("poster_path")
    public String posterPath;

    @Override
    public String toString() {
        return "DetailMoviesRes{" +
                "title='" + title + '\'' +
                '}';
    }

    public static class Genres {
        @SerializedName("id")
        public int id;

        @SerializedName("name")
        public String name;
    }

}
