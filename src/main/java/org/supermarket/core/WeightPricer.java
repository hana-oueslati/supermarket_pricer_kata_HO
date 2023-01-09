package org.supermarket.core;

import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

public class WeightPricer implements IWeightPricer {

    public float countBasicWeightTotalPrice(ItemDetails item, int qty) {
        return 0f;
    }

    public float countPromotionOnWeightTotalPrice(Promotion promotion, ItemDetails item, int qty) {
        return 0f;
    }
}
