package com.mny.popularmovie;

public class Config {
    public static final String API_KEY = "6b1e4ed35943b75e1e96475a2f15d54e";
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YjFlNGVkMzU5NDNiNzVlMWU5NjQ3NWEyZjE1ZDU0ZSIsInN1YiI6IjVmOTQzODc3NmUwZDcyMDA1OWZlZjYxYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.EMiakePZFBTqydcGHgxsoD5bcNWRZkP109MU2YlV1Rk";
    public static final String HTTP_POPULAR = "http://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY;
    public static final String HTTP_TOP = "http://api.themoviedb.org/3/movie/top_rated?api_key=" + API_KEY;
    public static final String BASE_IMG = "http://image.tmdb.org/t/p/w185/";
    public static final String MOVIE_VIDEO = "http://api.themoviedb.org/movie/";

    public static final String getVideosUrl(String movieID) {
        return MOVIE_VIDEO + movieID + "/videos";
    }
}
