package com.siva.foodapp.data;

import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by sarumugam on 07/11/16.
 */
public class RestaurantDataModel {

    private String mRestaurantName;
    private String mRestaurantPicUrl;
    private ArrayList<FoodType> mFoodTypes;
    private String mTimeToDeliver;
    private String mMinimumOrder;

    public String getRestaurantName() {
        return mRestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.mRestaurantName = restaurantName;
    }

    public String getRestaurantPicUrl() {
        return mRestaurantPicUrl;
    }

    public void setRestaurantPicUrl(String restaurantPicUrl) {
        this.mRestaurantPicUrl = restaurantPicUrl;
    }

    public ArrayList<FoodType> getFoodTypes() {
        return mFoodTypes;
    }

    public void setFoodTypes(ArrayList<FoodType> foodTypes) {
        this.mFoodTypes = foodTypes;
    }

    public String getTimeToDeliver() {
        return mTimeToDeliver;
    }

    public void setTimeToDeliver(String timeToDeliver) {
        this.mTimeToDeliver = timeToDeliver;
    }

    public String getMinimumOrder() {
        return mMinimumOrder;
    }

    public void setMinimumOrder(String minimumOrder) {
        this.mMinimumOrder = minimumOrder;
    }

    public String getDisplayFoodType() {
        String displayFood = "";
        for (int i = 0;i<mFoodTypes.size();i++) {
            if(!TextUtils.isEmpty(displayFood)){
                displayFood = displayFood+", ";
            }
            displayFood = displayFood + mFoodTypes.get(i).getDishName();
        }

        return displayFood;
    }
}
