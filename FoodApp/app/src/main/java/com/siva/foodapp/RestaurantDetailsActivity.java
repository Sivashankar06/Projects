package com.siva.foodapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.siva.foodapp.data.RestaurantDataModel;
import com.siva.foodapp.rest.model.Restaurants;

/**
 * Created by sarumugam on 11/12/16.
 */
public class RestaurantDetailsActivity extends AppCompatActivity {

    public static final String EXTRA = "data";
    private Toolbar mToolbar;
    private Restaurants mDataModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resaurant_details);

        mDataModel = (Restaurants) getIntent().getSerializableExtra(EXTRA);

        // Initializing Toolbar and setting it as the actionbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(mDataModel.getName());
        setSupportActionBar(mToolbar);

    }
}
