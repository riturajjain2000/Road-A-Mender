package com.sih.potholeapp;

public class LocationHelper {
    private Double Longitude;
    private  Double Latitude;

    public LocationHelper(Double longitude, Double latitude) {
        Longitude = longitude;
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }
}
