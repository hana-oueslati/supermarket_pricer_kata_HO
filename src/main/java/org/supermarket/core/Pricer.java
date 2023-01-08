package org.supermarket.core;

import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

import java.util.Map;

public class Pricer implements IPricer {
    public Pricer() {
    }

    public float countBasicTotalPrice(Item item, int quantity) {
        return 0;
    }

    public float countPackagePromotionTotalPrice(Map<String, Promotion> promotionsDictionary, Item item, int quantity) {
        return 0;
    }
}
