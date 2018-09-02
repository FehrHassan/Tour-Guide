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

public class AlexandriaFragment extends Fragment {

    AttractionAdapter mAdapter;

    public static AlexandriaFragment newInstance() {
        AlexandriaFragment fragment = new AlexandriaFragment();
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
        ListView listView = (ListView) list.findViewById(R.id.list);
        items.add(new Attraction(getString(R.string.alex_place_1_name), getString(R.string.alex_place_1_working_hours), getString(R.string.tab_alexandria), R.drawable.alex1, getString(R.string.alex_place_1_location)));
        items.add(new Attraction(getString(R.string.alex_place_2_name), getString(R.string.alex_place_2_working_hours), getString(R.string.tab_alexandria), R.drawable.alex2, getString(R.string.alex_place_2_location)));
        items.add(new Attraction(getString(R.string.alex_place_3_name), getString(R.string.alex_place_3_working_hours), getString(R.string.tab_alexandria), R.drawable.alex3, getString(R.string.alex_place_3_location)));
        items.add(new Attraction(getString(R.string.alex_place_4_name), getString(R.string.alex_place_4_working_hours), getString(R.string.tab_alexandria), R.drawable.alex4, getString(R.string.alex_place_4_location)));
        items.add(new Attraction(getString(R.string.alex_place_5_name), getString(R.string.alex_place_5_working_hours), getString(R.string.tab_alexandria), R.drawable.alex5, getString(R.string.alex_place_5_location)));
        mAdapter = new AttractionAdapter(getActivity(), items);
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