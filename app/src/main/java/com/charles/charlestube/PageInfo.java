package com.charles.charlestube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PageInfo implements Serializable, Parcelable
{

    @SerializedName("totalResults")
    @Expose
    public long totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    public long resultsPerPage;
    public final static Parcelable.Creator<PageInfo> CREATOR = new Creator<PageInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PageInfo createFromParcel(Parcel in) {
            PageInfo instance = new PageInfo();
            instance.totalResults = ((long) in.readValue((long.class.getClassLoader())));
            instance.resultsPerPage = ((long) in.readValue((long.class.getClassLoader())));
            return instance;
        }

        public PageInfo[] newArray(int size) {
            return (new PageInfo[size]);
        }

    }
    ;

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public long getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(long resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalResults);
        dest.writeValue(resultsPerPage);
    }

    public int describeContents() {
        return  0;
    }

}
