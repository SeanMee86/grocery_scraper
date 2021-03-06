package com.seanmeedevworld.sproutsscraper.Service;

import com.seanmeedevworld.sproutsscraper.Models.SproutsGroceryItem;
import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import com.seanmeedevworld.sproutsscraper.Models.Store;
import com.seanmeedevworld.sproutsscraper.Repository.SproutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SproutsService implements GroceryService {

    @Autowired
    SproutsRepository sproutsRepository;

    public void crawl(String categoryNumber) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("cookie", "__stripe_mid=897ee8ba-fe41-4ed7-8d40-d88950b52cd82f706e; __stripe_sid=3a751511-8550-4563-9143-ff6f84cc125225a42f; _dd_s=rum=1&id=e70856c2-f015-4dc7-8292-0759fab07f01&created=1645479608367&expire=1645480576034; session-sprouts=.eJwtzEFvgjAABeD_0rMxbXUo3BbApURqTGZFLoSWqoVaGQWcXfbfJdkO7_LlvfcDinMn7RUE51JbOQNFK7tbaaTpQdB3wyRWWqvupujvjTQgAPKZXPmHUDuVkIMjiKrEn0-IBGbPKU5gPXLtt3lIvNRdUOrEYhc1j23418mwbkh9_6bR-yL9JJjWsSW3TcOPeqgyqsX_lhtmefhQp-PbyI3u-YI5UrdQGKanr_aU7dWujjGNDpC6BlHH_Dmx-2q8Md_fREmo8gNbtsWawD10q_zr4rZLuCrjdbqFVwFmYLCyK1QFAjQ5wp6Hfl_cDFun.FPWYgA.IZUnp5AXUJCL2SWYxMk746EHQw4");
        HttpEntity<Store> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Store> response = restTemplate.exchange(
                "https://shop.sprouts.com/api/v2/store_products?category_id="+categoryNumber+"&limit=999",
                HttpMethod.GET,
                requestEntity,
                Store.class
        );
        ArrayList<String> meatsArray = new ArrayList<>(Arrays.asList("68", "76", "87", "92", "81", "92", "95", "100"));
        List<SproutsGroceryItem> sproutsGroceryItemList = Objects.requireNonNull(response.getBody()).getItems();
        sproutsGroceryItemList.forEach(item -> {
            if(meatsArray.contains(categoryNumber)){
                item.setCategoryId(67);
            } else {
                item.setCategoryId(Long.parseLong(categoryNumber));
            }
        });
        sproutsRepository.saveAll(sproutsGroceryItemList);
    }

    public void clearTable() {
        sproutsRepository.deleteAll();
    }

    public void setTable() {
        System.out.println("Deli Call");
        crawl("41");
        System.out.println("Bakery Call");
        crawl("54");
        System.out.println("Bulk Call");
        crawl("103");
        System.out.println("Produce Call");
        crawl("1");
        System.out.println("Dairy Call");
        crawl("124");
        System.out.println("Meats Call");
        crawl("68");
        crawl("76");
        crawl("87");
        crawl("92");
        crawl("81");
        crawl("94");
        crawl("95");
        crawl("100");
        System.out.println("Grocery Aisles Call");
        crawl("132");
        System.out.println("Frozen Call");
        crawl("218");
        System.out.println("Vitamins & Body Care Call");
        crawl("230");
        System.out.println("Beer & Wine Call");
        crawl("269");
    }

    public ResponseEntity<List<GroceryItem>> getGroceryByCategory(long id) {
        List<SproutsGroceryItem> groceries = new ArrayList<>(sproutsRepository.findByCategoryId(id));
        List<GroceryItem> groceryItemList = new ArrayList<>();
        groceries.forEach(grocery -> groceryItemList.add(new GroceryItem(grocery)));
        return new ResponseEntity<>(groceryItemList, HttpStatus.OK);
    }
}
