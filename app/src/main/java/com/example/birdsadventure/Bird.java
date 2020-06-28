package com.example.birdsadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Bird implements Parcelable {
    private String birdID;
    private String name;
    private String imageURL;
    private String biome;
    private String color;
    private String description;
    private String diet;
    private String habitat;
    private String height;
    private String region;
    private String city;
    private String weight;
    private boolean isFavorite;

    public Bird(String birdID, String name, String imageURL)

    {
        this.birdID = birdID;
        this.name = name;
        this.imageURL = imageURL;
    }

    public Bird(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public Bird(String birdID, String name, String imageURL, String biome, String color, String description, String diet, String habitat, String height, String region, String city, String weight) {
        this.birdID = birdID;
        this.name = name;
        this.imageURL = imageURL;
        this.biome = biome;
        this.color = color;
        this.description = description;
        this.diet = diet;
        this.habitat = habitat;
        this.height = height;
        this.region = region;
        this.city = city;
        this.weight = weight;
    }

    protected Bird(Parcel in) {
        birdID = in.readString();
        name = in.readString();
        imageURL = in.readString();
    }

    public static final Creator<Bird> CREATOR = new Creator<Bird>() {
        @Override
        public Bird createFromParcel(Parcel in)
        {
            return new Bird(in);
        }

        @Override
        public Bird[] newArray(int size)
        {
            return new Bird[size];
        }
    };

    public Bird() {

    }

    /**
     * Getters and Setters
     */

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

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
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
