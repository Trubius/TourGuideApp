package com.example.android.tourguideapp;

public class MuseumsFragment extends PlaceListFragment {

    public MuseumsFragment() {
        setCategory(Place.MUSEUMS);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBarTitle(Place.MUSEUMS);
    }
}
