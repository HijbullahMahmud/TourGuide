package com.mahmud.tourguide.Nearby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.mahmud.tourguide.R;
import com.mahmud.tourguide.adapter.Imtiaz.LocationAdapter;
import com.mahmud.tourguide.PlacesInfo.PlacesDetailsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView placesLV;
    NearbyPlacesApi nearbyPlacesApi;
    String placesId;
    List<Result>results;
    String dynamicUrl;
    ArrayList<String>nameList;
    LocationAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placesLV= (ListView) findViewById(R.id.placesLV);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        nearbyPlacesApi=retrofit.create(NearbyPlacesApi.class);
        getAllData();
    }

    private void getAllData() {
        //String dynamicUrl="json?location=-33.8670,151.1957&radius=500&types=food|cafe&key=AIzaSyBSYRY4n7_t-Sciazql9IUZ-UYzcPpshh4";
        String a = "json?location=-33.8670,151.1957&radius=500&types=food&name=cruise";
        String b="&key=AIzaSyAT8rP8UYXbhzwYMtbI3y6KVv6rP3kVPiw";
        String d = getIntent().getStringExtra("ATM");
        if(getIntent().hasExtra("Food")){
            String c=getIntent().getStringExtra("Food");
            dynamicUrl=a+c+b;
        }
        else if(getIntent().hasExtra("Hospital")){
            String c=getIntent().getStringExtra("Hospital");
            dynamicUrl=a+c+b;
        }
        else{
            dynamicUrl=a+d+b;
        }

      //  String dynamicUrl=a+d+b;

        Call<NearByPlaces>nearByPlacesCall=nearbyPlacesApi.getAllNearByPlaces(dynamicUrl);
        nearByPlacesCall.enqueue(new Callback<NearByPlaces>() {
            @Override
            public void onResponse(Call<NearByPlaces> call, Response<NearByPlaces> response) {
                NearByPlaces nearByPlaces=response.body();
                results=nearByPlaces.getResults();
                nameList =new ArrayList<String>();


           /*     for(Result result:results){
                    nameList.add(result.getName());

                }*/
                // ArrayAdapter<String>nameAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,nameList);
                locationAdapter=new LocationAdapter(MainActivity.this,nameList);
                placesLV.setAdapter(locationAdapter);

                placesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        placesId=results.get(position).getPlaceId();

                        Intent intent = new Intent(MainActivity.this,PlacesDetailsActivity.class);
                        intent.putExtra("PlacesId",placesId);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<NearByPlaces> call, Throwable t) {

            }
        });
    }
}
