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

    public Promotion(String name, float price, int quantity) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Promotion name should not be null, empty or whitespace");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public static Map<String, Promotion> getMappedPromotions(List<Promotion> promotions) {
        if (promotions != null && !promotions.isEmpty())
            return promotions.stream()
                    .collect(Collectors.toMap(Promotion::getName, Function.identity()));
        else
            return new HashMap<>();
    }
}
