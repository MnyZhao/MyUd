package com.mny.popularmovie.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MoviesViedo implements Parcelable {

    /**
     * id : 671039
     * results : [{"id":"5f9c11e053866e0038e707a5","iso_639_1":"en","iso_3166_1":"US","key":"w1Ww62eIwOI","name":"Rogue City | Official Trailer | Netflix","site":"YouTube","size":1080,"type":"Trailer"}]
     */

    private int id;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Parcelable {
        /**
         * id : 5f9c11e053866e0038e707a5
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : w1Ww62eIwOI
         * name : Rogue City | Official Trailer | Netflix
         * site : YouTube
         * size : 1080
         * type : Trailer
         */

        private String id;
        private String iso_639_1;
        private String iso_3166_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.iso_639_1);
            dest.writeString(this.iso_3166_1);
            dest.writeString(this.key);
            dest.writeString(this.name);
            dest.writeString(this.site);
            dest.writeInt(this.size);
            dest.writeString(this.type);
        }

        public ResultsBean() {
        }

        protected ResultsBean(Parcel in) {
            this.id = in.readString();
            this.iso_639_1 = in.readString();
            this.iso_3166_1 = in.readString();
            this.key = in.readString();
            this.name = in.readString();
            this.site = in.readString();
            this.size = in.readInt();
            this.type = in.readString();
        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel source) {
                return new ResultsBean(source);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeList(this.results);
    }

    public MoviesViedo() {
    }

    protected MoviesViedo(Parcel in) {
        this.id = in.readInt();
        this.results = new ArrayList<ResultsBean>();
        in.readList(this.results, ResultsBean.class.getClassLoader());
    }

    public static final Creator<MoviesViedo> CREATOR = new Creator<MoviesViedo>() {
        @Override
        public MoviesViedo createFromParcel(Parcel source) {
            return new MoviesViedo(source);
        }

        @Override
        public MoviesViedo[] newArray(int size) {
            return new MoviesViedo[size];
        }
    };
}
