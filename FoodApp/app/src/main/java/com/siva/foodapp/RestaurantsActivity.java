package com.siva.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.siva.foodapp.data.RestaurantDataModel;
import com.siva.foodapp.dummy.ResponseMock;

import java.util.ArrayList;

/**
 * Created by sarumugam on 06/11/16.
 */
public class RestaurantsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private RecyclerView mRestaurantListView;
    private ArrayList<RestaurantDataModel> mRestaurantDataModels;
    private RestaurantAdapter mRestaurantAdapter;

    private NavigationView mNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        // Initializing Toolbar and setting it as the actionbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mRestaurantListView = (RecyclerView) findViewById(R.id.restaurant_list);
        mRestaurantDataModels = ResponseMock.getRestaurantsDetails();
        mRestaurantAdapter = new RestaurantAdapter(this, mRestaurantDataModels);
        mRestaurantAdapter.setItemClickListener(new RestaurantAdapter.ItemClickListener() {
            @Override
            public void onSelectingRestaurant(RestaurantDataModel data) {
                Toast.makeText(RestaurantsActivity.this,"Selected : "+data.getRestaurantName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RestaurantsActivity.this, RestaurantDetailsActivity.class);
                intent.putExtra(RestaurantDetailsActivity.EXTRA,data);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRestaurantListView.setLayoutManager(mLayoutManager);

//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mRestaurantListView.setAdapter(mRestaurantAdapter);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        //Initializing NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.drawer_list);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {

                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.restaurants:
                        Toast.makeText(getApplicationContext(), "Resturants Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.orders:
                        Toast.makeText(getApplicationContext(), "Orders Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.info:
                        Toast.makeText(getApplicationContext(), "Info Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        // Initializing Drawer Layout and ActionBarToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,
                mToolbar,R.string.open, R.string.close){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
}
