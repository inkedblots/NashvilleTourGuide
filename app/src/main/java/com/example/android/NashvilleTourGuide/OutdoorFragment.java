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

    String title;
    String address;
    String businessHours;
    String entrancePrice;
    String description;
    int imageResourceId;


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
                getString(R.string.outdoorDescription2), R.drawable.nashvillezoo));

        locations.add(new Location(getString(R.string.outdoorTitle3), getString(R.string.outdoorAddress3),
                getString(R.string.outdoorHours3), getString(R.string.outdoorPrice3),
                getString(R.string.outdoorDescription3), R.drawable.jackson));

        locations.add(new Location(getString(R.string.outdoorTitle4), getString(R.string.outdoorAddress4),
                getString(R.string.outdoorHours4), getString(R.string.outdoorPrice4),
                getString(R.string.outdoorDescription4), R.drawable.bicentennial));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to select the outdoor location when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location currentSelection = locations.get(position); //Creates a unique identifier for the item you selected
                title = currentSelection.getTitle();
                address = currentSelection.getAddress();
                businessHours = currentSelection.getBusinessHours();
                entrancePrice = currentSelection.getPrice();
                description = currentSelection.getDescription();
                imageResourceId = currentSelection.getImageResourceId();

                Intent intent = new Intent(view.getContext(), LocationDetailActivity.class);

                String musicTitle = locations.get(position).getTitle();
                intent.putExtra("title", musicTitle);
                intent.putExtra("address", address);
                intent.putExtra("hours", businessHours);
                intent.putExtra("price", entrancePrice);
                intent.putExtra("description", description);
                intent.putExtra("image", imageResourceId);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
