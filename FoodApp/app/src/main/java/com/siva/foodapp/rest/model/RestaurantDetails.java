package com.siva.foodapp.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarumugam on 14/01/17.
 */
public class RestaurantDetails implements Serializable {

    private ArrayList<Restaurants> restaurants;

    public ArrayList<Restaurants> getRestaurants() {
        return restaurants;
    }
}
