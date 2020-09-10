package com.example.leaderboad.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class SkilliqResponse {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private int score;
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
    public SkilliqResponse() {
    }

    /**
     *
     * @param country
     * @param score
     * @param badgeUrl
     * @param name
     */
    public SkilliqResponse(String name, int score, String country, String badgeUrl) {
        super();
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
