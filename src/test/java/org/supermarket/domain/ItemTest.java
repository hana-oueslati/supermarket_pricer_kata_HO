package org.supermarket.domain;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ItemTest extends TestCase {

    @Test
    public void test_create_item_with_null_name_throws_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Item(null, 12.6f));
        assertEquals("Item name should not be null, empty or whitespace", exception.getMessage());
    }

    @Test
    public void test_create_item_with_empty_name_throws_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Item("", 12.6f));
        assertEquals("Item name should not be null, empty or whitespace", exception.getMessage());
    }

    @Test
    public void test_create_item_with_whitespace_name_throws_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Item(" ", 12.6f));
        assertEquals("Item name should not be null, empty or whitespace", exception.getMessage());
    }
}