package org.supermarket.core;

import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;


public interface IPricer {
    float countBasicTotalPrice(Item item, int qty);

    float countPackagePromotionTotalPrice(Promotion promotionMap, Item item, int qty);
}
