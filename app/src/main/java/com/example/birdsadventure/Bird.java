package com.example.birdsadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Bird  implements Parcelable {
    private String birdID;
    private String name;
    private String imageURL;

    public Bird(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    protected Bird(Parcel in) {
        birdID = in.readString();
        name = in.readString();
        imageURL = in.readString();
    }

    public static final Creator<Bird> CREATOR = new Creator<Bird>() {
        @Override
        public Bird createFromParcel(Parcel in) {
            return new Bird(in);
        }

        @Override
        public Bird[] newArray(int size) {
            return new Bird[size];
        }
    };

    public String getBirdID() {
        return birdID;
    }

    public void setBirdID(String birdID) {
        this.birdID = birdID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(birdID);
        dest.writeString(name);
        dest.writeString(imageURL);
    }
}
