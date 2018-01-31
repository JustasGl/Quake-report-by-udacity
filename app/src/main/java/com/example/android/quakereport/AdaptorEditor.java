package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AdaptorEditor extends ArrayAdapter<word> {

    private static final String LOCATION_SEPARATOR = " of ";

    public AdaptorEditor(Context context, ArrayList<word> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        word vertimas = getItem(position);


        String stipris;

        TextView mag = (TextView) listItemView.findViewById(R.id.mag);
        stipris = formatMagnitude(vertimas.getMag());

        String orginalivietove = vertimas.getCity();

        String vieta;
        String nuotolis;

        if (orginalivietove.contains(LOCATION_SEPARATOR)) {
            String[] parts = orginalivietove.split(LOCATION_SEPARATOR);
            vieta = parts[0] + LOCATION_SEPARATOR;
            nuotolis = parts[1];
        }
            else
                {
                nuotolis=orginalivietove;
                    vieta = "Near the";
        }
        TextView city = (TextView) listItemView.findViewById(R.id.atstumas);
        city.setText(vieta);
        Date dateObject = new Date(vertimas.getDate());

        TextView nuotoliss = (TextView)listItemView.findViewById(R.id.city);
        nuotoliss.setText(nuotolis);

        String dateToDisplay = formatDate(dateObject);

        TextView date = (TextView)listItemView.findViewById(R.id.data);
        date.setText(dateToDisplay);

        String formattedTime = formatTime(dateObject);
        TextView time = (TextView)listItemView.findViewById(R.id.time);
        time.setText(formattedTime);

        mag.setText(stipris);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.

        // Get the appropriate background color based on the current earthquake magnitude
        double magnitude = vertimas.getMag();
        int magnitudeColor = getMagnitudeColor((int) Math.floor(magnitude));
        // Set the color on the magnitude circle

        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
            return timeFormat.format(dateObject);
        }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor (int dydis)
    {
        int mgcolor;
        Log.i("Dydis lygus", String.valueOf(dydis));
            switch (dydis)
            {
                case 0:
                case 1:
                mgcolor=R.color.magnitude1;
                    break;
                case 2:
                    mgcolor=R.color.magnitude2;
                    break;
                case 3:
                    mgcolor=R.color.magnitude3;
                    break;
                case 4:
                    mgcolor=R.color.magnitude4;
                    break;
                case 5:
                    mgcolor=R.color.magnitude5;
                    break;
                case 6:
                    mgcolor=R.color.magnitude6;
                    break;
                case 7:
                    mgcolor=R.color.magnitude7;
                    break;
                case 8:
                    mgcolor=R.color.magnitude8;
                    break;
                case 9:
                    mgcolor=R.color.magnitude9;
                    break;
                default:
                    mgcolor=R.color.magnitude10plus;
                    break;
            }
            return  ContextCompat.getColor(getContext(), mgcolor);
    }
}