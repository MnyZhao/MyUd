package com.mny.popularmovie.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.room.FavoriteDatabase;
import com.mny.popularmovie.room.MoviesDao;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    public LiveData<List<Movies>> movieLiveData;

    public MovieViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movies>> getMovieLiveData() {
        movieLiveData = FavoriteDatabase.getInstance().userDao().getAll();
        return movieLiveData;
    }

}
