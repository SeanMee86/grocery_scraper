package com.seanmeedevworld.sproutsscraper.Controllers;

import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import com.seanmeedevworld.sproutsscraper.Service.SproutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprouts")
public class SproutsScraperController {

    @Autowired
    SproutsService sproutsService;

    @GetMapping("/")
    public ResponseEntity<List<GroceryItem>> getAllGroceries() throws Exception {
        return sproutsService.getAllGroceries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GroceryItem>> getGroceriesById(@PathVariable String id) throws Exception {
        return sproutsService.getGroceryByCategory(Long.parseLong(id));
    }
}
