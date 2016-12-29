package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.android.quakereport.R.id.place;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView distanceView = (TextView) listItemView.findViewById(R.id.distance);
        TextView placeView = (TextView) listItemView.findViewById(place);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeView.setText(formatter.format(currentEarthquake.getMagnitude()));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String place = currentEarthquake.getPlace();
        String[] splitPlace = place.split(LOCATION_SEPARATOR, 2);
        if(splitPlace.length > 1) {
            distanceView.setText(place.split("of ", 2)[0] + "of");
            placeView.setText(place.split("of ", 2)[1]);
        } else {
            distanceView.setText("Near the");
            placeView.setText(place);
        }

        Date date = new Date(currentEarthquake.getDate());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(date);
        dateView.setText(dateToDisplay);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        switch ((int)magnitude) {
            case 0 : return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 1 : return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2 : return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3 : return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4 : return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5 : return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6 : return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7 : return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8 : return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9 : return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default: return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
    }
    }
}
