package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Place place = intent.getParcelableExtra("Place Detail");
        String placeName = place.getPlaceName();
        int imageId = place.getImageResourceId();

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(imageId).apply(RequestOptions.centerCropTransform()).into(imageView);

        TextView textView = (TextView) findViewById(R.id.name_detail);
        textView.setText(placeName);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(placeName);
    }
}
