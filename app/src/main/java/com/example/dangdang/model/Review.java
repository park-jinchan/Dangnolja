package com.example.dangdang.model;

public class Review {
    private String customerName;
    private float rating;
    private String comment;

    public Review(String customerName, float rating, String comment) {
        this.customerName = customerName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}