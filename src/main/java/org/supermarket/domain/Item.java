package org.supermarket.domain;

import org.apache.commons.lang3.StringUtils;

public class Item {
    private String name;
    private float price;
    private String promotionName;
    private float weight;
    private String unit;

    public Item(String name, float price) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Item name should not be null, empty or whitespace");
        this.name = name;
        this.price = price;
    }

    public Item(String name, float price, String promotionName) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Item name should not be null, empty or whitespace");
        this.name = name;
        this.price = price;
        this.promotionName = promotionName;
    }

    public Item(String name, float price, String promotionName, float weight, String unit) {
        this.name = name;
        this.price = price;
        this.promotionName = promotionName;
        this.weight = weight;
        this.unit = unit;
    }

    public Item(String name, float price, float weight, String unit) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public float getWeight() {
        return weight;
    }

    public String getUnit() {
        return unit;
    }

}
