package com.example.android.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

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

    public Place(String placeName, int imageResourceId, String category) {
        mPlaceName = placeName;
        mImageResourceId = imageResourceId;
        mCategory = category;
    }

    public Place(String placeName) {
        mPlaceName = placeName;
        mCategory = POPULARS;
    }

    protected Place(Parcel in) {
        mPlaceName = in.readString();
        mAddress = in.readString();
        mAvailableHours = in.readString();
        mPhone = in.readString();
        mWeb = in.readString();
        mLocation = in.readString();
        mCategory = in.readString();
        mImageResourceId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPlaceName);
        dest.writeString(mAddress);
        dest.writeString(mAvailableHours);
        dest.writeString(mPhone);
        dest.writeString(mWeb);
        dest.writeString(mLocation);
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

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getCategory() {
        return mCategory;
    }
}
