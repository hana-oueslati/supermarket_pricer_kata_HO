package org.supermarket.core;

import org.supermarket.domain.Basket;
import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Checkout {

    private final IPricer pricer;

    public Checkout(IPricer pricer) {
        this.pricer = pricer;
    }

    public float getTotalPrice(Basket basket, List<Promotion> promotions) {
        if (basket == null)
            throw new IllegalArgumentException("Basket should not be null");
        Map<String, Promotion> promotionsDictionary = Promotion.getMappedPromotions(promotions);
        Map<String, List<Item>> collectedItems = basket.getItems().stream().collect(Collectors.groupingBy(Item::getName));
        final float[] totalPrice = {0};
        for (Map.Entry<String, List<Item>> entry : collectedItems.entrySet()) {
            Item item = entry.getValue().get(0);
            if (!promotionsDictionary.isEmpty() && promotionsDictionary.containsKey(item.getPromotionName())) {
                totalPrice[0] += pricer.countPackagePromotionTotalPrice(promotionsDictionary,item, entry.getValue().size());
            } else
                totalPrice[0] += pricer.countBasicTotalPrice(item, entry.getValue().size());
        }
        return totalPrice[0];
    }
}
