package com.siva.foodapp.data;

/**
 * Created by sarumugam on 07/11/16.
 */
public class FoodType {

    private String mDishName;
    private int mNumberOfItems;
    private int mPrice;

    public String getDishName() {
        return mDishName;
    }

    public void setDishName(String dishName) {
        this.mDishName = dishName;
    }

    public int getNumberOfItems() {
        return mNumberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.mNumberOfItems = numberOfItems;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        this.mPrice = price;
    }
}