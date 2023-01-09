package org.supermarket.domain;

import com.opencsv.bean.CsvBindByName;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Promotion {
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "price")
    private float price;
    @CsvBindByName(column = "quantity")
    private int quantity;
    @CsvBindByName(column = "quantity Offered")
    private int quantityOffered;
    @CsvBindByName(column = "unit")
    private String unit;
    @CsvBindByName(column = "weight")
    private float weight;
    @CsvBindByName(column = "type")
    private String type;

    public Promotion() {
    }

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

    public String getUnit() {
        return unit;
    }

    public float getWeight() {
        return weight;
    }

    public int getQuantityOffered() {
        return quantityOffered;
    }

    public String getType() {
        return type;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", quantityOffered=" + quantityOffered +
                ", unit='" + unit + '\'' +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }
}
