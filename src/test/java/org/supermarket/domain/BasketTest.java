package org.supermarket.domain;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BasketTest extends TestCase {

    @Test
    public void test_item_is_added() {
        // given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 2.6f), new ItemDetails("water", 1.8f))));
        ItemDetails beanCan = new ItemDetails("bean can", 4.99f);

        // when
        basket.addItems(beanCan, 2);

        //then
        assertTrue(basket.getItems().contains(beanCan));
    }

    @Test
    public void test_item_quantity_is_correct() {
        // given
        Basket basket = new Basket(new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 2.6f), new ItemDetails("water", 1.8f))));
        ItemDetails beanCan = new ItemDetails("bean can", 4.99f);

        // when
        basket.addItems(beanCan, 2);

        //then
        assertEquals(2, Collections.frequency(basket.getItems(), beanCan));
    }

}