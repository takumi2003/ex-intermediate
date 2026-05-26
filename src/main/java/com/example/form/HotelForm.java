package com.example.form;

public class HotelForm {
    private String price;

    public Integer getIntPrice() {
        return Integer.parseInt(price);
    }

    @Override
    public String toString() {
        return "HotelForm{" +
                "price='" + price + '\'' +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
