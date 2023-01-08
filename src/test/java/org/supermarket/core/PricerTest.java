package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

import java.util.*;

public class PricerTest extends TestCase {
    @Test
    public void test_should_return_basic_item_total() {
        //given
        Item item = new Item("water",1.6f);
        Pricer pricer = new Pricer();
        int quantity = 3;
        //when
        float expected = 4.8f;
        //then
        assertEquals(expected,pricer.countBasicTotalPrice(item,quantity));

    }

    @Test
    public void test_should_return_item_total_with_promotion() {
        //given
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("two-for-two-dollars", 2, 2));
        }};
        Item item = new Item("water",1.6f,"two-for-two-dollars");
        Pricer pricer = new Pricer();
        int quantity = 5;
        //when
        float expected = 5.6f;
        //then
        assertEquals(expected,pricer.countPackagePromotionTotalPrice(promotions,item,quantity));
    }
}