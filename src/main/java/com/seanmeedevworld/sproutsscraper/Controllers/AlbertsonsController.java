package com.seanmeedevworld.sproutsscraper.Controllers;

import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import com.seanmeedevworld.sproutsscraper.Service.AlbertsonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albertsons")
public class AlbertsonsController {

    @Autowired
    AlbertsonsService albertsonsService;

    @GetMapping("/")
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        return albertsonsService.getAllGroceries();
    }
}
