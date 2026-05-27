package com.example.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 * ホテルのフォーム.
 *
 * @author takumi kitamura
 */
public class HotelForm {

    @Min(value = 0, message = "値は0以上を入力してください")
    @Max(value = 300000, message = "値は300000以下を入力してください")
    @Digits(integer = 9, fraction = 0, message = "値は整数を入力してください")
    private String price;

    public Integer getIntPrice() {
        if (this.price == null || this.price.isEmpty()) {
            return null;
        }
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
