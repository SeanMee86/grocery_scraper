package com.seanmeedevworld.sproutsscraper.Models;

import com.seanmeedevworld.sproutsscraper.SproutsModels.SproutsGroceryItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GroceryItem {
    private long id;
    private double price;
    private String name;
    private String size;
    private String brand;
    private long categoryId;

    public GroceryItem(SproutsGroceryItem sproutsGroceryItem) {
        this.id = sproutsGroceryItem.getId();
        this.price = sproutsGroceryItem.getBase_price();
        this.name = sproutsGroceryItem.getName();
        this.size = sproutsGroceryItem.getSize_string();
        this.brand = sproutsGroceryItem.getBrand_name();
        this.categoryId = sproutsGroceryItem.getCategoryId();
    }
}
