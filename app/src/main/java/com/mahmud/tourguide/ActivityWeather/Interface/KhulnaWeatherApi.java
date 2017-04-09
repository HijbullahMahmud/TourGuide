package com.mahmud.tourguide.ActivityWeather.Interface;

import com.mahmud.tourguide.ActivityWeather.Model.WeatherMain;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by imtiaj on 1/26/2017.
 */

public interface KhulnaWeatherApi {

    String url="v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"khulna%2C%20bangladesh\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    @GET(url)
    Call<WeatherMain> getWeatherData();


}
