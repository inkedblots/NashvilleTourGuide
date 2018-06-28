package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //Create a list of museums

        final ArrayList<Location> museums = new ArrayList<>();

        //museum.add(one);

        museums.add(new Location(getString(R.string.museumTitle), getString(R.string.museumAddress),
                getString(R.string.museumHours), getString(R.string.museumPrice),
                getString(R.string.museumDescription), R.drawable.johnnycashmuseum));

        museums.add(new Location(getString(R.string.museumTitle2), getString(R.string.museumAddress2),
                getString(R.string.museumHours2), getString(R.string.museumPrice2),
                getString(R.string.museumDescription2), R.drawable.frist));

        museums.add(new Location(getString(R.string.museumTitle3), getString(R.string.museumAddress3),
                getString(R.string.museumHours3), getString(R.string.museumPrice3),
                getString(R.string.museumDescription3), R.drawable.parthenonbyron));

        museums.add(new Location(getString(R.string.museumTitle4), getString(R.string.museumAddress4),
                getString(R.string.museumHours4), getString(R.string.museumPrice4),
                getString(R.string.museumDescription4), R.drawable.nashvilleskyline1280));


        // This list item layout contains a layout of location information, that includes
        // title, address, opening hours, description and photo of the location which the adapter will
        // set to display.
        LocationAdapter adapter = new LocationAdapter(getActivity(), museums);
        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activity}.
        // A {@Link ListView} with the view ID list is declared in the places_list.xml.
        ListView listView = rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} created above, so that the
        // {@link ListView} will display list items for each location in the list of places.
        // Call the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to select the museum when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Send intent to new {@Link LocationDetailActivity} with details for the current selected
                // museum.
                Intent intent;
                intent = new Intent(getActivity(), LocationDetailActivity.class);

                startActivity(intent);
            }
        });

        return rootView;
    }
}