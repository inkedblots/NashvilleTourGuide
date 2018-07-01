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

        // Set a click listener to select the food when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Send intent to new {@Link LocationDetailActivity} with details for the current selected
                // food.
                Intent intent;
                intent = new Intent(getActivity(), LocationDetailActivity.class);

                startActivity(intent);
            }
        });

        return rootView;
    }
}
