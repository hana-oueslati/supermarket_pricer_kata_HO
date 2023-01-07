package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.Basket;
import org.supermarket.domain.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutTest extends TestCase {

    Checkout checkout;

    @Test
    public void test_empty_basket_shoud_return_zero() {
        //given
        checkout = new Checkout();
        Basket basket = new Basket(new ArrayList<>());
        //when
        float requiredTotal = 0;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));
    }

    @Test
    public void test_basic_basket_total_price_count() {
        //given
        checkout = new Checkout();
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new Item("pasta", 2.6f),
                new Item("water", 1.8f))));
        //when
        float requiredTotal = 4.3999996f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));

    }

}