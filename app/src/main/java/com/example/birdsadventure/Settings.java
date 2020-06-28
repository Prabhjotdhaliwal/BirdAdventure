package com.example.birdsadventure;

public class Settings {
    boolean get_favorites_notifications;
    boolean get_featured_notifications;

    public Settings(boolean get_favorites_notifications, boolean get_featured_notifications) {
        this.get_favorites_notifications = get_favorites_notifications;
        this.get_featured_notifications = get_featured_notifications;
    }

    public boolean isGet_favorites_notifications() {
        return get_favorites_notifications;
    }

    public void setGet_favorites_notifications(boolean get_favorites_notifications) {
        this.get_favorites_notifications = get_favorites_notifications;
    }

    public boolean isGet_featured_notifications() {
        return get_featured_notifications;
    }

    public void setGet_featured_notifications(boolean get_featured_notifications) {
        this.get_featured_notifications = get_featured_notifications;
    }
}
