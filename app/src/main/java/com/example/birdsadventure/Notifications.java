package com.example.birdsadventure;

public class Notifications {
    int image;
    String Description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Notifications(int image, String Description)
    {
this.image=image;
this.Description=Description;

    }


}
