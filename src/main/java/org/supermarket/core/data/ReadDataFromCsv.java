package org.supermarket.core.data;

import com.opencsv.bean.CsvToBeanBuilder;
import org.supermarket.domain.Item;
import org.supermarket.domain.Promotion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromCsv {

    private ReadDataFromCsv() {
    }

    public static List<Promotion> readPromotions(String fileName){
        try {
            return new CsvToBeanBuilder<Promotion>(new FileReader(fileName))
                    .withType(Promotion.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public static List<Item> readItems(String fileName){
        try {
            return new CsvToBeanBuilder<Item>(new FileReader(fileName))
                    .withType(Item.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }


}
