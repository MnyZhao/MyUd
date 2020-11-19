package com.mny.popularmovie.utls;

import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.bean.MoviesReviews;
import com.mny.popularmovie.bean.MoviesViedo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieJsonUtils {
    public static List<Movies> getMovies(String moviesList) {
        List<Movies> mList = new ArrayList<>();
        try {
            JSONObject mObj = new JSONObject(moviesList);
            JSONArray array = mObj.getJSONArray("results");
            for (int i = 0; i < array.length(); i++) {
                Movies mv = new Movies();
                JSONObject item = array.getJSONObject(i);
                mv.setPopularity(item.getString("popularity"));
                mv.setVote_count(item.getInt("vote_count"));
                mv.setVideo(item.getBoolean("video"));
                mv.setPoster_path(item.getString("poster_path"));
                mv.setId(item.getString("id"));
                mv.setAdult(item.getBoolean("adult"));
                mv.setBackdrop_path(item.getString("backdrop_path"));
                mv.setOriginal_language(item.getString("original_language"));
                mv.setOriginal_title(item.getString("original_title"));
                mv.setVote_average(item.getDouble("vote_average"));
                JSONArray ids = item.getJSONArray("genre_ids");
                List<Integer> idsList = new ArrayList<>();
                for (int j = 0; j < ids.length(); j++) {
                    idsList.add(ids.getInt(j));
                }
                mv.setGenre_ids(idsList);
                mv.setTitle(item.getString("title"));
                mv.setVote_count(item.getInt("vote_average"));
                mv.setOverview(item.getString("overview"));
                mv.setRelease_date(item.getString("release_date"));
                mList.add(mv);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mList;
    }

    public static Movies getMovie(String movieInfo) {
        Movies mv = new Movies();
        JSONObject item = null;
        try {
            item = new JSONObject(movieInfo);
            mv.setPopularity(item.getString("popularity"));
            mv.setVote_count(item.getInt("vote_count"));
            mv.setVideo(item.getBoolean("video"));
            mv.setPoster_path(item.getString("poster_path"));
            mv.setId(item.getString("id"));
            mv.setAdult(item.getBoolean("adult"));
            mv.setBackdrop_path(item.getString("backdrop_path"));
            mv.setOriginal_language(item.getString("original_language"));
            mv.setOriginal_title(item.getString("original_title"));
            mv.setVote_average(item.getDouble("vote_average"));
            JSONArray ids = item.getJSONArray("genre_ids");
            List<Integer> idsList = new ArrayList<>();
            for (int j = 0; j < ids.length(); j++) {
                idsList.add(ids.getInt(j));
            }
            mv.setGenre_ids(idsList);
            mv.setTitle(item.getString("title"));
            mv.setVote_count(item.getInt("vote_average"));
            mv.setOverview(item.getString("overview"));
            mv.setRelease_date(item.getString("release_date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mv;
    }
    /**
     * 获取预告片
     *
     * @param video
     * @return
     */
    public static MoviesViedo getVideo(String video) {
        MoviesViedo moviesViedo = new MoviesViedo();
        try {
            JSONObject object = new JSONObject(video);
            moviesViedo.setId(object.getInt("id"));

            JSONArray array = object.getJSONArray("results");
            List<MoviesViedo.ResultsBean> list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                MoviesViedo.ResultsBean resultsBean = new MoviesViedo.ResultsBean();
                JSONObject oj = array.getJSONObject(i);
                resultsBean.setId(oj.getString("id"));
                resultsBean.setIso_639_1(oj.getString("iso_639_1"));
                resultsBean.setIso_3166_1(oj.getString("iso_3166_1"));
                resultsBean.setKey(oj.getString("key"));
                resultsBean.setName(oj.getString("name"));
                resultsBean.setSite(oj.getString("site"));
                resultsBean.setSize(oj.getInt("size"));
                resultsBean.setType(oj.getString("type"));
                list.add(resultsBean);
            }
            moviesViedo.setResults(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return moviesViedo;
    }

    /**
     * 获取评论
     *
     * @param reviews
     * @return
     */
    public static MoviesReviews getReviews(String reviews) {
        MoviesReviews re = new MoviesReviews();
        try {
            JSONObject object = new JSONObject(reviews);
            re.setId(object.getInt("id"));
            re.setPage(object.getInt("page"));
            re.setTotal_pages(object.getInt("total_pages"));
            re.setTotal_results(object.getInt("total_results"));

            JSONArray array = object.getJSONArray("results");
            List<MoviesReviews.ResultsBean> list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                MoviesReviews.ResultsBean resultsBean = new MoviesReviews.ResultsBean();
                JSONObject oj = array.getJSONObject(i);
                resultsBean.setId(oj.getString("id"));
                resultsBean.setAuthor(oj.getString("author"));
                resultsBean.setContent(oj.getString("content"));
                resultsBean.setUrl(oj.getString("url"));
                list.add(resultsBean);
            }
            re.setResults(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return re;
    }
}
