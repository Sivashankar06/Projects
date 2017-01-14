package com.siva.foodapp.rest.model;

/**
 * Created by sarumugam on 14/01/17.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DishSide extends PojoModel implements Serializable {

    @JsonProperty("sidesSeqId")
    private int sidesSeqId;
    @JsonProperty("dishSides")
    private String dishSides;
    @JsonProperty("dishSidesPrice")
    private int dishSidesPrice;
    @JsonProperty("dishType")
    private String dishType;
    @JsonProperty("freeOrNot")
    private String freeOrNot;

    @JsonProperty("sidesSeqId")
    public int getSidesSeqId() {
        return sidesSeqId;
    }

    @JsonProperty("sidesSeqId")
    public void setSidesSeqId(int sidesSeqId) {
        this.sidesSeqId = sidesSeqId;
    }

    @JsonProperty("dishSides")
    public String getDishSides() {
        return dishSides;
    }

    @JsonProperty("dishSides")
    public void setDishSides(String dishSides) {
        this.dishSides = dishSides;
    }

    @JsonProperty("dishSidesPrice")
    public int getDishSidesPrice() {
        return dishSidesPrice;
    }

    @JsonProperty("dishSidesPrice")
    public void setDishSidesPrice(int dishSidesPrice) {
        this.dishSidesPrice = dishSidesPrice;
    }

    @JsonProperty("dishType")
    public String getDishType() {
        return dishType;
    }

    @JsonProperty("dishType")
    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    @JsonProperty("freeOrNot")
    public String getFreeOrNot() {
        return freeOrNot;
    }

    @JsonProperty("freeOrNot")
    public void setFreeOrNot(String freeOrNot) {
        this.freeOrNot = freeOrNot;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DishSide)) {
            return false;
        }
        DishSide rhs = ((DishSide) other);
        return new EqualsBuilder().append(sidesSeqId, rhs.sidesSeqId).append(dishSides, rhs.dishSides)
                .append(dishSidesPrice, rhs.dishSidesPrice).append(dishType, rhs.dishType)
                .append(freeOrNot, rhs.freeOrNot).isEquals();
    }
}