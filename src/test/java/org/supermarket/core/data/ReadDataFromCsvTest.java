package org.supermarket.core.data;

import junit.framework.TestCase;
import org.junit.Test;
import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

import java.io.IOException;
import java.util.List;

public class ReadDataFromCsvTest extends TestCase {
    @Test
    public void test_number_of_promotions_imported_from_file() {
        //given
        String filePath = "src/main/resources/promotions.csv";
        //when
        int expected = 6;
        List<Promotion> promotions = ReadDataFromCsv.readPromotions(filePath);
        //then
        assertEquals(expected,promotions.size());
    }

    @Test
    public void test_the_first_promotions_line_is_imported_with_the_right_data() {
        //given
        String filePath = "src/main/resources/promotions.csv";
        //when
        Promotion promotion = new Promotion("package", "three_for_one_dollar", 1, 3);
        promotion.setUnit("");
        String expected = promotion.toString();
        List<Promotion> promotions = ReadDataFromCsv.readPromotions(filePath);
        //then
        assertEquals(expected,promotions.get(0).toString());
    }

    @Test
    public void test_wrong_promotions_file_returns_empty_list() {
        //given
        String filePath = "promotions.csv";
        //when
        List<Promotion> promotions = ReadDataFromCsv.readPromotions(filePath);
        //then
        assertTrue(promotions.isEmpty());
    }

    @Test
    public void test_number_of_items_imported_from_file() {
        //given
        String filePath = "src/main/resources/items.csv";
        //when
        int expected = 4;
        List<Item> items = ReadDataFromCsv.readItems(filePath);
        //then
        assertEquals(expected,items.size());
    }

    @Test
    public void test_the_first_item_line_is_imported_with_the_right_data() {
        //given
        String filePath = "src/main/resources/items.csv";
        Item item = new Item("pasta", 2.6f,"buy_two_get_one_free");
        item.setUnit("");
        //when
        String expected = item.toString();
        List<Item> items = ReadDataFromCsv.readItems(filePath);
        //then
        assertEquals(expected,items.get(0).toString());
    }

    @Test
    public void test_wrong_items_file_returns_empty_list() {
        //given
        String filePath = "items.csv";
        //when
        List<Item> items = ReadDataFromCsv.readItems(filePath);
        //then
        assertTrue(items.isEmpty());
    }
}