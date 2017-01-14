package com.siva.foodapp.rest.model;

/**
 * Created by sarumugam on 13/01/17.
 */
import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.builder.EqualsBuilder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurants extends PojoModel implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("restaurantType")
    private String restaurantType;
    @JsonProperty("resParentSeqId")
    private int resParentSeqId;
    @JsonProperty("homeDelivery")
    private String homeDelivery;
    @JsonProperty("seaFood")
    private String seaFood;
    @JsonProperty("resRating")
    private int resRating;
    @JsonProperty("minDeliveryAmount")
    private int minDeliveryAmount;
    @JsonProperty("state")
    private String state;
    @JsonProperty("city")
    private String city;
    @JsonProperty("location")
    private String location;
    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("resWebUrl")
    private String resWebUrl;
    @JsonProperty("resMapUrl")
    private String resMapUrl;
    @JsonProperty("restImage")
    private String restImage;
    @JsonProperty("serviceTax")
    private float serviceTax;
    @JsonProperty("economyRatings")
    private int economyRatings;
    @JsonProperty("restorantDishList")
    private ArrayList<RestaurantDishList> restaurantDishLists;
    @JsonProperty("menuSectionList")
    private ArrayList<String> menuSectionList;
    @JsonProperty("workingDays")
    private ArrayList<WorkingDay> workingDays = null;
    @JsonProperty("convenienceChargePerAmount")
    private int convenienceChargePerAmount;
    @JsonProperty("discountApplicable")
    private String discountApplicable;
    @JsonProperty("discountPercentage")
    private double discountPercentage;
    @JsonProperty("minDiscountAmount")
    private int minDiscountAmount;
    @JsonProperty("district")
    private String district;
    @JsonProperty("tradeName")
    private String tradeName;
    @JsonProperty("deliveryCharge")
    private int deliveryCharge;
    @JsonProperty("containerChangeApplicable")
    private String containerChangeApplicable;
    @JsonProperty("containerCharge")
    private int containerCharge;
    @JsonProperty("serviceTaxApplicable")
    private String serviceTaxApplicable;
    @JsonProperty("vatAmountIncluded")
    private String vatAmountIncluded;
    @JsonProperty("convenienceChargesApplicable")
    private String convenienceChargesApplicable;
    @JsonProperty("convenienceCharge")
    private int convenienceCharge;
    @JsonProperty("conveniencePercentage")
    private int conveniencePercentage;
    @JsonProperty("restActive")
    private String restActive;
    @JsonProperty("mindeliverytime")
    private String mindeliverytime;
    @JsonProperty("discountStartDate")
    private long discountStartDate;
    @JsonProperty("discountEndDate")
    private long discountEndDate;
    @JsonProperty("servingLocation")
    private String servingLocation;
    @JsonProperty("availabilityMessage")
    private String availabilityMessage;
    @JsonProperty("tempResCloseStartDate")
    private String tempResCloseStartDate;
    @JsonProperty("tempResCloseEndDate")
    private String tempResCloseEndDate;
    private final static long serialVersionUID = 855832297950802159L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("restaurantType")
    public String getRestaurantType() {
        return restaurantType;
    }

    @JsonProperty("restaurantType")
    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    @JsonProperty("resParentSeqId")
    public int getResParentSeqId() {
        return resParentSeqId;
    }

    @JsonProperty("resParentSeqId")
    public void setResParentSeqId(int resParentSeqId) {
        this.resParentSeqId = resParentSeqId;
    }

    @JsonProperty("homeDelivery")
    public String getHomeDelivery() {
        return homeDelivery;
    }

    @JsonProperty("homeDelivery")
    public void setHomeDelivery(String homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    @JsonProperty("seaFood")
    public String getSeaFood() {
        return seaFood;
    }

    @JsonProperty("seaFood")
    public void setSeaFood(String seaFood) {
        this.seaFood = seaFood;
    }

    @JsonProperty("resRating")
    public int getResRating() {
        return resRating;
    }

    @JsonProperty("resRating")
    public void setResRating(int resRating) {
        this.resRating = resRating;
    }

    @JsonProperty("minDeliveryAmount")
    public int getMinDeliveryAmount() {
        return minDeliveryAmount;
    }

    @JsonProperty("minDeliveryAmount")
    public void setMinDeliveryAmount(int minDeliveryAmount) {
        this.minDeliveryAmount = minDeliveryAmount;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty("addressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @JsonProperty("addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    @JsonProperty("addressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("resWebUrl")
    public String getResWebUrl() {
        return resWebUrl;
    }

    @JsonProperty("resWebUrl")
    public void setResWebUrl(String resWebUrl) {
        this.resWebUrl = resWebUrl;
    }

    @JsonProperty("resMapUrl")
    public String getResMapUrl() {
        return resMapUrl;
    }

    @JsonProperty("resMapUrl")
    public void setResMapUrl(String resMapUrl) {
        this.resMapUrl = resMapUrl;
    }

    @JsonProperty("restImage")
    public String getRestImage() {
        return restImage;
    }

    @JsonProperty("restImage")
    public void setRestImage(String restImage) {
        this.restImage = restImage;
    }

    @JsonProperty("serviceTax")
    public float getServiceTax() {
        return serviceTax;
    }

    @JsonProperty("serviceTax")
    public void setServiceTax(float serviceTax) {
        this.serviceTax = serviceTax;
    }

    @JsonProperty("restorantDishList")
    public ArrayList<RestaurantDishList> getRestaurantDishLists() {
        return restaurantDishLists;
    }

    @JsonProperty("restorantDishList")
    public void setRestaurantDishLists(ArrayList<RestaurantDishList> restaurantDishLists) {
        this.restaurantDishLists = restaurantDishLists;
    }

    @JsonProperty("economyRatings")
    public int getEconomyRatings() {
        return economyRatings;
    }

    @JsonProperty("economyRatings")
    public void setEconomyRatings(int economyRatings) {
        this.economyRatings = economyRatings;
    }

    @JsonProperty("menuSectionList")
    public ArrayList<String> getMenuSectionList() {
        return menuSectionList;
    }

    @JsonProperty("menuSectionList")
    public void setMenuSectionList(ArrayList<String> menuSectionList) {
        this.menuSectionList = menuSectionList;
    }

    @JsonProperty("workingDays")
    public ArrayList<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    @JsonProperty("workingDays")
    public void setWorkingDays(ArrayList<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }

    @JsonProperty("convenienceChargePerAmount")
    public int getConvenienceChargePerAmount() {
        return convenienceChargePerAmount;
    }

    @JsonProperty("convenienceChargePerAmount")
    public void setConvenienceChargePerAmount(int convenienceChargePerAmount) {
        this.convenienceChargePerAmount = convenienceChargePerAmount;
    }

    @JsonProperty("discountApplicable")
    public String getDiscountApplicable() {
        return discountApplicable;
    }

    @JsonProperty("discountApplicable")
    public void setDiscountApplicable(String discountApplicable) {
        this.discountApplicable = discountApplicable;
    }

    @JsonProperty("discountPercentage")
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @JsonProperty("discountPercentage")
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @JsonProperty("minDiscountAmount")
    public int getMinDiscountAmount() {
        return minDiscountAmount;
    }

    @JsonProperty("minDiscountAmount")
    public void setMinDiscountAmount(int minDiscountAmount) {
        this.minDiscountAmount = minDiscountAmount;
    }

    @JsonProperty("district")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonProperty("tradeName")
    public String getTradeName() {
        return tradeName;
    }

    @JsonProperty("tradeName")
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @JsonProperty("deliveryCharge")
    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    @JsonProperty("deliveryCharge")
    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    @JsonProperty("containerChangeApplicable")
    public String getContainerChangeApplicable() {
        return containerChangeApplicable;
    }

    @JsonProperty("containerChangeApplicable")
    public void setContainerChangeApplicable(String containerChangeApplicable) {
        this.containerChangeApplicable = containerChangeApplicable;
    }

    @JsonProperty("containerCharge")
    public int getContainerCharge() {
        return containerCharge;
    }

    @JsonProperty("containerCharge")
    public void setContainerCharge(int containerCharge) {
        this.containerCharge = containerCharge;
    }

    @JsonProperty("serviceTaxApplicable")
    public String getServiceTaxApplicable() {
        return serviceTaxApplicable;
    }

    @JsonProperty("serviceTaxApplicable")
    public void setServiceTaxApplicable(String serviceTaxApplicable) {
        this.serviceTaxApplicable = serviceTaxApplicable;
    }

    @JsonProperty("vatAmountIncluded")
    public String getVatAmountIncluded() {
        return vatAmountIncluded;
    }

    @JsonProperty("vatAmountIncluded")
    public void setVatAmountIncluded(String vatAmountIncluded) {
        this.vatAmountIncluded = vatAmountIncluded;
    }

    @JsonProperty("convenienceChargesApplicable")
    public String getConvenienceChargesApplicable() {
        return convenienceChargesApplicable;
    }

    @JsonProperty("convenienceChargesApplicable")
    public void setConvenienceChargesApplicable(String convenienceChargesApplicable) {
        this.convenienceChargesApplicable = convenienceChargesApplicable;
    }

    @JsonProperty("convenienceCharge")
    public int getConvenienceCharge() {
        return convenienceCharge;
    }

    @JsonProperty("convenienceCharge")
    public void setConvenienceCharge(int convenienceCharge) {
        this.convenienceCharge = convenienceCharge;
    }

    @JsonProperty("conveniencePercentage")
    public int getConveniencePercentage() {
        return conveniencePercentage;
    }

    @JsonProperty("conveniencePercentage")
    public void setConveniencePercentage(int conveniencePercentage) {
        this.conveniencePercentage = conveniencePercentage;
    }

    @JsonProperty("restActive")
    public String getRestActive() {
        return restActive;
    }

    @JsonProperty("restActive")
    public void setRestActive(String restActive) {
        this.restActive = restActive;
    }

    @JsonProperty("mindeliverytime")
    public String getMindeliverytime() {
        return mindeliverytime;
    }

    @JsonProperty("mindeliverytime")
    public void setMindeliverytime(String mindeliverytime) {
        this.mindeliverytime = mindeliverytime;
    }

    @JsonProperty("discountStartDate")
    public long getDiscountStartDate() {
        return discountStartDate;
    }

    @JsonProperty("discountStartDate")
    public void setDiscountStartDate(long discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    @JsonProperty("discountEndDate")
    public long getDiscountEndDate() {
        return discountEndDate;
    }

    @JsonProperty("discountEndDate")
    public void setDiscountEndDate(long discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    @JsonProperty("servingLocation")
    public String getServingLocation() {
        return servingLocation;
    }

    @JsonProperty("servingLocation")
    public void setServingLocation(String servingLocation) {
        this.servingLocation = servingLocation;
    }

    @JsonProperty("availabilityMessage")
    public String getAvailabilityMessage() {
        return availabilityMessage;
    }

    @JsonProperty("availabilityMessage")
    public void setAvailabilityMessage(String availabilityMessage) {
        this.availabilityMessage = availabilityMessage;
    }

    @JsonProperty("tempResCloseStartDate")
    public String getTempResCloseStartDate() {
        return tempResCloseStartDate;
    }

    @JsonProperty("tempResCloseStartDate")
    public void setTempResCloseStartDate(String tempResCloseStartDate) {
        this.tempResCloseStartDate = tempResCloseStartDate;
    }

    @JsonProperty("tempResCloseEndDate")
    public String getTempResCloseEndDate() {
        return tempResCloseEndDate;
    }

    @JsonProperty("tempResCloseEndDate")
    public void setTempResCloseEndDate(String tempResCloseEndDate) {
        this.tempResCloseEndDate = tempResCloseEndDate;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Restaurants)) {
            return false;
        }
        Restaurants rhs = ((Restaurants) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(restaurantType, rhs.restaurantType)
                .append(resParentSeqId, rhs.resParentSeqId).append(homeDelivery, rhs.homeDelivery)
                .append(seaFood, rhs.seaFood).append(resRating, rhs.resRating).append(minDeliveryAmount, rhs.minDeliveryAmount)
                .append(state, rhs.state).append(city, rhs.city).append(location, rhs.location)
                .append(addressLine1, rhs.addressLine1).append(addressLine2, rhs.addressLine2).append(zipCode, rhs.zipCode)
                .append(resWebUrl, rhs.resWebUrl).append(resMapUrl, rhs.resMapUrl).append(restImage, rhs.restImage)
                .append(serviceTax, rhs.serviceTax).append(economyRatings, rhs.economyRatings).append(workingDays, rhs.workingDays)
                .append(convenienceChargePerAmount, rhs.convenienceChargePerAmount).append(discountApplicable, rhs.discountApplicable)
                .append(discountPercentage, rhs.discountPercentage).append(minDiscountAmount, rhs.minDiscountAmount)
                .append(district, rhs.district).append(tradeName, rhs.tradeName).append(deliveryCharge, rhs.deliveryCharge)
                .append(containerChangeApplicable, rhs.containerChangeApplicable).append(containerCharge, rhs.containerCharge)
                .append(serviceTaxApplicable, rhs.serviceTaxApplicable).append(vatAmountIncluded, rhs.vatAmountIncluded)
                .append(convenienceChargesApplicable, rhs.convenienceChargesApplicable).append(convenienceCharge, rhs.convenienceCharge)
                .append(conveniencePercentage, rhs.conveniencePercentage).append(restActive, rhs.restActive)
                .append(mindeliverytime, rhs.mindeliverytime).append(discountStartDate, rhs.discountStartDate)
                .append(discountEndDate, rhs.discountEndDate).append(servingLocation, rhs.servingLocation)
                .append(availabilityMessage, rhs.availabilityMessage).append(tempResCloseStartDate, rhs.tempResCloseStartDate)
                .append(tempResCloseEndDate, rhs.tempResCloseEndDate).isEquals();
    }
}