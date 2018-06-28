package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private ListView mDrawerList;

    // Use android.support.v7.app.ActionBarDrawerToggle version.
    private ActionBarDrawerToggle mDrawerToggle;

    private Context mMain;

    /**
     * Setup the main screen
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        mDrawerList = findViewById(R.id.navList);
        mDrawer = findViewById(R.id.drawerLayout);


        addDrawerItems();
        setupDrawer();

        // Show nav icon on Action Bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Find the viewpager allows user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto viewPager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.slidingTabs);
        tabLayout.setupWithViewPager(viewPager);

        // start new intent
        mMain = this;

    }

    /**
     * Setup the navigation drawer list
     */
    private void addDrawerItems() {

        Spanned[] navArray = {Html.fromHtml(getString(R.string.about)),
                Html.fromHtml(getString(R.string.nashMap)),
                Html.fromHtml(getString(R.string.mta)),};

        ArrayAdapter<Spanned> mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, navArray);
        mDrawerList.setAdapter(mAdapter);

        // Build navigation header
        View headerView = View.inflate(this, R.layout.nav_header, null);
        ((ImageView) headerView.findViewById(R.id.image_nav)).setImageResource(R.drawable.nashvilleskyline1280);
        mDrawerList.addHeaderView(headerView);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent to the Main Activity
                if (position == 0) {
                    Intent intent = new Intent(mMain, MainActivity.class);
                    startActivity(intent);

                }

                // Intent to About Nashville Activity
                if (position == 1) {
                    Intent intent = new Intent(mMain, AboutNashville.class);
                    startActivity(intent);

                }
                // Intent to `Nashville` City Map Activity
                if (position == 2) {
                    Intent intent = new Intent(mMain, Maps.class);
                    startActivity(intent);

                }
                // Intent to the Transportation Activity
                if (position == 3) {
                    Intent intent = new Intent(mMain, Transportation.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, R.string.drawer_open,
                R.string.drawer_close) {
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawer.addDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Activate navigation drawer toggle
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
