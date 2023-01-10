package org.supermarket.core.pricing;

import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

public interface IWeightPricer {
    float countBasicWeightTotalPrice(ItemDetails item, int qty);

    float countPromotionOnWeightTotalPrice(Promotion promotion, ItemDetails item, int qty);
}
