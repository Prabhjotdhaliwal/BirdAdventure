package com.example.birdsadventure;

public class media {

    String  title;
    String url;
    int media_id;
    Boolean   is_image;
    Boolean   is_video;


    Boolean  is_sound_clip;
    Boolean   is_deleted;

    public media()
    {
    }

    public media(String title, String url, int media_id, Boolean is_image, Boolean is_video, Boolean is_sound_clip, Boolean is_deleted) {
        this.title = title;
        this.url = url;
        this.media_id = media_id;
        this.is_image = is_image;
        this.is_video = is_video;
        this.is_sound_clip = is_sound_clip;
        this.is_deleted = is_deleted;
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

    public int getMedia_id() {
        return media_id;
    }

    public void setMedia_id(int media_id) {
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
}
