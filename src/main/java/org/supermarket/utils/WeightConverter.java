package org.supermarket.utils;

public class WeightConverter {

    public float convertWeight(String unitFrom, String unitTo, float valueToConvert) {
        return valueToConvert * LCRConstants.WEIGHT_MAP.get(unitFrom).get(unitTo);
    }
}
