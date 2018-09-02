package com.fehr.nanodegree.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Fehr on 14-Aug-17.
 */

public class SharmElShiekhFragment extends Fragment {

    AttractionAdapter mAdapter;

    public static SharmElShiekhFragment newInstance() {
        SharmElShiekhFragment fragment = new SharmElShiekhFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View list = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> items = new ArrayList<>();
        items.add(new Attraction(getString(R.string.sharm_place_1_name), getString(R.string.sharm_place_1_working_hours), getString(R.string.tab_sharm), R.drawable.sharm1, getString(R.string.sharm_place_1_location)));
        items.add(new Attraction(getString(R.string.sharm_place_2_name), getString(R.string.sharm_place_2_working_hours), getString(R.string.tab_sharm), R.drawable.sharm2, getString(R.string.sharm_place_2_location)));
        items.add(new Attraction(getString(R.string.sharm_place_3_name), getString(R.string.sharm_place_3_working_hours), getString(R.string.tab_sharm), R.drawable.sharm3, getString(R.string.sharm_place_3_location)));
        items.add(new Attraction(getString(R.string.sharm_place_4_name), getString(R.string.sharm_place_4_working_hours), getString(R.string.tab_sharm), R.drawable.sharm4, getString(R.string.sharm_place_4_location)));
        items.add(new Attraction(getString(R.string.sharm_place_5_name), getString(R.string.sharm_place_5_working_hours), getString(R.string.tab_sharm), R.drawable.sharm5, getString(R.string.sharm_place_5_location)));

        mAdapter = new AttractionAdapter(getActivity(), items);

        ListView listView = (ListView) list.findViewById(R.id.list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String uri = items.get(position).getLocation();
                Uri mapUri = Uri.parse(uri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(mapIntent);
            }
        });

        return list;
    }
}