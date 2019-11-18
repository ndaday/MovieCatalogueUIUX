package com.dday.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private String titleTvShow;
    private String releaseTvShow;
    private String ratingTvShow;
    private String overviewTvShow;
    private int poster;

    public TvShow() {

    }

    protected TvShow(Parcel in) {
        titleTvShow = in.readString();
        releaseTvShow = in.readString();
        ratingTvShow = in.readString();
        overviewTvShow = in.readString();
        poster = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleTvShow);
        dest.writeString(releaseTvShow);
        dest.writeString(ratingTvShow);
        dest.writeString(overviewTvShow);
        dest.writeInt(poster);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public String getTitleTvShow() {
        return titleTvShow;
    }

    public void setTitleTvShow(String titleTvShow) {
        this.titleTvShow = titleTvShow;
    }

    public String getReleaseTvShow() {
        return releaseTvShow;
    }

    public void setReleaseTvShow(String releaseTvShow) {
        this.releaseTvShow = releaseTvShow;
    }

    public String getRatingTvShow() {
        return ratingTvShow;
    }

    public void setRatingTvShow(String ratingTvShow) {
        this.ratingTvShow = ratingTvShow;
    }

    public String getOverviewTvShow() {
        return overviewTvShow;
    }

    public void setOverviewTvShow(String overviewTvShow) {
        this.overviewTvShow = overviewTvShow;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
