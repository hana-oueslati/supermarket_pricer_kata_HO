package org.supermarket.domain;

public class ItemDetails extends Item {
    private String boughtUnit;
    private float boughtQuantity;

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

    public ItemDetails(String name, float price, String promotionName, String unit, float boughtQuantity) {
        super(name, price, promotionName);
        this.boughtUnit = unit;
        this.boughtQuantity = boughtQuantity;
    }

    public String getBoughtUnit() {
        return boughtUnit;
    }

    public void setBoughtUnit(String boughtUnit) {
        this.boughtUnit = boughtUnit;
    }

    public float getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(float boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }
}
