package com.siva.foodapp.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by sarumugam on 14/01/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkingDay extends PojoModel implements Serializable {

    @JsonProperty("restWorkDays")
    private String restWorkDays;
    @JsonProperty("restOpenTime")
    private String restOpenTime;
    @JsonProperty("restCloseTime")
    private String restCloseTime;
    @JsonProperty("restDeliveryOpenTime")
    private Object restDeliveryOpenTime;
    @JsonProperty("restDeliveryCloseTime")
    private String restDeliveryCloseTime;
    @JsonProperty("restWorkStatus")
    private String restWorkStatus;
    @JsonProperty("restRecessStatus")
    private String restRecessStatus;
    @JsonProperty("recessStatus")
    private String recessStatus;

    @JsonProperty("restWorkDays")
    public String getRestWorkDays() {
        return restWorkDays;
    }

    @JsonProperty("restWorkDays")
    public void setRestWorkDays(String restWorkDays) {
        this.restWorkDays = restWorkDays;
    }

    @JsonProperty("restOpenTime")
    public String getRestOpenTime() {
        return restOpenTime;
    }

    @JsonProperty("restOpenTime")
    public void setRestOpenTime(String restOpenTime) {
        this.restOpenTime = restOpenTime;
    }

    @JsonProperty("restCloseTime")
    public String getRestCloseTime() {
        return restCloseTime;
    }

    @JsonProperty("restCloseTime")
    public void setRestCloseTime(String restCloseTime) {
        this.restCloseTime = restCloseTime;
    }

    @JsonProperty("restDeliveryOpenTime")
    public Object getRestDeliveryOpenTime() {
        return restDeliveryOpenTime;
    }

    @JsonProperty("restDeliveryOpenTime")
    public void setRestDeliveryOpenTime(Object restDeliveryOpenTime) {
        this.restDeliveryOpenTime = restDeliveryOpenTime;
    }

    @JsonProperty("restDeliveryCloseTime")
    public String getRestDeliveryCloseTime() {
        return restDeliveryCloseTime;
    }

    @JsonProperty("restDeliveryCloseTime")
    public void setRestDeliveryCloseTime(String restDeliveryCloseTime) {
        this.restDeliveryCloseTime = restDeliveryCloseTime;
    }

    public WorkingDay withRestDeliveryCloseTime(String restDeliveryCloseTime) {
        this.restDeliveryCloseTime = restDeliveryCloseTime;
        return this;
    }

    @JsonProperty("restWorkStatus")
    public String getRestWorkStatus() {
        return restWorkStatus;
    }

    @JsonProperty("restWorkStatus")
    public void setRestWorkStatus(String restWorkStatus) {
        this.restWorkStatus = restWorkStatus;
    }

    @JsonProperty("restRecessStatus")
    public String getRestRecessStatus() {
        return restRecessStatus;
    }

    @JsonProperty("restRecessStatus")
    public void setRestRecessStatus(String restRecessStatus) {
        this.restRecessStatus = restRecessStatus;
    }

    @JsonProperty("recessStatus")
    public String getRecessStatus() {
        return recessStatus;
    }

    @JsonProperty("recessStatus")
    public void setRecessStatus(String recessStatus) {
        this.recessStatus = recessStatus;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WorkingDay)) {
            return false;
        }
        WorkingDay rhs = ((WorkingDay) other);
        return new EqualsBuilder().append(restWorkDays, rhs.restWorkDays).append(restOpenTime, rhs.restOpenTime)
                .append(restCloseTime, rhs.restCloseTime).append(restDeliveryOpenTime, rhs.restDeliveryOpenTime)
                .append(restDeliveryCloseTime, rhs.restDeliveryCloseTime).append(restWorkStatus, rhs.restWorkStatus)
                .append(restRecessStatus, rhs.restRecessStatus).append(recessStatus, rhs.recessStatus).isEquals();
    }
}