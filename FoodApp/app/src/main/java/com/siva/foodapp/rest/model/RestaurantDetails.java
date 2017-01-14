package com.siva.foodapp.rest.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sarumugam on 14/01/17.
 */
public class RestaurantDetails implements Serializable {

    private List<Restaurants> restaurants;

    public List<Restaurants> getRestaurants() {
        return restaurants;
    }
}
