package com.example.mydatabase;

public class locationhelper {

    private double longitude;
    private  double latitude;
    String email,text;


    public locationhelper(double longitude, double latitude, String email) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.email = email;
       // this.text=text;
    }
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
