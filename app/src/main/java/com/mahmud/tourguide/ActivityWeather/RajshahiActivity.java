package com.mahmud.tourguide.ActivityWeather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mahmud.tourguide.ActivityWeather.Interface.DhakaWeatherApi;
import com.mahmud.tourguide.R;

public class RajshahiActivity extends AppCompatActivity {

    DhakaWeatherApi dhakaWeatherApi;
    private TextView headingDhakaTV;
    private TextView timeHeadingTV;
    private  TextView weatherStateTV;
    private  TextView highTempTV;
    private  TextView lowTempTV;
    private  TextView currentTempTV;

    private TextView day1,day2,day3,day4,day5,day6,day7,day8,day9,day10;
    private TextView high1,high2,high3,high4,high5,high6,high7,high8,high9,high10;
    private TextView low1,low2,low3,low4,low5,low6,low7,low8,low9,low10;




    private TextView detail1,detail2,detail3,detail4;


    private TextView wind1,wind2;



    // private ListView listview;
    // private ArrayList<ForecastModel>forecastModels;
    // private Context context;
    //  DhakaAdapter dhakaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi);
    }
}
