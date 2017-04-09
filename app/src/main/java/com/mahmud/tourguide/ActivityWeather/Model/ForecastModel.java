package com.mahmud.tourguide.ActivityWeather.Model;

/**
 * Created by imtiaj on 1/25/2017.
 */

public class ForecastModel {
    private String day;
    private String highTemp;
    private String lowTemp;

    public ForecastModel(String day, String highTemp, String lowTemp) {
        this.day = day;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
    }

    public String getDay() {
        return day;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }
}
