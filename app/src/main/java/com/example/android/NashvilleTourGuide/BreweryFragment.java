package com.example.android.NashvilleTourGuide;

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


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

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

                String breweryTitle = locations.get(position).getTitle();
                intent.putExtra("title", breweryTitle);
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