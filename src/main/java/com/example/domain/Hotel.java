package com.example.domain;

/**
 * ホテルを表すドメイン.
 *
 * @author takumi kitamura
 */
public class Hotel {
    /**
     * 固有に割り当てられているid
     */
    private Integer id;

    /**
     * 位置するエリアの名前
     */
    private String areaName;

    /**
     * 名前
     */
    private String hotelName;

    /**
     * 住所
     */
    private String address;

    /**
     * 最寄駅
     */
    private String nearestStation;

    /**
     * 価格
     */
    private Integer price;

    /**
     * 駐車場.
     * 「あり」 または 「なし」のどちらかが入ります。
     */
    private String parking;
}
