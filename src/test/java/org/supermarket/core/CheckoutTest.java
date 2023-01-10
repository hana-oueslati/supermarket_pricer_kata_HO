package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.core.pricing.IPricer;
import org.supermarket.core.pricing.IWeightPricer;
import org.supermarket.core.pricing.Pricer;
import org.supermarket.core.pricing.WeightPricer;
import org.supermarket.domain.Basket;
import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public void test_empty_basket_should_return_zero() {
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
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 2.6f),
                new ItemDetails("water", 1.8f))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("package", "three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("package", "two-for-two-dollars", 2, 2));
        }};
        checkout = new Checkout(pricer, weightPricer, promotions);
        //when
        float requiredTotal = 4.3999996f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));
    }

    @Test
    public void test_basket_total_price_count_with_package_promotion() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 1.6f, "two-for-two-dollars"),
                new ItemDetails("pasta", 1.6f, "two-for-two-dollars"), new ItemDetails("water", 1.8f))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("package", "three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("package", "two-for-two-dollars", 2, 2));
        }};
        checkout = new Checkout(pricer, weightPricer, promotions);
        //when
        float requiredTotal = 3.8f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));

    }

    @Test
    public void test_should_not_apply_promotion_because_quantity_is_less_then_required() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 1.6f, "two-for-two-dollars"),
                new ItemDetails("water", 1.8f))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("package", "three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("package", "two-for-two-dollars", 2, 2));
        }};
        checkout = new Checkout(pricer, weightPricer, promotions);
        //when
        float requiredTotal = 3.4f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));

    }

    @Test
    public void test_basket_price_with_different_promotion_types() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 1.6f, "two-for-two-dollars"),
                new ItemDetails("pasta", 1.6f, "two-for-two-dollars"),
                new ItemDetails("water", 1.8f, "buy-2-get-1-free"),
                new ItemDetails("water", 1.8f, "buy-2-get-1-free"),
                new ItemDetails("water", 1.8f, "buy-2-get-1-free"),
                new ItemDetails("water", 1.8f, "buy-2-get-1-free"))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("package", "three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("package", "two-for-two-dollars", 2, 2));
            put("buy-2-get-1-free", new Promotion("buy-2-get-1-free", 2, 1, "offer"));
        }};
        checkout = new Checkout(pricer, weightPricer, promotions);
        //when
        float requiredTotal = 7.3999996f;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));
    }

    @Test
    public void test_basket_price_with_weight_and_number_promotion_types() {
        //given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 1.6f, "two-for-two-dollars"),
                new ItemDetails("pasta", 1.6f, "two-for-two-dollars"),
                new ItemDetails("sugar", 1.39f, "2-pounds-for-one-dollar", 1, "kilogram", "pound", 2))));
        Map<String, Promotion> promotions = new HashMap<String, Promotion>() {{
            put("three-for-one-dollar", new Promotion("package", "three-for-one-dollar", 1, 3));
            put("two-for-two-dollars", new Promotion("package", "two-for-two-dollars", 2, 2));
            put("buy-2-get-1-free", new Promotion("buy-2-get-1-free", 2, 1, "offer"));
            put("2-pounds-for-one-dollar", new Promotion("2-pounds-for-one-dollar", 1, "pound", 2));
        }};
        checkout = new Checkout(pricer, weightPricer, promotions);
        //when
        float requiredTotal = 3;

        //then
        assertEquals(requiredTotal, checkout.getTotalPrice(basket));
    }

}