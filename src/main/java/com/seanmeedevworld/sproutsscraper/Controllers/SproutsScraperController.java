package com.seanmeedevworld.sproutsscraper.Controllers;

import com.seanmeedevworld.sproutsscraper.Models.Grocery;
import com.seanmeedevworld.sproutsscraper.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sprouts")
public class SproutsScraperController {

    @Autowired
    GroceryService groceryService;

    @GetMapping("/produce")
    public ResponseEntity<List<Grocery>> getProduce() throws Exception {
        return groceryService.getGroceryByCategory(1);
    }

    @GetMapping("/deli")
    public ResponseEntity<List<Grocery>> getDeli() throws Exception {
        return groceryService.getGroceryByCategory(41);
    }

    @GetMapping("/bakery")
    public ResponseEntity<List<Grocery>> getBakery() throws Exception {
        return groceryService.getGroceryByCategory(54);
    }

    @GetMapping("/bulk")
    public ResponseEntity<List<Grocery>> getBulk() throws Exception {
        return groceryService.getGroceryByCategory(103);
    }

    @GetMapping("/dairy")
    public ResponseEntity<List<Grocery>> getDairy() throws Exception {
        return groceryService.getGroceryByCategory(124);
    }

    @GetMapping("/meats")
    public ResponseEntity<List<Grocery>> getMeats() throws Exception {
        return groceryService.getGroceryByCategory(67);
    }

    @GetMapping("/aisles")
    public ResponseEntity<List<Grocery>> getAisles() throws Exception {
        return groceryService.getGroceryByCategory(132);
    }

    @GetMapping("/frozen")
    public ResponseEntity<List<Grocery>> getFrozen() throws Exception {
        return groceryService.getGroceryByCategory(218);
    }

    @GetMapping("/vitamins")
    public ResponseEntity<List<Grocery>> getVitamins() throws Exception {
        return groceryService.getGroceryByCategory(230);
    }

    @GetMapping("/alcohol")
    public ResponseEntity<List<Grocery>> getAlcohol() throws Exception {
        return groceryService.getGroceryByCategory(269);
    }
}
