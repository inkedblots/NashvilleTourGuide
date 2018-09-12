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
public class MusicFragment extends Fragment {

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

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to select the location when the card is clicked on.
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
