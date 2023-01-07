package org.supermarket.domain;

import org.apache.commons.lang3.StringUtils;

public class Item {
    private String name;
    private float price;

    public Item(String name, float price) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Item name should not be null, empty or whitespace");
        else
            this.name = name;
        this.price = price;
    }
}
