package org.supermarket.core;

import org.supermarket.domain.Basket;

public class Checkout {


    public float getTotalPrice(Basket basket) {
        if (basket == null)
            throw new IllegalArgumentException("Basket should not be null");
        final float[] totalPrice = {0};
        basket.getItems().forEach(it -> totalPrice[0] += it.getPrice());
        return totalPrice[0];
    }
}
