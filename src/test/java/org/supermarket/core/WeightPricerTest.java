package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

public class WeightPricerTest extends TestCase {
    @Test
    public void test_count_basic_weight_total_price_with_same_unit() {
        ItemDetails item = new ItemDetails("suggar", 1.39f, 1, "kilogram", "kilogram", 2);
        WeightPricer weightPricer = new WeightPricer();
        int quantity = 3;
        //when
        float expected = 8.34f;
        //then
        assertEquals(expected, weightPricer.countBasicWeightTotalPrice(item, quantity));
    }

    @Test
    public void test_count_basic_weight_total_price_with_different_unit() {
        ItemDetails item = new ItemDetails("suggar", 1.39f, 1, "kilogram", "pound", 2);
        WeightPricer weightPricer = new WeightPricer();
        int quantity = 3;
        //when
        float expected = 3.78f;
        //then
        assertEquals(expected, weightPricer.countBasicWeightTotalPrice(item, quantity));
    }

    @Test
    public void test_count_promotion_on_weight_total_price_with_same_unit() {
        ItemDetails item = new ItemDetails("suggar", 1.39f, "2-pounds-for-one-dollar", 1, "kilogram", "pound", 2);
        Promotion promotion = new Promotion("2-pounds-for-one-dollar", 1, "pound", 2);
        WeightPricer weightPricer = new WeightPricer();
        int quantity = 2;
        //when
        float expected = 2;
        //then
        assertEquals(expected, weightPricer.countPromotionOnWeightTotalPrice(promotion, item, quantity));
    }

    @Test
    public void test_count_promotion_on_weight_total_price_with_different_unit() {
        ItemDetails item = new ItemDetails("suggar", 1.39f, "2-pounds-for-one-dollar", 1, "kilogram", "kilogram", 2);
        Promotion promotion = new Promotion("2-pounds-for-one-dollar", 1, "pound", 2);

        WeightPricer weightPricer = new WeightPricer();
        int quantity = 1;
        //when
        float expected = 2.25f;
        //then
        assertEquals(expected, weightPricer.countPromotionOnWeightTotalPrice(promotion, item, quantity));
    }
}