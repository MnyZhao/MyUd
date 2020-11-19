package com.mny.popularmovie.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.mny.popularmovie.App;
import com.mny.popularmovie.bean.Movies;

@Database(entities = {Movies.class}, version = 1)
public abstract class FavoriteDatabase extends RoomDatabase {
    public abstract MoviesDao userDao();

    private static FavoriteDatabase favoriteDatabase;

    public static FavoriteDatabase getInstance() {
        if (favoriteDatabase == null) {

            favoriteDatabase = Room.databaseBuilder(App.context, FavoriteDatabase.class, "favorite")
                    .allowMainThreadQueries()//允许在主线程中查询
                    .build();
        }
        return favoriteDatabase;
    }
}
