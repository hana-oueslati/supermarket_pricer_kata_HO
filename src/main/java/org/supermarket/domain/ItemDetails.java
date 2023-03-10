package org.supermarket.domain;

import com.opencsv.bean.CsvBindByName;

public class ItemDetails extends Item {
    @CsvBindByName(column = "bought unit")
    private String boughtUnit;
    @CsvBindByName(column = "bought quantity")
    private float boughtQuantity;

    public ItemDetails() {
    }
    public ItemDetails(String name, float price) {
        super(name, price);
    }

    public ItemDetails(String name, float price, String promotion) {
        super(name, price, promotion);
    }

    public ItemDetails(String name, float price, float weight, String unit, String boughtUnit, float boughtQuantity) {
        super(name, price, weight, unit);
        this.boughtUnit = boughtUnit;
        this.boughtQuantity = boughtQuantity;
    }

    public ItemDetails(String name, float price, String promotionName, float weight, String unit, String boughtUnit, float boughtQuantity) {
        super(name, price, promotionName, weight, unit);
        this.boughtUnit = boughtUnit;
        this.boughtQuantity = boughtQuantity;
    }

    public String getBoughtUnit() {
        return boughtUnit;
    }

    public float getBoughtQuantity() {
        return boughtQuantity;
    }


    @Override
    public String toString() {
        return "ItemDetails{" +
                "name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", promotionName='" + super.getPromotionName() + '\'' +
                ", weight=" + super.getWeight() +
                ", unit='" + super.getWeight() + '\'' +
                ", boughtUnit='" + boughtUnit + '\'' +
                ", boughtQuantity=" + boughtQuantity +
                '}';
    }
}
