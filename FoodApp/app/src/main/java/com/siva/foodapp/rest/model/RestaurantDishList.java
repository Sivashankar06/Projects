package com.siva.foodapp.rest.model;

/**
 * Created by sarumugam on 14/01/17.
 */

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantDishList extends PojoModel implements Serializable {

    @JsonProperty("dishId")
    private int dishId;
    @JsonProperty("dishCategory")
    private String dishCategory;
    @JsonProperty("dishName")
    private String dishName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("cuisinType")
    private String cuisinType;
    @JsonProperty("spicyCount")
    private String spicyCount;
    @JsonProperty("popular")
    private String popular;
    @JsonProperty("dishPrice")
    private int dishPrice;
    @JsonProperty("containerPrice")
    private int containerPrice;
    @JsonProperty("available")
    private String available;
    @JsonProperty("outletSpecial")
    private String outletSpecial;
    @JsonProperty("dishImag")
    private String dishImag;
    @JsonProperty("dishSides")
    private ArrayList<DishSide> dishSides = null;
    @JsonProperty("containerCapacity")
    private int containerCapacity;

    @JsonProperty("dishId")
    public int getDishId() {
        return dishId;
    }

    @JsonProperty("dishId")
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @JsonProperty("dishCategory")
    public String getDishCategory() {
        return dishCategory;
    }

    @JsonProperty("dishCategory")
    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    @JsonProperty("dishName")
    public String getDishName() {
        return dishName;
    }

    @JsonProperty("dishName")
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("cuisinType")
    public String getCuisinType() {
        return cuisinType;
    }

    @JsonProperty("cuisinType")
    public void setCuisinType(String cuisinType) {
        this.cuisinType = cuisinType;
    }

    @JsonProperty("spicyCount")
    public String getSpicyCount() {
        return spicyCount;
    }

    @JsonProperty("spicyCount")
    public void setSpicyCount(String spicyCount) {
        this.spicyCount = spicyCount;
    }

    @JsonProperty("popular")
    public String getPopular() {
        return popular;
    }

    @JsonProperty("popular")
    public void setPopular(String popular) {
        this.popular = popular;
    }

    @JsonProperty("dishPrice")
    public int getDishPrice() {
        return dishPrice;
    }

    @JsonProperty("dishPrice")
    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }

    @JsonProperty("containerPrice")
    public int getContainerPrice() {
        return containerPrice;
    }

    @JsonProperty("containerPrice")
    public void setContainerPrice(int containerPrice) {
        this.containerPrice = containerPrice;
    }

    @JsonProperty("available")
    public String getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(String available) {
        this.available = available;
    }

    @JsonProperty("outletSpecial")
    public String getOutletSpecial() {
        return outletSpecial;
    }

    @JsonProperty("outletSpecial")
    public void setOutletSpecial(String outletSpecial) {
        this.outletSpecial = outletSpecial;
    }

    @JsonProperty("dishImag")
    public String getDishImag() {
        return dishImag;
    }

    @JsonProperty("dishImag")
    public void setDishImag(String dishImag) {
        this.dishImag = dishImag;
    }

    @JsonProperty("dishSides")
    public ArrayList<DishSide> getDishSides() {
        return dishSides;
    }

    @JsonProperty("dishSides")
    public void setDishSides(ArrayList<DishSide> dishSides) {
        this.dishSides = dishSides;
    }

    @JsonProperty("containerCapacity")
    public int getContainerCapacity() {
        return containerCapacity;
    }

    @JsonProperty("containerCapacity")
    public void setContainerCapacity(int containerCapacity) {
        this.containerCapacity = containerCapacity;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof RestaurantDishList)) {
            return false;
        }
        RestaurantDishList rhs = ((RestaurantDishList) other);
        return new EqualsBuilder().append(dishId, rhs.dishId).append(dishCategory, rhs.dishCategory)
                .append(dishName, rhs.dishName).append(description, rhs.description).append(cuisinType, rhs.cuisinType)
                .append(spicyCount, rhs.spicyCount).append(popular, rhs.popular).append(dishPrice, rhs.dishPrice)
                .append(containerPrice, rhs.containerPrice).append(available, rhs.available)
                .append(outletSpecial, rhs.outletSpecial).append(dishImag, rhs.dishImag).append(dishSides, rhs.dishSides)
                .append(containerCapacity, rhs.containerCapacity).isEquals();
    }
}