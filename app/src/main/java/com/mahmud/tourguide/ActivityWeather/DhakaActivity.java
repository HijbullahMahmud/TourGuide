package com.mahmud.tourguide.ActivityWeather;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mahmud.tourguide.adapter.Imtiaz.DhakaAdapter;
import com.mahmud.tourguide.ActivityWeather.Interface.DhakaWeatherApi;
import com.mahmud.tourguide.ActivityWeather.Model.Forecast;
import com.mahmud.tourguide.ActivityWeather.Model.ForecastModel;
import com.mahmud.tourguide.ActivityWeather.Model.WeatherMain;
import com.mahmud.tourguide.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DhakaActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_dhaka);

        networkLibraryInitializer();
        getWeatherData();

        headingDhakaTV= (TextView) findViewById(R.id.dhakaTVId);
        timeHeadingTV= (TextView) findViewById(R.id.timeTVId);
        weatherStateTV= (TextView) findViewById(R.id.weatherStateTVId);
        highTempTV= (TextView) findViewById(R.id.highTempTVId);
        lowTempTV= (TextView) findViewById(R.id.lowTempTVId);
        currentTempTV= (TextView) findViewById(R.id.currentTempTVId);



        day1= (TextView) findViewById(R.id.dayname1);
        day2= (TextView) findViewById(R.id.dayname2);
        day3= (TextView) findViewById(R.id.dayname3);
        day4= (TextView) findViewById(R.id.dayname4);
        day5= (TextView) findViewById(R.id.dayname5);
        day6= (TextView) findViewById(R.id.dayname6);
        day7= (TextView) findViewById(R.id.dayname7);
        day8= (TextView) findViewById(R.id.dayname8);
        day9= (TextView) findViewById(R.id.dayname9);
   //     day10= (TextView) findViewById(R.id.dayname10);

        high1= (TextView) findViewById(R.id.high1);
        high2= (TextView) findViewById(R.id.high2);
        high3= (TextView) findViewById(R.id.high3);
        high4= (TextView) findViewById(R.id.high4);
        high5= (TextView) findViewById(R.id.high5);
        high6= (TextView) findViewById(R.id.high6);
        high7= (TextView) findViewById(R.id.high7);
        high8= (TextView) findViewById(R.id.high8);
        high9= (TextView) findViewById(R.id.high9);
     //   high10= (TextView) findViewById(R.id.high10);

        low1= (TextView) findViewById(R.id.low1);
        low2= (TextView) findViewById(R.id.low2);
        low3= (TextView) findViewById(R.id.low3);
        low4= (TextView) findViewById(R.id.low4);
        low5= (TextView) findViewById(R.id.low5);
        low6= (TextView) findViewById(R.id.low6);
        low7= (TextView) findViewById(R.id.low7);
        low8= (TextView) findViewById(R.id.low8);
        low9= (TextView) findViewById(R.id.low9);


        detail1= (TextView) findViewById(R.id.humidityValueId);
        detail2= (TextView) findViewById(R.id.pressureValueId);
        detail3= (TextView) findViewById(R.id.risingValueId);
        detail4= (TextView) findViewById(R.id.visibilityValueId);



        wind1= (TextView) findViewById(R.id.windId);
        wind2= (TextView) findViewById(R.id.directionId);
        //  low10= (TextView) findViewById(R.id.low10);

        // context=this;
       // forecastModels=new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.select_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuDhakaId:
                Intent intent = new Intent(this, DhakaActivity.class);
                startActivity(intent);
                break;
            case R.id.menuKhulnaId:
                Intent intent2 = new Intent(this, KhulnaActivity.class);
                startActivity(intent2);
                break;
            default:
                return false;
        }

        return true;
    }

    private void networkLibraryInitializer() {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        dhakaWeatherApi=retrofit.create(DhakaWeatherApi.class);




    }



    private void getWeatherData() {

        Call<WeatherMain>weatherMainCall=dhakaWeatherApi.getWeatherData();
        weatherMainCall.enqueue(new Callback<WeatherMain>() {
            @Override
            public void onResponse(Call<WeatherMain> call, Response<WeatherMain> response) {
                WeatherMain weatherMain=response.body();


                headingDhakaTV.setText(weatherMain.getQuery().getResults().getChannel().getLocation().getCity());

                String[] dateArray=weatherMain.getQuery().getResults().getChannel().getLastBuildDate().split(" ");
                String time=dateArray[4] +" "+dateArray[5] +" "+dateArray[6];
                timeHeadingTV.setText(time);

                weatherStateTV.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(0).getText());

                highTempTV.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(0).getHigh()+(char) 0x00B0 +"H");

                lowTempTV.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(0).getLow()+(char) 0x00B0 +"L");

                currentTempTV.setText(weatherMain.getQuery().getResults().getChannel().getItem().getCondition().getTemp()+(char) 0x00B0 + "F");



                 /*  for(int i=1;i<10;i++){

                       ForecastModel q;
                       q=new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(i).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(i).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(i).getLow().toString());

                       //forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(i).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(i).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(i).getLow().toString()));
                        forecastModels.add(q);

                   }*/

                       // if(cursor.moveToFirst()){


                //
                /*forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(1).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(1).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(1).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(2).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(2).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(2).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(3).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(3).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(3).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(4).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(4).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(4).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(5).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(5).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(5).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(6).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(6).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(6).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(7).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(7).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(7).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(8).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(8).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(8).getLow().toString()));
                forecastModels.add(new ForecastModel(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(9).getDay().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(9).getHigh().toString(),weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(9).getLow().toString()));
*/
//




//

              //  dhakaAdapter = new DhakaAdapter(context,R.layout.forecast_row,forecastModels);
                //DhakaAdapter dhakaAdapter = new DhakaAdapter(this,forecastModels);
              //  listview= (ListView) findViewById(R.id.forecastListViewId);



                //listview.setAdapter(dhakaAdapter);



                day1.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(1).getDay().toString());
                day2.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(2).getDay().toString());
                day3.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(3).getDay().toString());
                day4.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(4).getDay().toString());
                day5.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(5).getDay().toString());
                day6.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(6).getDay().toString());
                day7.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(7).getDay().toString());
                day8.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(8).getDay().toString());
                day9.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(9).getDay().toString());
               // day10.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(10).getDay().toString());

                high1.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(1).getHigh().toString() +(char) 0x00B0);
                high2.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(2).getHigh().toString() +(char) 0x00B0);
                high3.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(3).getHigh().toString() +(char) 0x00B0);
                high4.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(4).getHigh().toString() +(char) 0x00B0);
                high5.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(5).getHigh().toString() +(char) 0x00B0);
                high6.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(6).getHigh().toString() +(char) 0x00B0);
                high7.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(7).getHigh().toString() +(char) 0x00B0);
                high8.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(8).getHigh().toString() +(char) 0x00B0);
                high9.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(9).getHigh().toString() +(char) 0x00B0);


                low1.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(1).getLow().toString() +(char) 0x00B0);
                low2.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(2).getLow().toString() +(char) 0x00B0);
                low3.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(3).getLow().toString() +(char) 0x00B0);
                low4.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(4).getLow().toString()+(char) 0x00B0);
                low5.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(5).getLow().toString()+(char) 0x00B0);
                low6.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(6).getLow().toString()+(char) 0x00B0);
                low7.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(7).getLow().toString()+(char) 0x00B0);
                low8.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(8).getLow().toString()+(char) 0x00B0);
                low9.setText(weatherMain.getQuery().getResults().getChannel().getItem().getForecast().get(9).getLow().toString()+(char) 0x00B0);


                detail1.setText(weatherMain.getQuery().getResults().getChannel().getAtmosphere().getHumidity()+ " %");
                detail2.setText(weatherMain.getQuery().getResults().getChannel().getAtmosphere().getPressure()+" in");
                detail3.setText(weatherMain.getQuery().getResults().getChannel().getAtmosphere().getRising());
                detail4.setText(weatherMain.getQuery().getResults().getChannel().getAtmosphere().getVisibility()+ " km");


                wind1.setText(weatherMain.getQuery().getResults().getChannel().getWind().getSpeed().toString()+ " mph");
                wind2.setText(weatherMain.getQuery().getResults().getChannel().getWind().getDirection().toString() + " mph");



            }

            @Override
            public void onFailure(Call<WeatherMain> call, Throwable t) {

            }
        });



    }







}

