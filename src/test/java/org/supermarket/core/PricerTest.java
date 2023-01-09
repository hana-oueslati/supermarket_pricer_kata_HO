package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

public class PricerTest extends TestCase {
    @Test
    public void test_should_return_basic_item_total() {
        //given
        Item item = new Item("water", 1.6f);
        Pricer pricer = new Pricer();
        int quantity = 3;
        //when
        float expected = 4.8f;
        //then
        assertEquals(expected, pricer.countBasicTotalPrice(item, quantity));

    }

    @Test
    public void test_should_return_item_total_with_package_promotion() {
        //given
        Promotion promotion = new Promotion("package","two-for-two-dollars", 2, 2);
        Item item = new Item("water", 1.6f, "two-for-two-dollars");
        Pricer pricer = new Pricer();
        int quantity = 5;
        //when
        float expected = 5.6f;
        //then
        assertEquals(expected, pricer.countPackagePromotionTotalPrice(promotion, item, quantity));
    }

    @Test
    public void test_should_return_item_total_with_offer_promotion() {
        //given
        Promotion promotion = new Promotion("buy-2-get-1-free", 2, 1,"offer");
        Item item = new Item("water", 1.6f, "buy-2-get-1-free");
        Pricer pricer = new Pricer();
        int quantity = 5;
        //when
        float expected = 6.4f;
        //then
        assertEquals(expected, pricer.countOfferPromotionTotalPrice(promotion, item, quantity));
    }
}