package org.supermarket.core;

import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

public class Pricer implements IPricer {

    public float countBasicTotalPrice(Item item, int quantity) {
        return item.getPrice() * quantity;
    }

    public float countPackagePromotionTotalPrice(Promotion promotion, Item item, int quantity) {
        int quantityForReduction = promotion.getQuantity();
        float reductionValue = promotion.getPrice();
        int fullPriceProductsNumber = quantity % quantityForReduction;
        int timesReductionApplied = quantity / quantityForReduction;
        float reducedPrice = timesReductionApplied * reductionValue;
        float unreducedPrice = fullPriceProductsNumber * item.getPrice();
        return reducedPrice + unreducedPrice;
    }

    public float countOfferPromotionTotalPrice(Promotion promotion, Item item, int quantity) {
        int quantityForOffer = promotion.getQuantity() + promotion.getQuantityOffered();
        int timesOfferApplied = quantity / quantityForOffer;
        int numberOfFreeProducts = timesOfferApplied * promotion.getQuantityOffered();
        int priceToBeCounted = quantity - numberOfFreeProducts;
        return priceToBeCounted * item.getPrice();
    }


}
