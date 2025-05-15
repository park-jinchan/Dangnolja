package com.example.dangdang.model;

public class Hotel {
    // 1. 필드 선언
    private String name;
    private int imageResId;
    private float rating;
    private int reviewCount;
    private int vacancy;
    private double latitude;
    private double longitude;
    private String distanceText;

    // 2. 생성자(Constructor)
    public Hotel(String name,
                 int imageResId,
                 float rating,
                 int reviewCount,
                 int vacancy,
                 double latitude,
                 double longitude) {
        this.name = name;
        this.imageResId = imageResId;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.vacancy = vacancy;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceText = "";  // 초기값
    }

    // 3. Getter/Setter

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }
    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getVacancy() {
        return vacancy;
    }
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDistanceText() {
        return distanceText;
    }
    public void setDistanceText(String distanceText) {
        this.distanceText = distanceText;
    }
}

