package com.example.mydatabase;

public class member {

    public String phone;
    public String email;
    public String name;
    public String pass;
    public double longitude;
    public double latitude;
    public String dpt, tme, loc, mail, id;

    public member(String name, String phone, String email, String pass){

        this.email = email;
        this.phone=phone;
        this.name=name;
        this.pass=pass;
    }

   /* public member(double longitude, double latitude, String email) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.email = email;
        // this.text=text;
    }*/

   /* public member(String dpt, String loc, String tme,String mail) {
        this.dpt = dpt;
        this.loc=loc;
        this.tme=tme;
        this.mail=mail;
    }*/

    public member(String dpt, String loc, String tme, String mail,String id) {
        this.dpt = dpt;
        this.loc=loc;
        this.tme=tme;
        this.mail=mail;
        this.id=id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*/

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