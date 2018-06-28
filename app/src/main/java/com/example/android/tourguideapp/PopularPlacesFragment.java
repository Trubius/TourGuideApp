package com.example.android.tourguideapp;

public class PopularPlacesFragment extends PlaceListFragment{

    public PopularPlacesFragment() {
        setCategory(Place.POPULARS);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBarTitle(Place.POPULARS);
    }
}
