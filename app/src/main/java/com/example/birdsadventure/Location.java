package com.example.birdsadventure;

import androidx.annotation.NonNull;

public class Location {

    private String locationName;

    /**
     * Constructors
     */

    Location(){

    }

    public Location(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Getters & Setters
     */

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Overwrite Methods
     */

    @NonNull
    @Override
    public String toString() {
        return locationName;
    }
}
