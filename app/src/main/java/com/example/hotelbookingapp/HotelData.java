package com.example.hotelbookingapp;

public class HotelData {

    private String hotelName;
    private String hotelPrice;
    private int hotelImg;

    public HotelData(String hotelName, String hotelPrice, int hotelImg) {
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.hotelImg = hotelImg;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public int getHotelImg() {
        return hotelImg;
    }

    public void setHotelImg(int hotelImg) {
        this.hotelImg = hotelImg;
    }
}
