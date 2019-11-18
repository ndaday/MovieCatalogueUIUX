package com.dday.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String titleMovie;
    private String releaseMovie;
    private String ratingMovie;
    private String overviewMovie;
    private int poster;

    protected Movie(Parcel in) {
        titleMovie = in.readString();
        releaseMovie = in.readString();
        ratingMovie = in.readString();
        overviewMovie = in.readString();
        poster = in.readInt();
    }

    public Movie() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleMovie);
        dest.writeString(releaseMovie);
        dest.writeString(ratingMovie);
        dest.writeString(overviewMovie);
        dest.writeInt(poster);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getReleaseMovie() {
        return releaseMovie;
    }

    public void setReleaseMovie(String releaseMovie) {
        this.releaseMovie = releaseMovie;
    }

    public String getRatingMovie() {
        return ratingMovie;
    }

    public void setRatingMovie(String ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    public String getOverviewMovie() {
        return overviewMovie;
    }

    public void setOverviewMovie(String overviewMovie) {
        this.overviewMovie = overviewMovie;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
