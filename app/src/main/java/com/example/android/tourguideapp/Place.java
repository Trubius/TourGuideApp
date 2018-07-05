package com.example.android.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    private String mPlaceName;
    private String mDescription;
    private String mAddress;
    private String mAvailableHours;
    private String mPhone;
    private String mWeb;
    private double mLat;
    private double mLng;
    private String mCategory;
    private int mImageResourceId;
    public final static String POPULARS = "Popular Places";
    public final static String MUSEUMS = "Museums";
    public final static String RESTAURANTS = "Restaurants";
    public final static String PUBS = "Pubs";
    public final static String HOTELS = "Hotels";

    public Place(String placeName, String description, String address, String hours, String phone, String web, double lat, double lng, int imageResourceId, String category) {
        mPlaceName = placeName;
        mDescription = description;
        mAddress = address;
        mAvailableHours = hours;
        mPhone = phone;
        mWeb = web;
        mLat = lat;
        mLng = lng;
        mImageResourceId = imageResourceId;
        mCategory = category;
    }

    public Place(String placeName) {
        mPlaceName = placeName;
        mCategory = POPULARS;
    }

    protected Place(Parcel in) {
        mPlaceName = in.readString();
        mDescription = in.readString();
        mAddress = in.readString();
        mAvailableHours = in.readString();
        mPhone = in.readString();
        mWeb = in.readString();
        mLat = in.readDouble();
        mLng = in.readDouble();
        mCategory = in.readString();
        mImageResourceId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPlaceName);
        dest.writeString(mDescription);
        dest.writeString(mAddress);
        dest.writeString(mAvailableHours);
        dest.writeString(mPhone);
        dest.writeString(mWeb);
        dest.writeDouble(mLat);
        dest.writeDouble(mLng);
        dest.writeString(mCategory);
        dest.writeInt(mImageResourceId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getPlaceName() {
        return mPlaceName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getAvailableHours() {
        return mAvailableHours;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWeb() {
        return mWeb;
    }

    public double getLat() {
        return mLat;
    }

    public double getLng() {
        return mLng;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getCategory() {
        return mCategory;
    }
}
