package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreweryFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //Create a list of brewery

        final ArrayList<Location> locations = new ArrayList<>();

        //locations.add("one");

        locations.add(new Location(getString(R.string.breweryTitle), getString(R.string.breweryAddress),
                getString(R.string.breweryHours), getString(R.string.breweryPrice),
                getString(R.string.breweryDescription), R.drawable.yazoo));

        locations.add(new Location(getString(R.string.breweryTitle2), getString(R.string.breweryAddress2),
                getString(R.string.breweryHours2), getString(R.string.breweryPrice2),
                getString(R.string.breweryDescription2), R.drawable.tnbrewworks));

        locations.add(new Location(getString(R.string.breweryTitle3), getString(R.string.breweryAddress3),
                getString(R.string.breweryHours3), getString(R.string.breweryPrice3),
                getString(R.string.breweryDescription3), R.drawable.blackstonepic));

        locations.add(new Location(getString(R.string.breweryTitle4), getString(R.string.breweryAddress4),
                getString(R.string.breweryHours4), getString(R.string.breweryPrice4),
                getString(R.string.breweryDescription4), R.drawable.czanns));

        // This list item layout contains a layout of location information, that includes
        // title, address, opening hours, description and photo of the location which the adapter will
        // set to display.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activity}.
        // A {@Link ListView} with the view ID list is declared in the places_list.xml.
        ListView listView = rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} created above, so that the
        // {@link ListView} will display list items for each location in the list of places.
        // Call the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to select the brewery when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Send intent to new {@Link LocationDetailActivity} with details for the current selected
                // brewery.
                Intent intent;
                intent = new Intent(getActivity(), LocationDetailActivity.class);

                startActivity(intent);
            }
        });

        return rootView;
    }
}