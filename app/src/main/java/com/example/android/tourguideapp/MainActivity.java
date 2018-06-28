package com.example.android.tourguideapp;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        if (findViewById(R.id.container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            Fragment fragment = new AllPlacesFragment();
            transaction.add(R.id.container, fragment);
            transaction.commit();
        }
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
                            ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                            Fragment fragment = new PopularPlacesFragment();
                            transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.container, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        } else if (id == R.id.museums) {
                            ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                            Fragment fragment = new MuseumsFragment();
                            transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.container, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        } else if (id == R.id.restaurants) {

                        } else if (id == R.id.pubs) {

                        } else if (id == R.id.hotels) {

                        }

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    public static ArrayList<Place> getPlacesList() {

        ArrayList<Place> places = new ArrayList<Place>();
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
