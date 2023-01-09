package org.supermarket.domain;

import java.util.List;

public class Basket {
    private List<ItemDetails> items;

    public Basket(List<ItemDetails> items) {
        this.items = items;
    }

    public List<ItemDetails> getItems() {
        return items;
    }

    public void addItems(ItemDetails item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }


}
