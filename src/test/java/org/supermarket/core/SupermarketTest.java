package org.supermarket.core;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.Item;
import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

import java.util.*;

public class SupermarketTest extends TestCase {
    @Test
    public void test_supermarket_should_return_the_right_total_from_inputs() {
        //given
        String itemsFilePath = "src/main/resources/items.csv";
        String promotionsFilePath = "src/main/resources/promotions.csv";
        String basketFilePath = "src/main/resources/basket.csv";
        //when
        float result = Supermarket.superMarketProcess(itemsFilePath, promotionsFilePath, basketFilePath);
        float expected = 14.19f;
        //then
        assertEquals(expected, result);
    }

    @Test
    public void test_empty_promotions_file_should_calculate_full_price() {
        //given
        String itemsFilePath = "src/main/resources/items.csv";
        String promotionsFilePath = "";
        String basketFilePath = "src/main/resources/basket.csv";
        //when
        float result = Supermarket.superMarketProcess(itemsFilePath, promotionsFilePath, basketFilePath);
        float expected = 18.911459f;
        //then
        assertEquals(expected, result);
    }

    @Test
    public void test_empty_basket_file_should_return_zero() {
        //given
        String itemsFilePath = "src/main/resources/items.csv";
        String promotionsFilePath = "src/main/resources/promotions.csv";
        String basketFilePath = "";
        //when
        float result = Supermarket.superMarketProcess(itemsFilePath, promotionsFilePath, basketFilePath);
        float expected = 0;
        //then
        assertEquals(expected, result);
    }
    @Test
    public void test_item_details_should_contain_item_data() {
        //given
        List<ItemDetails> itemDetails = new ArrayList<>(Arrays.asList(new ItemDetails("pasta", 0)));
        List<Item> items = new ArrayList<>(Arrays.asList(new Item("pasta", 2.6f,"buy_two_get_one_free")));
        //when
        Supermarket.addItemsDataToBasket(itemDetails,items);
        //then
        assertEquals(itemDetails.get(0).getPrice(),items.get(0).getPrice());
        assertEquals(itemDetails.get(0).getPromotionName(),items.get(0).getPromotionName());
    }

    @Test
    public void test_every_promotion_name_should_have_promotion_as_value() {
        //given
        Promotion promotion = new Promotion("package", "three-for-one-dollar", 1, 3);
        List<Promotion> promotions = new ArrayList<>(Arrays.asList(promotion));
        //when
        Map<String, Promotion> map = Supermarket.getMappedPromotions(promotions);
        //then
        assertEquals(promotion.toString(),map.get("three-for-one-dollar").toString());
    }

}