package org.supermarket.core;

import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;
import org.supermarket.utils.WeightConverter;

public class WeightPricer implements IWeightPricer {

    public float countBasicWeightTotalPrice(ItemDetails item, int qty) {
        float totalBought = item.getBoughtQuantity() * qty;
        return countRestOfWeightTotalPrice(item, totalBought);
    }

    public float countRestOfWeightTotalPrice(ItemDetails item, float weight) {
        float weightToPay = 0;
        if (item.getBoughtUnit().equals(item.getUnit())) {
            weightToPay = weight / item.getWeight();
        } else {
            WeightConverter weightConverter = new WeightConverter();
            float convertedBought = weightConverter.convertWeight(item.getBoughtUnit(), item.getUnit(), weight);
            weightToPay = convertedBought / item.getWeight();
        }
        return weightToPay * item.getPrice();
    }


    public float countPromotionOnWeightTotalPrice(Promotion promotion, ItemDetails item, int qty) {
        float totalBought = item.getBoughtQuantity() * qty;
        if (!item.getBoughtUnit().equals(promotion.getUnit())) {
            WeightConverter weightConverter = new WeightConverter();
            totalBought = weightConverter.convertWeight(item.getBoughtUnit(), promotion.getUnit(), totalBought);
        }
        float weightForReduction = promotion.getWeight();
        float reductionValue = promotion.getPrice();
        int timesReductionApplied = (int) totalBought / (int) weightForReduction;
        float fullPriceProductsWeight = totalBought - timesReductionApplied * weightForReduction;
        float reducedPrice = timesReductionApplied * reductionValue;
        float unreducedPrice = countRestOfWeightTotalPrice(item, fullPriceProductsWeight);
        return reducedPrice + unreducedPrice;

    }

}
