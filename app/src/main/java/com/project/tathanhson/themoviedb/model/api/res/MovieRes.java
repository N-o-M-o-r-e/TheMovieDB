package com.project.tathanhson.themoviedb.model.api.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieRes implements Serializable {
    @SerializedName("page")
    public int page;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("results")
    public List<Results> results;

    @SerializedName("total_results")
    public int totalResults;

    public static class Results implements Serializable {
        @SerializedName("adult")
        public boolean adult;

        @SerializedName("backdrop_path")
        public String backdropPath;

        @SerializedName("id")
        public int id;

        @SerializedName("original_title")
        public String title;

        @SerializedName("overview")
        public String overview;

        @SerializedName("poster_path")
        public String posterPath;

        @SerializedName("release_date")
        public String releaseDate;
    }

}
