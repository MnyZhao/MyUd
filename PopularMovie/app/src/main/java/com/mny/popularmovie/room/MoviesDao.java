package com.mny.popularmovie.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import com.mny.popularmovie.bean.Movies;

import java.util.List;

@Dao
public interface MoviesDao {
    @Query("SELECT * FROM Movies")
    LiveData<List<Movies>> getAll();

    @Insert
    void insert(Movies movies);

    @Delete
    void delete(Movies movies);

    @Query("DELETE FROM movies WHERE ids=:ids")
    void delete(String ids);

    @Query("SELECT COUNT(*)  FROM Movies WHERE ids=:ids")
    int query(String ids);
}
