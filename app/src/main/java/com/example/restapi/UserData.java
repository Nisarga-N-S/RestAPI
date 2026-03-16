package com.example.restapi;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserData implements Serializable {

    @SerializedName("body")
    private String body;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("userId")
    private int userId;


    public String getBody() {
        return body;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//
//
//    @Override
//    public void writeToParcel(@NonNull Parcel dest, int flags) {
//        dest.writeInt(id);
//        dest.writeString(title);
//        dest.writeString(body);
//
//    }
//
//    public static final Creator<UserData> CREATOR= new Creator<UserData>() {
//        @Override
//        public UserData createFromParcel(Parcel source) {
//            return new UserData(source);
//        }
//
//        @Override
//        public UserData[] newArray(int size) {
//            return new UserData[size];
//        }
//    };
//    protected UserData(Parcel source){
//        id= source.readInt();
//        title=source.readString();
//        body=source.readString();
//    }
}

