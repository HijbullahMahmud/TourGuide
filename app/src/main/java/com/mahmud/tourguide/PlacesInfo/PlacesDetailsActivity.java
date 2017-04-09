package com.mahmud.tourguide.PlacesInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmud.tourguide.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlacesDetailsActivity extends AppCompatActivity {
    PlacesDeatilsApi placesDeatilsApi;
    TextView addText,ratingText,reviewText,phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_details);
        addText= (TextView) findViewById(R.id.placesDetailsAddressTV);
        ratingText= (TextView) findViewById(R.id.placesDetailsRatingTV);
        reviewText= (TextView) findViewById(R.id.placesDetailsPhoneNoTV);
        phoneText= (TextView) findViewById(R.id.placesDetailsReviewTV);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/place/details/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        placesDeatilsApi=retrofit.create(PlacesDeatilsApi.class);
        getAllInfo();
        
    }

    private void getAllInfo() {
        String dynamicUrl="json?placeid=";
        String duna="&key=AIzaSyBSYRY4n7_t-Sciazql9IUZ-UYzcPpshh4";
        String id2=getIntent().getStringExtra("PlacesId");

        String finalurl=dynamicUrl+id2+duna;


        Call<PlacesDeatils>placesDetails=placesDeatilsApi.getAllInfo(finalurl);
        placesDetails.enqueue(new Callback<PlacesDeatils>() {
            @Override
            public void onResponse(Call<PlacesDeatils> call, Response<PlacesDeatils> response) {
                PlacesDeatils placesDetails=response.body();
                addText.setText(placesDetails.getResult().getName());
                ratingText.setText(placesDetails.getResult().getRating().toString());
                reviewText.setText(placesDetails.getResult().getName());
                phoneText.setText(placesDetails.getResult().getFormattedPhoneNumber());
            }

            @Override
            public void onFailure(Call<PlacesDeatils> call, Throwable t) {

            }
        });

    }
}
