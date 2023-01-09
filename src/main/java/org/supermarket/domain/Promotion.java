package org.supermarket.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Promotion {
    private String name;
    private float price;
    private int quantity;
    private String unit;
    private float weight;


    public Promotion(String name, float price, int quantity) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Promotion name should not be null, empty or whitespace");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Map<String, Promotion> getMappedPromotions(List<Promotion> promotions) {
        if (promotions != null && !promotions.isEmpty())
            return promotions.stream().collect(Collectors.toMap(Promotion::getName, Function.identity()));
        else return new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
