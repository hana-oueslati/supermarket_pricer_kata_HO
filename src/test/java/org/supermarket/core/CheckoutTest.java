package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.Basket;
import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

import java.util.*;

import static org.junit.Assert.assertThrows;

public class CheckoutTest extends TestCase {

    Checkout checkout;
    IPricer pricer = new Pricer();
    IWeightPricer weightPricer = new WeightPricer();

    @Test
    public void test_null_basket_throws_exception() {
        //given
        checkout = new Checkout(pricer, weightPricer);

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> checkout.getTotalPrice(null));
        assertEquals("Basket should not be null", exception.getMessage());

    }

    @Test
    public void test_empty_basket_shoud_return_zero() {
        //given
        checkout = new Checkout(pricer, weightPricer);
        Basket basket = new Basket(new ArrayList<>());

        //when
        float requiredTotal = 0;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));
    }

    @Test
    public void test_basic_basket_total_price_count() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 2.6f), new ItemDetails("water", 1.8f))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("two-for-two-dollars", 2, 2));
        }};
        checkout = new Checkout(pricer, weightPricer,promotions);
        //when
        float requiredTotal = 4.3999996f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));
    }

    @Test
    public void test_basket_total_price_count_with_package_promotion() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 1.6f, "two-for-two-dollars"), new ItemDetails("pasta", 1.6f, "two-for-two-dollars"), new ItemDetails("water", 1.8f))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("two-for-two-dollars", 2, 2));
        }};
        checkout = new Checkout(pricer, weightPricer,promotions);
        //when
        float requiredTotal = 3.8f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));

    }

    @Test
    public void test_should_not_apply_promotion_because_quantity_is_less_then_required() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 1.6f, "two-for-two-dollars"), new ItemDetails("water", 1.8f))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("two-for-two-dollars", 2, 2));
        }};
        checkout = new Checkout(pricer, weightPricer,promotions);
        //when
        float requiredTotal = 3.4f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));

    }

}