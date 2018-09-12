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
public class FoodFragment extends Fragment {

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

        //Create a list of eateries

        final ArrayList<Location> locations = new ArrayList<>();

        //locations.add("one");

        locations.add(new Location(getString(R.string.foodTitle), getString(R.string.foodAddress),
                getString(R.string.foodHours), getString(R.string.foodPrice),
                getString(R.string.foodDescription), R.drawable.pancakepantry));

        locations.add(new Location(getString(R.string.foodTitle2), getString(R.string.foodAddress2),
                getString(R.string.foodHours2), getString(R.string.foodPrice2),
                getString(R.string.foodDescription2), R.drawable.loveless));

        locations.add(new Location(getString(R.string.foodTitle3), getString(R.string.foodAddress3),
                getString(R.string.foodHours3), getString(R.string.foodPrice3),
                getString(R.string.foodDescription3), R.drawable.fido6));

        locations.add(new Location(getString(R.string.foodTitle4), getString(R.string.foodAddress4),
                getString(R.string.foodHours4), getString(R.string.foodPrice4),
                getString(R.string.foodDescription4), R.drawable.sambuca));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to select the food when the card is clicked on.
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
