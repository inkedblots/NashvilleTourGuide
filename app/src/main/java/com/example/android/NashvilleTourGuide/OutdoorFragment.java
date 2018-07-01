package com.example.android.NashvilleTourGuide;


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
public class OutdoorFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //Create a list of outdoor

        final ArrayList<Location> locations = new ArrayList<>();

        //locations.add("one);

        locations.add(new Location(getString(R.string.outdoorTitle), getString(R.string.outdoorAddress),
                getString(R.string.outdoorHours), getString(R.string.outdoorPrice),
                getString(R.string.outdoorDescription), R.drawable.cheekwood));

        locations.add(new Location(getString(R.string.outdoorTitle2), getString(R.string.outdoorAddress2),
                getString(R.string.outdoorHours2), getString(R.string.outdoorPrice2),
                getString(R.string.outdoorDescription2), R.drawable.zoo));

        locations.add(new Location(getString(R.string.outdoorTitle3), getString(R.string.outdoorAddress3),
                getString(R.string.outdoorHours3), getString(R.string.outdoorPrice3),
                getString(R.string.outdoorDescription3), R.drawable.jackson));

        locations.add(new Location(getString(R.string.outdoorTitle4), getString(R.string.outdoorAddress4),
                getString(R.string.outdoorHours4), getString(R.string.outdoorPrice4),
                getString(R.string.outdoorDescription4), R.drawable.bicentennial));

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

        // Set a click listener to select the outdoor location when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Send intent to new {@Link LocationDetailActivity} with details for the current selected
                // outdoor location.
                Intent intent;
                intent = new Intent(getActivity(), LocationDetailActivity.class);

                startActivity(intent);
            }
        });

        return rootView;
    }
}
