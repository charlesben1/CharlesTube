package com.charles.charlestube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class High implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    public String url;
    public final static Parcelable.Creator<High> CREATOR = new Creator<High>() {


        @SuppressWarnings({
            "unchecked"
        })
        public High createFromParcel(Parcel in) {
            High instance = new High();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public High[] newArray(int size) {
            return (new High[size]);
        }

    }
    ;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
