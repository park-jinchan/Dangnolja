package com.example.dangdang.model;

public class Reservation {
    private String customerName;
    private String date;
    private String time;
    private int partySize;

    public Reservation(String customerName, String date, String time, int partySize) {
        this.customerName = customerName;
        this.date = date;
        this.time = time;
        this.partySize = partySize;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public int getPartySize() {
        return partySize;
    }
    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
}