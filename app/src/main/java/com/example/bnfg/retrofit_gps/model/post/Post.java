package com.example.bnfg.retrofit_gps.model.post;

/**
 * Created by BNFG on 22/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("lieu")
    @Expose
    private String lieu;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("etat")
    @Expose
    private String etat;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    @Override
    public String toString() {
        return "Post{" +
                "lieu='" + lieu + '\'' +
                ", distance='" + distance + '\'' +
                ", etat=" + etat +
                '}';
    }

}
