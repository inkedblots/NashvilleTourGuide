package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Location} objects.
 */
class CategoryAdapter extends FragmentPagerAdapter {

    private final Context context;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    CategoryAdapter(FragmentManager fm, Context nContext) {
        super(fm);
        context = nContext;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MusicFragment();
        } else if (position == 1) {
            return new MuseumFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else if (position == 3) {
            return new BreweryFragment();
        } else if (position == 4) {
            return new OutdoorFragment();
        } else if (position == 5) {
            return new InfoFragment();
        }
        return null;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    // ADD PAGE TITLE
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.category_music);
        } else if (position == 1) {
            return context.getString(R.string.category_museum);
        } else if (position == 2) {
            return context.getString(R.string.category_food);
        } else if (position == 3) {
            return context.getString(R.string.category_brewery);
        } else {
            return context.getString(R.string.category_outdoor);
        }
    }

}