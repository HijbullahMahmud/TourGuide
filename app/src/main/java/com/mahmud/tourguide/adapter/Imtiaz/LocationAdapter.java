package com.mahmud.tourguide.adapter.Imtiaz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.mahmud.tourguide.Nearby.NearByPlaces;
import com.mahmud.tourguide.R;
import com.mahmud.tourguide.Nearby.Result;

/**
 * Created by RAHAT on 2/13/2017.
 */

public class LocationAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> nameList;
    NearByPlaces nearbyPlaces;
    public LocationAdapter(Context context, ArrayList<String> nameList) {
        super(context, R.layout.custom_places_list, nameList);
        this.nameList=nameList;
        this.context=context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       // String res=nameList.get(position);
         List<Result> result = (List<Result>) nearbyPlaces.getResults().get(position);



        convertView= LayoutInflater.from(context).inflate(R.layout.custom_places_list,parent,false);

        TextView eventName= (TextView) convertView.findViewById(R.id.places_nameTV);
        TextView fromDate= (TextView) convertView.findViewById(R.id.places_ratingTV);

     /*   for (Result results:result) {
            eventName.setText(results.getName());
            fromDate.setText(results.getRating().toString());
        }*/



        return convertView;


    }
}
