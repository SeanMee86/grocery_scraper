package com.seanmeedevworld.sproutsscraper.Controllers;

import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import com.seanmeedevworld.sproutsscraper.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class MainScraperController {

    @Autowired
    GroceryService groceryService;

    @GetMapping("/produce")
    public ResponseEntity<List<GroceryItem>> getProduce() throws Exception {
        return groceryService.getGroceryByCategory(1);
    }

    @GetMapping("/deli")
    public ResponseEntity<List<GroceryItem>> getDeli() throws Exception {
        return groceryService.getGroceryByCategory(41);
    }

    @GetMapping("/bakery")
    public ResponseEntity<List<GroceryItem>> getBakery() throws Exception {
        return groceryService.getGroceryByCategory(54);
    }

    @GetMapping("/bulk")
    public ResponseEntity<List<GroceryItem>> getBulk() throws Exception {
        return groceryService.getGroceryByCategory(103);
    }

    @GetMapping("/dairy")
    public ResponseEntity<List<GroceryItem>> getDairy() throws Exception {
        return groceryService.getGroceryByCategory(124);
    }

    @GetMapping("/meats")
    public ResponseEntity<List<GroceryItem>> getMeats() throws Exception {
        return groceryService.getGroceryByCategory(67);
    }

    @GetMapping("/aisles")
    public ResponseEntity<List<GroceryItem>> getAisles() throws Exception {
        return groceryService.getGroceryByCategory(132);
    }

    @GetMapping("/frozen")
    public ResponseEntity<List<GroceryItem>> getFrozen() throws Exception {
        return groceryService.getGroceryByCategory(218);
    }

    @GetMapping("/vitamins")
    public ResponseEntity<List<GroceryItem>> getVitamins() throws Exception {
        return groceryService.getGroceryByCategory(230);
    }

    @GetMapping("/alcohol")
    public ResponseEntity<List<GroceryItem>> getAlcohol() throws Exception {
        return groceryService.getGroceryByCategory(269);
    }
}
