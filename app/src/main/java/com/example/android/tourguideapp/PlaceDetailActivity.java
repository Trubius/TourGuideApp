package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlaceDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String placeName;
    double lat;
    double lng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Place place = getIntent().getParcelableExtra("place_detail");
        placeName = place.getPlaceName();
        String description = place.getDescription();
        String address = place.getAddress();
        String web = place.getWeb();
        String phone = place.getPhone();
        String hours = place.getAvailableHours();
        lat = place.getLat();
        lng = place.getLng();
        int imageId = place.getImageResourceId();
        String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        TextView[] textViews = new TextView[7];

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(imageId).apply(RequestOptions.centerCropTransform()).into(imageView);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(placeName);

        TextView textDescription = (TextView) findViewById(R.id.description);
        textDescription.setText(description);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textDescription.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        TextView textAddress = (TextView) findViewById(R.id.address_text);
        textAddress.setText(address);
        textAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                focusOnView();
            }
        });
        final TextView textWeb = (TextView) findViewById(R.id.web_text);
        textWeb.setText(web);
        textWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = textWeb.getText().toString();
                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
        final TextView textPhone = (TextView) findViewById(R.id.phone_text);
        textPhone.setText(phone);
        textPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = textPhone.getText().toString();
                if (!number.startsWith("tel:")) number = "tel:" + number;
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse(number));
                startActivity(phoneIntent);
            }
        });

        CardView hoursView = findViewById(R.id.hours_view);
        if (place.hasHours()) {
            hoursView.setVisibility(View.VISIBLE);
            for (int i = 0; i < days.length; i++) {
                int item = getResources().getIdentifier(days[i], "id", getPackageName());
                textViews[i] = (TextView) findViewById(item);
                textViews[i].setText(hours);
            }
        } else {
            hoursView.setVisibility(View.GONE);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void focusOnView() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                NestedScrollView scrollView = findViewById(R.id.scroll_view);
                AppBarLayout appBarLayout = findViewById(R.id.appbar);
                CardView mapView = findViewById(R.id.map_view);
                appBarLayout.setExpanded(false, true);
                scrollView.smoothScrollTo(0, mapView.getBottom());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings uiSettings = mMap.getUiSettings();

        LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title(placeName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setScrollGesturesEnabled(false);
    }
}
