package com.seanmeedevworld.sproutsscraper.Service;

import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import org.springframework.http.*;

import java.util.List;

public interface GroceryService<T> {
    void crawl(String categoryId);
    void crawl(List<String> categoryIds);
    void clearTable();
    void setTable();
    List<GroceryItem> transformGrocery(List<T> groceryList);
    ResponseEntity<List<GroceryItem>> getAllGroceries();
    ResponseEntity<List<GroceryItem>> getGroceryByCategory(long id);
}
