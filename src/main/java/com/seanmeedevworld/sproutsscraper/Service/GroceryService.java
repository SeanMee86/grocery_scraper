package com.seanmeedevworld.sproutsscraper.Service;

import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import org.springframework.http.*;

import java.util.List;

public interface GroceryService {
    void crawl(String categoryId);
    void crawl(String[] categoryIds);
    void clearTable();
    void setTable();
    ResponseEntity<List<GroceryItem>> getGroceryByCategory(long id);
}
