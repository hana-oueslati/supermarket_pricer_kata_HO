package org.supermarket.domain;

import com.opencsv.bean.CsvBindByName;
import org.apache.commons.lang3.StringUtils;

public class Item {
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "price")
    private float price;
    @CsvBindByName(column = "promotion name")
    private String promotionName;
    @CsvBindByName(column = "weight")
    private float weight;
    @CsvBindByName(column = "unit")
    private String unit;

    public Item() {
    }

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

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", promotionName='" + promotionName + '\'' +
                ", weight=" + weight +
                ", unit='" + unit + '\'' +
                '}';
    }
}
