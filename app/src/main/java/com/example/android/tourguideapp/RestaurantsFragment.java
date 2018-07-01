package com.example.android.tourguideapp;

public class RestaurantsFragment extends PlaceListFragment {

    public RestaurantsFragment() {
        setCategory(Place.RESTAURANTS);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBarTitle(Place.RESTAURANTS);
    }
}
