package org.supermarket.core;

import org.supermarket.core.inputs.ReadDataFromCsv;
import org.supermarket.domain.Basket;
import org.supermarket.domain.Item;
import org.supermarket.domain.ItemDetails;
import org.supermarket.domain.Promotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Supermarket {

    private static final Logger LOGGER = Logger.getLogger(Supermarket.class.getName());

    public static float superMarketProcess(String itemsFilePath, String promotionsFilePath, String basketFilePath) {
        try {
            List<Item> items = ReadDataFromCsv.readItems(itemsFilePath);
            List<Promotion> promotions = ReadDataFromCsv.readPromotions(promotionsFilePath);
            List<ItemDetails> basketItems = ReadDataFromCsv.readBasket(basketFilePath);
            addItemsDataToBasket(basketItems, items);
            Map<String, Promotion> promotionsMap = getMappedPromotions(promotions);
            IPricer pricer = new Pricer();
            IWeightPricer weightPricer = new WeightPricer();
            Checkout checkout = new Checkout(pricer, weightPricer, promotionsMap);
            return checkout.getTotalPrice(new Basket(basketItems));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred {0}", e.getMessage());
            return 0;
        }
    }

    public static void addItemsDataToBasket(List<ItemDetails> basketItems, List<Item> items) {
        Map<String, Item> itemsMap = items.stream().collect(Collectors.toMap(Item::getName, Function.identity()));
        basketItems.forEach(itemDetails -> {
            Item itemData = itemsMap.get(itemDetails.getName());
            itemDetails.setPrice(itemData.getPrice());
            itemDetails.setWeight(itemData.getWeight());
            itemDetails.setPromotionName(itemData.getPromotionName());
            itemDetails.setUnit(itemData.getUnit());
        });
    }

    public static Map<String, Promotion> getMappedPromotions(List<Promotion> promotions) {
        if (promotions != null && !promotions.isEmpty())
            return promotions.stream().collect(Collectors.toMap(Promotion::getName, Function.identity()));
        else return new HashMap<>();
    }

    public static void main(String[] args) {
        try {
            String itemsFilePath = "src/main/resources/items.csv";
            String promotionsFilePath = "src/main/resources/promotions.csv";
            String basketFilePath = "src/main/resources/basket.csv";
            float result = superMarketProcess(itemsFilePath, promotionsFilePath, basketFilePath);
            LOGGER.log(Level.INFO, "Total price of this basket is {0}", result);


        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred {0}", e.getMessage());
        }
    }
}
