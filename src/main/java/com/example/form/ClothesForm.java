package com.example.form;

import jakarta.validation.constraints.NotBlank;

/**
 * 衣類の入力を受け取るフォーム/
 *
 * @author takumi kitamura
 */
public class ClothesForm {
    /**
     * id.
     */
    private String id;
    /**
     * カテゴリ.
     */
    private String category;
    /**
     * ジャンル.
     */
    private String genre;
    /**
     * 性別.
     * 0:女性 1:男性。
     */
    @NotBlank(message = "選択肢をどれか1つ選んでください。")
    private String gender;
    /**
     * 色.
     */
    private String color;
    /**
     * 価格.
     */
    private String price;
    /**
     * サイズ.
     */
    private String size;

    public Integer getIntegerId() {
        return Integer.parseInt(id);
    }

    public Integer getIntegerGender() {
        return Integer.parseInt(gender);
    }

    public Integer getIntegerPrice() {
        return Integer.parseInt(price);
    }

    @Override
    public String toString() {
        return "ClothesForm{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", genre='" + genre + '\'' +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
