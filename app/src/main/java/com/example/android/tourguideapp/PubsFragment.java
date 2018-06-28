package com.example.android.tourguideapp;

public class PubsFragment extends PlaceListFragment{

    public PubsFragment(){
       setCategory(Place.PUBS);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBarTitle(Place.PUBS);
    }
}
