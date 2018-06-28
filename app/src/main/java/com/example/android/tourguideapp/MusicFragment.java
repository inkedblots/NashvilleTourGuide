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
public class MusicFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //Create a list of music

        final ArrayList<Location> locations = new ArrayList<>();

        //locations.add("one);

        locations.add(new Location(getString(R.string.musicTitle), getString(R.string.musicAddress),
                getString(R.string.musicHours), getString(R.string.musicPrice),
                getString(R.string.musicDescription), R.drawable.tootsies));

        locations.add(new Location(getString(R.string.musicTitle2), getString(R.string.musicAddress2),
                getString(R.string.musicHours2), getString(R.string.musicPrice2),
                getString(R.string.musicDescription2), R.drawable.ryman));

        locations.add(new Location(getString(R.string.musicTitle3), getString(R.string.musicAddress3),
                getString(R.string.musicHours3), getString(R.string.musicPrice3),
                getString(R.string.musicDescription3), R.drawable.wildhors));

        locations.add(new Location(getString(R.string.musicTitle4), getString(R.string.musicAddress4),
                getString(R.string.musicHours4), getString(R.string.musicPrice4),
                getString(R.string.musicDescription4), R.drawable.walkoffame));

        // This list item layout contains a layout of location information, that includes
        // title, address, opening hours, description and photo of the location which the adapter will
        // set to display.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activity}.
        // A {@Link ListView} with the view ID called list is declared in the places_list.xml.
        ListView listView = rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} created above, so that the
        // {@link ListView} will display list items for each location in the list of places.
        // Call the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to select the music when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Send intent to new {@Link LocationDetailActivity} with details for the current selected
                // music.
                Intent intent = new Intent(getActivity(), LocationDetailActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
    }


}
