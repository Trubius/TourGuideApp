package com.example.android.tourguideapp;

import android.content.Context;
import android.util.DisplayMetrics;

// calculate number of columns and load the image as calculated
public class Utility {
    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
}