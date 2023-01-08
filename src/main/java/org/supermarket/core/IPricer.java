package org.supermarket.core;

import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

import java.util.Map;

public interface IPricer {
    float countBasicTotalPrice(Item item, int qty);

    float countPackagePromotionTotalPrice(Map<String, Promotion> promotionMap, Item item, int qty);
}
