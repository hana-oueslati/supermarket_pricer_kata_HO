package org.supermarket.core;

import org.supermarket.domain.Basket;
import org.supermarket.domain.Item;
import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Checkout {

    private final IPricer pricer;
    private final IWeightPricer weightPricer;
    Map<String, Promotion> promotionsDictionary;

    public Checkout(IPricer pricer, IWeightPricer weightPricer) {
        this.pricer = pricer;
        this.weightPricer = weightPricer;
    }

    public Checkout(IPricer pricer, IWeightPricer weightPricer, Map<String, Promotion> promotionsDictionary) {
        this.pricer = pricer;
        this.weightPricer = weightPricer;
        this.promotionsDictionary = promotionsDictionary;
    }


    public float processWeightBasedTotalPrice(ItemDetails item, int count) {
        if (!promotionsDictionary.isEmpty() && promotionsDictionary.containsKey(item.getPromotionName())) {
            return weightPricer.countPromotionOnWeightTotalPrice(promotionsDictionary.get(item.getPromotionName()), item, count);
        } else
            return weightPricer.countBasicWeightTotalPrice(item, count);
    }

    public float processNumberBasedTotalPrice(Item item, int count) {
        if (!promotionsDictionary.isEmpty() && promotionsDictionary.containsKey(item.getPromotionName())) {
            if (promotionsDictionary.get(item.getPromotionName()).getType().equals("package"))
                return pricer.countPackagePromotionTotalPrice(promotionsDictionary.get(item.getPromotionName()), item, count);
            else
                return pricer.countOfferPromotionTotalPrice(promotionsDictionary.get(item.getPromotionName()), item, count);

        } else
            return pricer.countBasicTotalPrice(item, count);
    }

    public float getTotalPrice(Basket basket) {
        if (basket == null) throw new IllegalArgumentException("Basket should not be null");
        Map<String, List<ItemDetails>> collectedItems = basket.getItems().stream().collect(Collectors.groupingBy(Item::getName));
        final float[] totalPrice = {0};
        for (Map.Entry<String, List<ItemDetails>> entry : collectedItems.entrySet()) {
            ItemDetails item = entry.getValue().get(0);
            int count = entry.getValue().size();
            if (item.getUnit() != null)
                totalPrice[0] += processWeightBasedTotalPrice(item, count);
            else {
                totalPrice[0] += processNumberBasedTotalPrice(item, count);
            }

        }
        return totalPrice[0];
    }
}
