package com.example.birdsadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Media implements Parcelable {

    String  title;
    String url;
    String media_id;
    Boolean   is_image;
    Boolean   is_video;
    Boolean  is_sound_clip;
    Boolean   is_deleted;

    public Media()
    {
    }

    public Media(String title, String url, String media_id, Boolean is_image, Boolean is_video, Boolean is_sound_clip, Boolean is_deleted) {
        this.title = title;
        this.url = url;
        this.media_id = media_id;
        this.is_image = is_image;
        this.is_video = is_video;
        this.is_sound_clip = is_sound_clip;
        this.is_deleted = is_deleted;
    }


    public Media(String name, String imageURL) {
        this.title = name;
        this.url = imageURL;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Boolean getIs_image() {
        return is_image;
    }

    public void setIs_image(Boolean is_image) {
        this.is_image = is_image;
    }

    public Boolean getIs_video() {
        return is_video;
    }

    public void setIs_video(Boolean is_video) {
        this.is_video = is_video;
    }

    public Boolean getIs_sound_clip() {
        return is_sound_clip;
    }

    public void setIs_sound_clip(Boolean is_sound_clip) {
        this.is_sound_clip = is_sound_clip;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }


    protected Media(Parcel in) {
        media_id = in.readString();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media (in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(media_id);
        dest.writeString(title);
        dest.writeString(url);
    }
}
