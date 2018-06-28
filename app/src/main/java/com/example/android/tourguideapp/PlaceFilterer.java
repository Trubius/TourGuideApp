package com.example.android.tourguideapp;

import java.util.ArrayList;
import java.util.List;

public class PlaceFilterer {

    ArrayList<Place> filteredPlaces = new ArrayList<>();

    public PlaceFilterer(List<Place> places, String category) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getCategory().equals(category)) {
                filteredPlaces.add(places.get(i));
            }
        }
    }

    public ArrayList<Place> getFilteredPlaces() {
        return filteredPlaces;
    }
}
