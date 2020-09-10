
package com.example.leaderboad.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class LearnersResponse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hours")
    @Expose
    private int hours;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LearnersResponse() {
    }

    /**
     * 
     * @param country
     * @param hours
     * @param badgeUrl
     * @param name
     */
    public LearnersResponse(String name, int hours, String country, String badgeUrl) {
        super();
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

}
