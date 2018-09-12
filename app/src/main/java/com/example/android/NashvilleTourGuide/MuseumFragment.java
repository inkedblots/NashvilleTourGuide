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
public class MuseumFragment extends Fragment {

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

        //Create a list of museums
        final ArrayList<Location> locations = new ArrayList<>();

        //museums.add(one);
        locations.add(new Location(getString(R.string.museumTitle), getString(R.string.museumAddress),
                getString(R.string.museumHours), getString(R.string.museumPrice),
                getString(R.string.museumDescription), R.drawable.johnnycashmuseum));

        locations.add(new Location(getString(R.string.museumTitle2), getString(R.string.museumAddress2),
                getString(R.string.museumHours2), getString(R.string.museumPrice2),
                getString(R.string.museumDescription2), R.drawable.frist));

        locations.add(new Location(getString(R.string.museumTitle3), getString(R.string.museumAddress3),
                getString(R.string.museumHours3), getString(R.string.museumPrice3),
                getString(R.string.museumDescription3), R.drawable.parthenonbyron));

        locations.add(new Location(getString(R.string.museumTitle4), getString(R.string.museumAddress4),
                getString(R.string.museumHours4), getString(R.string.museumPrice4),
                getString(R.string.museumDescription4), R.drawable.tnrailway));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to select the museum when the card is clicked on.
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

                String museumTitle = locations.get(position).getTitle();
                intent.putExtra("title", museumTitle);
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