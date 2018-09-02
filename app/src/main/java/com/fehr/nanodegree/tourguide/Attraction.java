package com.fehr.nanodegree.tourguide;

public class Attraction {
    private String mAttractionName;
    private String mAttractionWorkingHours;
    private String mAttractionAddress;
    private int mImageResourceId;
    private String mAtrractionLocation;

    public Attraction(String name, String workingHours, String address, int imageId, String location) {
        mAttractionName = name;
        mAttractionWorkingHours = workingHours;
        mAttractionAddress = address;
        mImageResourceId = imageId;
        mAtrractionLocation = location;
    }

    public String getAttractionName() {
        return mAttractionName;
    }

    public String getAttractionWorkingHours() {
        return mAttractionWorkingHours;
    }

    public String getLocation() {
        return mAtrractionLocation;
    }

    public String getAttractionAddress() {
        return mAttractionAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
