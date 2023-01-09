package org.supermarket.utils;

import java.util.HashMap;
import java.util.Map;

public class LCRConstants {

    static final String POUND_UNIT = "pound";
    static final String KILO_UNIT = "kilogram";
    static final String OUNCE_UNIT = "ounce";
    static final String GRAM_UNIT = "gram";
    static final Map<String, Map<String, Float>> WEIGHT_MAP = new HashMap<>();
    static final Map<String, Float> KILO_WEIGHT = new HashMap<>();
    static final Map<String, Float> POUND_WEIGHT = new HashMap<>();
    static final Map<String, Float> OUNCE_WEIGHT = new HashMap<>();
    static final Map<String, Float> GRAM_WEIGHT = new HashMap<>();

    static {
        KILO_WEIGHT.put(POUND_UNIT, 2.2046f);
        KILO_WEIGHT.put(OUNCE_UNIT, 35.274f);
        KILO_WEIGHT.put(GRAM_UNIT, 1000f);
        POUND_WEIGHT.put(KILO_UNIT, 0.4535f);
        POUND_WEIGHT.put(OUNCE_UNIT, 16f);
        POUND_WEIGHT.put(GRAM_UNIT, 453.592f);
        OUNCE_WEIGHT.put(KILO_UNIT, 0.0283f);
        OUNCE_WEIGHT.put(POUND_UNIT, 0.0625f);
        OUNCE_WEIGHT.put(GRAM_UNIT, 28.3495f);
        GRAM_WEIGHT.put(POUND_UNIT, 0.0022f);
        GRAM_WEIGHT.put(OUNCE_UNIT, 0.0352f);
        GRAM_WEIGHT.put(KILO_UNIT, 0.001f);
        WEIGHT_MAP.put(KILO_UNIT, KILO_WEIGHT);
        WEIGHT_MAP.put(POUND_UNIT, POUND_WEIGHT);
        WEIGHT_MAP.put(OUNCE_UNIT, OUNCE_WEIGHT);
        WEIGHT_MAP.put(GRAM_UNIT, GRAM_WEIGHT);
    }

    private LCRConstants() {
        throw new IllegalStateException("Utility class");
    }

}
