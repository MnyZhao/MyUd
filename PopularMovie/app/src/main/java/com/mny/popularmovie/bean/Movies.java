package com.mny.popularmovie.bean;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movies implements Parcelable {

    /**
     * popularity : 2408.848
     * vote_count : 165
     * video : false
     * poster_path : /7D430eqZj8y3oVkLFfsWXGRcpEG.jpg
     * id : 528085
     * adult : false
     * backdrop_path : /5UkzNSOK561c2QRy2Zr4AkADzLT.jpg
     * original_language : en
     * original_title : 2067
     * genre_ids : [18,878,53]
     * title : 2067
     * vote_average : 5.7
     * overview : A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet.
     * release_date : 2020-10-01
     */
    @PrimaryKey(autoGenerate = true)
    public int key;
    @Ignore
    public String popularity;
    @Ignore
    public int vote_count;
    @Ignore
    public boolean video;
    @ColumnInfo(name = "poster_path")
    public String poster_path;
    @ColumnInfo(name = "ids")
    public String id;
    @Ignore
    public boolean adult;
    @Ignore
    public String backdrop_path;
    @Ignore
    public String original_language;
    @Ignore
    public String original_title;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "vote_average")
    public double vote_average;
    @ColumnInfo(name = "overview")
    public String overview;
    @ColumnInfo(name = "release_date")
    public String release_date;
    @Ignore
    public List<Integer> genre_ids;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public static Creator<Movies> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.key);
        dest.writeString(this.popularity);
        dest.writeInt(this.vote_count);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeString(this.poster_path);
        dest.writeString(this.id);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.original_language);
        dest.writeString(this.original_title);
        dest.writeString(this.title);
        dest.writeDouble(this.vote_average);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
        dest.writeList(this.genre_ids);
    }

    public Movies() {
    }

    protected Movies(Parcel in) {
        this.key = in.readInt();
        this.popularity = in.readString();
        this.vote_count = in.readInt();
        this.video = in.readByte() != 0;
        this.poster_path = in.readString();
        this.id = in.readString();
        this.adult = in.readByte() != 0;
        this.backdrop_path = in.readString();
        this.original_language = in.readString();
        this.original_title = in.readString();
        this.title = in.readString();
        this.vote_average = in.readDouble();
        this.overview = in.readString();
        this.release_date = in.readString();
        this.genre_ids = new ArrayList<Integer>();
        in.readList(this.genre_ids, Integer.class.getClassLoader());
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
