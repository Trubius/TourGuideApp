package com.example.android.tourguideapp;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (mDrawerLayout != null) {
            mDrawerLayout.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
        navigationView.getMenu().getItem(0).setChecked(true);

        if (savedInstanceState != null) {
            return;
        }
        Fragment fragment = new AllPlacesFragment();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // Handle navigation view item clicks here.
                        replaceFragment(getFragmentByItemId(item.getItemId()));
                        mDrawerLayout.closeDrawers();
                        return true;
                    }

                    private void replaceFragment(Fragment fragment) {
                        ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, fragment);
                        transaction.commit();
                    }

                    private Fragment getFragmentByItemId(int itemId) {
                        switch (itemId) {
                            case R.id.home:
                                return new AllPlacesFragment();
                            case R.id.popular_places:
                                return new PopularPlacesFragment();
                            case R.id.museums:
                                return new MuseumsFragment();
                            case R.id.pubs:
                                return new PubsFragment();
                            case R.id.hotels:
                                return new HotelsFragment();
                            default:
                                return new AllPlacesFragment();
                        }
                    }
                });
    }
}
