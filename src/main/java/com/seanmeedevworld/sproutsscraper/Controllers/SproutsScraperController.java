package com.seanmeedevworld.sproutsscraper.Controllers;

import com.seanmeedevworld.sproutsscraper.Models.Store;
import com.seanmeedevworld.sproutsscraper.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SproutsScraperController {

    @Autowired
    GroceryService groceryService;

    @GetMapping("/produce")
    public Store getProduce() throws Exception {
        return groceryService.callSproutsApi("1");
    }

    @GetMapping("/deli")
    public Store getDeli() throws Exception {
        return groceryService.callSproutsApi("41");
    }

    @GetMapping("/bakery")
    public Store getBakery() throws Exception {
        return groceryService.callSproutsApi("54");
    }

    @GetMapping("/bulk")
    public Store getBulk() throws Exception {
        return groceryService.callSproutsApi("103");
    }

    @GetMapping("/dairy")
    public Store getDairy() throws Exception {
        return groceryService.callSproutsApi("124");
    }

    @GetMapping("/meats")
    public Store getMeats() throws Exception {
        return groceryService.callSproutsApi("67");
    }

    @GetMapping("/aisles")
    public Store getAisles() throws Exception {
        return groceryService.callSproutsApi("132");
    }

    @GetMapping("/frozen")
    public Store getFrozen() throws Exception {
        return groceryService.callSproutsApi("218");
    }

    @GetMapping("/vitamins")
    public Store getVitamins() throws Exception {
        return groceryService.callSproutsApi("230");
    }

    @GetMapping("/booze")
    public Store getBooze() throws Exception {
        return groceryService.callSproutsApi("269");
    }
}
