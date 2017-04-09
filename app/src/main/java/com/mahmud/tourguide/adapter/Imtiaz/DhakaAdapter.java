package com.mahmud.tourguide.adapter.Imtiaz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mahmud.tourguide.ActivityWeather.Model.ForecastModel;
import com.mahmud.tourguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imtiaj on 1/25/2017.
 */

public class DhakaAdapter extends ArrayAdapter<ForecastModel> {

    ArrayList<ForecastModel>forecastModels;
    Context context;



    public DhakaAdapter(Context context, int resource, ArrayList<ForecastModel> forecastModels) {
        super(context, R.layout.forecast_row, forecastModels);
        this.context=context;
        //this.forecastModels=forecastModels;
        this.forecastModels=forecastModels;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ForecastModel forecastModelQ=forecastModels.get(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.forecast_row,parent,false);
        TextView dayName= (TextView) convertView.findViewById(R.id.dayNameId);
        TextView highName= (TextView) convertView.findViewById(R.id.rowHighTempId);
        TextView lowName= (TextView) convertView.findViewById(R.id.rowLowTempId);

        dayName.setText(forecastModelQ.getDay());
        highName.setText(forecastModelQ.getHighTemp() +(char) 0x00B0);
        lowName.setText(forecastModelQ.getLowTemp()+(char) 0x00B0);


        return convertView;
    }
}
/*public class CustomAdapter extends ArrayAdapter<ModelClass> {
    ArrayList<ModelClass>modelclass;
    Context context;

    public CustomAdapter(Context context, int resource, List<ModelClass> objects) {
        super(context, R.layout.custom_xml, objects);
        this.context=context;
        this.modelclass=modelclass;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ModelClass model = modelclass.get(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.custom_xml,parent,false);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameTV);
        TextView deptText = (TextView) convertView.findViewById(R.id.deptTV);
        TextView sessionText = (TextView) convertView.findViewById(R.id.sessionTV);

        nameText.setText(model.getName());
        deptText.setText(model.getDept());
        sessionText.setText(model.getBatch());


        return convertView;
    }
}

*/