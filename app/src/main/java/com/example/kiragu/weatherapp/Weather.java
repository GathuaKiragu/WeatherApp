package com.example.kiragu.weatherapp;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/12/17.
 */
public class Weather {
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList description;

    public Weather(String name, double latitude, double longitude, ArrayList description ){
        this.name= name;
        this.latitude=latitude;
        this.longitude=longitude;
        this.description=description;
    }

    public String getName(){
        return name;
    }
    public double getLatitude(){
        return latitude;
    }
    public double getLongitude(){
        return longitude;
    }
    public  ArrayList getDescription(){
        return description;
    }
}
