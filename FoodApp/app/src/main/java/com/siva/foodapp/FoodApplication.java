package com.siva.foodapp;

import android.app.Application;

import com.siva.foodapp.rest.RestApi;
import com.siva.foodapp.rest.RetrofitClient;
import com.siva.foodapp.rest.model.RestaurantDetails;

/**
 * Created by sarumugam on 13/01/17.
 */

public class FoodApplication extends Application {

    private RestApi mRestApi;

    private RestaurantDetails mRestaurantDetails;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RestApi getRestApi() {
        if(mRestApi == null){
            mRestApi = RetrofitClient.getRetroClient().create(RestApi.class);
        }
        return mRestApi;
    }

    public RestaurantDetails getRestaurantDetails() {
        return mRestaurantDetails;
    }

    public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
        this.mRestaurantDetails = restaurantDetails;
    }
}
