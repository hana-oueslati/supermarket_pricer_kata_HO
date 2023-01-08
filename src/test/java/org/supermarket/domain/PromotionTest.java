package org.supermarket.domain;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class PromotionTest extends TestCase {
    @Test
    public void test_create_promotion_with_null_name_throws_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Promotion(null, 10.6f, 3));
        assertEquals("Promotion name should not be null, empty or whitespace", exception.getMessage());
    }

    @Test
    public void test_create_promotion_with_empty_name_throws_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Promotion("", 10.6f, 5));
        assertEquals("Promotion name should not be null, empty or whitespace", exception.getMessage());
    }

    @Test
    public void test_create_promotion_with_whitespace_name_throws_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Promotion(" ", 10.6f, 2));
        assertEquals("Promotion name should not be null, empty or whitespace", exception.getMessage());
    }

}