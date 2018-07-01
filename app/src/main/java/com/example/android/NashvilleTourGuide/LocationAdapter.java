package com.example.android.NashvilleTourGuide;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


class LocationAdapter extends ArrayAdapter<Location> {
    /**
     * Create a new {@link LocationAdapter} object.
     *
     * @param context   is the current context (i.e. Activity) that the adapter is being created in.
     * @param locations is the list of {@link Location}s to be displayed.
     */
    // Check if the existing view is being reused, otherwise inflate the view
    LocationAdapter(Activity context, ArrayList<Location> locations) {
        // initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for several TextViews and an ImageView, the adapter
        // is not going to use this second argument, so it can be any value. We used 0.
        super(context, 0, locations);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.location_list, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }
        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Get the location name from the current Location object and
        // set this text on the name TextView
        holder.titleTextView.setText(Objects.requireNonNull(currentLocation).getTitle());

        // Get the address information from the Location object and
        // set this text on the name TextView
        holder.addressTextView.setText(currentLocation.getAddress());

        // Get the hours information from the current Location object and
        // set this text on the name TextView
        holder.businessHoursTextView.setText(currentLocation.getBusinessHours());

        // Get the entrance prices from the current Location object and
        // set this text on the name TextView
        holder.priceTextView.setText(currentLocation.getPrice());

        // Get the description from the current Location object and
        // set this text on the name TextView
        holder.descriptionTextView.setText(currentLocation.getDescription());


        if (currentLocation.hasPhoto()) {
            // Set the ImageView to the image resource specified in the current Location
            holder.imageOfLocation.setImageResource(currentLocation.getImageResourceId());

            // Make sure the view is visible
            holder.imageOfLocation.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to Invisible)
            holder.imageOfLocation.setVisibility(View.INVISIBLE);
        }

        return listItemView;

    }

    static class ViewHolder {
        @BindView(R.id.titleTextView)
        TextView titleTextView;
        @BindView(R.id.addressTextView)
        TextView addressTextView;
        @BindView(R.id.businessHoursTextView)
        TextView businessHoursTextView;
        @BindView(R.id.priceTextView)
        TextView priceTextView;
        @BindView(R.id.description)
        TextView descriptionTextView;
        @BindView(R.id.imageOfLocation)
        ImageView imageOfLocation;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}





