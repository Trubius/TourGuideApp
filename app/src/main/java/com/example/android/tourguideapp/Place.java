package com.example.android.tourguideapp;

public class Place {

    private String mPlaceName;
    private String mAddress;
    private String mAvailableHours;
    private String mPhone;
    private String mWeb;
    private String mLocation;
    private String mCategory;
    private int mImageResourceId;
    public final static String POPULARS = "Popular Places";
    public final static String MUSEUMS = "Museums";
    public final static String RESTAURANTS = "Restaurants";
    public final static String PUBS = "Pubs";
    public final static String HOTELS = "Hotels";

    public Place(String placeName, String category) {
        mPlaceName = placeName;
        mCategory = category;
    }

    public Place(String placeName) {
        mPlaceName = placeName;
        mCategory = POPULARS;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getCategory() {
        return mCategory;
    }
}
