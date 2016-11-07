package com.siva.foodapp.dummy;

import com.siva.foodapp.data.FoodType;
import com.siva.foodapp.data.RestaurantDataModel;

import java.util.ArrayList;

/**
 * Created by sarumugam on 06/11/16.
 */
public class ResponseMock {
    
    public static String[] getAvailableShops(String city){
        String[] shops = new String[25];
        for (int i = 0; i < 25; i++) {
            shops[i] = city+" : "+(i+1);
        }
        return shops;
    }

    public static ArrayList<RestaurantDataModel> getRestaurantsDetails() {
        ArrayList<RestaurantDataModel> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RestaurantDataModel model = new RestaurantDataModel();
            model.setMinimumOrder(""+(9*4));
            model.setRestaurantName("Restaurant "+(i+1));
            model.setTimeToDeliver("45 mins");
            ArrayList<FoodType> types = new ArrayList<>();
            for (int j = 0; j <= 3*i; j++) {
                FoodType type = new FoodType();
                type.setDishName("Dish "+(j+1));
                type.setPrice(25+j);
                types.add(type);
            }
            model.setFoodTypes(types);
//            model.setRestaurantPicUrl();
            data.add(model);
        }
        return data;
    }
}
