package com.example.android.popular_movies_master;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chinky on 7/5/2016.
 */
public class MovieTrailersParcel implements Parcelable {

    public String source;
    public MovieTrailersParcel(String source)
    {
        this.source = source;
    }

    private MovieTrailersParcel(Parcel in){
        source = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString() { return source; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(source);
    }

    public final Creator<MovieTrailersParcel> CREATOR = new Creator<MovieTrailersParcel>() {
        @Override
        public MovieTrailersParcel createFromParcel(Parcel parcel) {
            return new MovieTrailersParcel(parcel);
        }

        @Override
        public MovieTrailersParcel[] newArray(int i) {
            return new MovieTrailersParcel[i];
        }

    };
}
