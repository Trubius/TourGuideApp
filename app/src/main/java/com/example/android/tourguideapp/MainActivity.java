package com.example.android.tourguideapp;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private PlaceAdapter mPlaceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (mDrawerLayout != null) {
            mDrawerLayout.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        List<Place> listPlaces = getPlacesList();
        mPlaceAdapter = new PlaceAdapter(this, listPlaces);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mPlaceAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, mNoOfColumns));


    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // Handle navigation view item clicks here.
                        int id = item.getItemId();

                        if (id == R.id.popular_places) {
                            mPlaceAdapter.setCategory(Place.POPULARS);
                        } else if (id == R.id.museums) {
                            mPlaceAdapter.setCategory(Place.MUSEUMS);
                        } else if (id == R.id.restaurants) {
                            mPlaceAdapter.setCategory(Place.RESTAURANTS);
                        } else if (id == R.id.pubs) {
                            mPlaceAdapter.setCategory(Place.PUBS);
                        } else if (id == R.id.hotels) {
                            mPlaceAdapter.setCategory(Place.HOTELS);
                        }

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    // calculate number of columns and load the image as calculated
    private static class Utility {
        public static int calculateNoOfColumns(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int noOfColumns = (int) (dpWidth / 180);
            return noOfColumns;
        }
    }

    private List<Place> getPlacesList() {

        List<Place> places = new ArrayList<Place>();
        places.add(new Place("Budapest", Place.PUBS));
        places.add(new Place("Text2", Place.PUBS));
        places.add(new Place("Text3", Place.RESTAURANTS));
        places.add(new Place("Text4", Place.RESTAURANTS));
        places.add(new Place("Text5", Place.RESTAURANTS));
        places.add(new Place("Text6", Place.HOTELS));
        places.add(new Place("Text8", Place.HOTELS));
        places.add(new Place("Text7", Place.POPULARS));
        places.add(new Place("Text9", Place.MUSEUMS));
        places.add(new Place("Text10", Place.MUSEUMS));
        places.add(new Place("Text11", Place.MUSEUMS));
        return places;
    }
}
