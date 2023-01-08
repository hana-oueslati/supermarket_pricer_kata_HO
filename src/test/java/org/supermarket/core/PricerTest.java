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
    public void test_should_return_item_total_with_promotion() {
        //given
        Promotion promotion = new Promotion("two-for-two-dollars", 2, 2);
        Item item = new Item("water", 1.6f, "two-for-two-dollars");
        Pricer pricer = new Pricer();
        int quantity = 5;
        //when
        float expected = 5.6f;
        //then
        assertEquals(expected, pricer.countPackagePromotionTotalPrice(promotion, item, quantity));
    }
}