package org.supermarket.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class WeightConverterTest extends TestCase {

    WeightConverter weightConverter = new WeightConverter();

    @Test
    public void test_converter_should_return_right_value() {
        //given
        String unitFrom = "pound";
        String unitTo = "ounce";
        float value = 2;
        //when
        float expectedValue = 32;
        //then
        assertEquals(expectedValue, weightConverter.convertWeight(unitFrom, unitTo, value));

    }

}