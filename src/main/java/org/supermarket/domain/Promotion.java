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
    private int quantityOffered;
    private String unit;
    private float weight;
    private String type;

    public Promotion(String type, String name, float price, int quantity) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Promotion name should not be null, empty or whitespace");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public Promotion(String name, int quantity,int quantityOffered,String type) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Promotion name should not be null, empty or whitespace");
        this.name = name;
        this.quantityOffered = quantityOffered;
        this.quantity = quantity;
        this.type = type;
    }

    public Promotion(String name, float price, String unit, float weight) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.weight = weight;
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

    public int getQuantityOffered() {
        return quantityOffered;
    }

    public void setQuantityOffered(int quantityOffered) {
        this.quantityOffered = quantityOffered;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
