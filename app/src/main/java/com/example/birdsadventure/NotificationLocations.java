package com.example.birdsadventure;

public class NotificationLocations {
    private String locationID;
    private String region;
    private String latitude;
    private String longitude;
    private String city;
    private String proximityRadius;
    private boolean isFeatured;
    private boolean isFavorite;

    public NotificationLocations(String region, String latitude, String longitude, String proximityRadius) {
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
        this.proximityRadius = proximityRadius;
    }

    NotificationLocations() {
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProximityRadius() {
        return proximityRadius;
    }

    public void setProximityRadius(String proximityRadius) {
        this.proximityRadius = proximityRadius;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
