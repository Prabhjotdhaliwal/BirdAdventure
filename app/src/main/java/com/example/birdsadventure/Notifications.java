package com.example.birdsadventure;

import java.util.Date;

public class Notifications {

    String notificationID;
    Date dateReceived;
    String region;
    String locationID;
    boolean isDeleted;

    /**
     * here user get notification  by turn on button fron settings
     * then according to te Radius Proximity user get notification about birds
     * By Region and locationId
     */


    public Notifications() {
    }

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
