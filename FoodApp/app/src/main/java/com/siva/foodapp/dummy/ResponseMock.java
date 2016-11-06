package com.siva.foodapp.dummy;

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
}
