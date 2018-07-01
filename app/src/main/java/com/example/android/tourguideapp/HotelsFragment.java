package com.example.android.tourguideapp;

public class HotelsFragment extends PlaceListFragment {

    public HotelsFragment() {
        setCategory(Place.HOTELS);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBarTitle(Place.HOTELS);
    }
}
