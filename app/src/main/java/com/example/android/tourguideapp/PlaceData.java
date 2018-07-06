package com.example.android.tourguideapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlaceData {

    public static ArrayList<Place> getPlacesList(Context context) {

        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("York Minster", "Description", "Deangate, York YO1 7HH, UK", "9AM-6PM", "+44-1904-557200", context.getString(R.string.minster_web), 53.9627139, -1.0812212, Place.PUBS, R.drawable.sample_0));

        long seed = System.nanoTime();
        Collections.shuffle(places, new Random(seed));

        return places;
    }
}
