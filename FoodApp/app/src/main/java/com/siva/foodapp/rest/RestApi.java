package com.siva.foodapp.rest;

import com.siva.foodapp.rest.model.RestaurantDetails;
import com.siva.foodapp.rest.model.Restaurants;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by sarumugam on 13/01/17.
 */

public interface RestApi {

    @GET("/gmf-services/rest/api/findRestaurants/{city}/{location}")
    Call<RestaurantDetails> getRestaurantDetails(@Path("city") String city, @Path("location") String location);
}
