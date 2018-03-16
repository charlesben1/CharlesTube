package com.charles.charlestube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Medium implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    public String url;
    public final static Parcelable.Creator<Medium> CREATOR = new Creator<Medium>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Medium createFromParcel(Parcel in) {
            Medium instance = new Medium();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Medium[] newArray(int size) {
            return (new Medium[size]);
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
