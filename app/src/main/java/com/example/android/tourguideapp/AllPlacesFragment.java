package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AllPlacesFragment extends Fragment {

    public AllPlacesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rootView = (RecyclerView) inflater.inflate(R.layout.content_main, container, false);
        int mNoOfColumns = Utility.calculateNoOfColumns(getActivity());

        ArrayList<Place> listPlaces = PlaceData.getPlacesList(getContext());
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), listPlaces);
        rootView.setAdapter(placeAdapter);
        rootView.setLayoutManager(new GridLayoutManager(getActivity(), mNoOfColumns));

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.home);
    }
}
