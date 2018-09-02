package com.fehr.nanodegree.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentAttraction.getAttractionName());

        TextView workingHoursView = (TextView) listItemView.findViewById(R.id.working_hours);
        if ("".equals(currentAttraction.getAttractionWorkingHours()))
            workingHoursView.setVisibility(View.GONE);
        else {
            workingHoursView.setVisibility(View.VISIBLE);
            workingHoursView.setText(currentAttraction.getAttractionWorkingHours());
        }

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        addressTextView.setText(currentAttraction.getAttractionAddress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentAttraction.getImageResourceId());

        return listItemView;
    }
}
