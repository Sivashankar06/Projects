package com.siva.foodapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.siva.foodapp.data.RestaurantDataModel;
import com.siva.foodapp.dummy.ResponseMock;

import java.util.ArrayList;

/**
 * Created by sarumugam on 06/11/16.
 */
public class RestaurantsActivity extends AppCompatActivity {

    private ArrayList<RestaurantDataModel> mRestaurantDataModels;
    private RecyclerView mRestaurantListView;
    private RestaurantAdapter mRestaurantAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        mRestaurantListView = (RecyclerView) findViewById(R.id.restaurant_list);

        mRestaurantDataModels = ResponseMock.getRestaurantsDetails();
        mRestaurantAdapter = new RestaurantAdapter(this, mRestaurantDataModels);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRestaurantListView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mRestaurantListView.setAdapter(mRestaurantAdapter);
    }
}
