package com.seanmeedevworld.sproutsscraper.Service;

import com.seanmeedevworld.sproutsscraper.AlbertsonsModels.AlbertsonsGroceryItem;
import com.seanmeedevworld.sproutsscraper.AlbertsonsModels.AlbertsonsStore;
import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import com.seanmeedevworld.sproutsscraper.Repository.AlbertsonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AlbertsonsService implements GroceryService<AlbertsonsGroceryItem> {

    @Autowired
    AlbertsonsRepository albertsonsRepository;

    public void crawl(String categoryId) {
        System.out.println("Call Category: " + categoryId);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.albertsons.com/abs/pub/xapi/v1/aisles/products?request-id=3243720602970&url=https://www.albertsons.com&pageurl=https://www.albertsons.com&pagename=aisles&rows=200&start=0&search-type=category&category-id="+categoryId+"&storeid=177&featuredsessionid=9790696f-4aa4-4cd1-a7f8-db3aa8217544";
        HttpHeaders headers = new HttpHeaders();
        headers.set("ocp-apim-subscription-key", "e914eec9448c4d5eb672debf5011cf8f");
        HttpEntity<AlbertsonsStore> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AlbertsonsStore> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                AlbertsonsStore.class
        );
        List<AlbertsonsGroceryItem> groceryItems = Arrays.asList(Objects.requireNonNull(response.getBody()).getResponse().getDocs());
        long dbId = Long.parseLong(categoryId.replace("_", ""));
        groceryItems.forEach(albertsonsGroceryItem -> albertsonsGroceryItem.setCategoryId(dbId));
        albertsonsRepository.saveAll(groceryItems);
    }

    public void crawl(List<String> categoryIds) {

        categoryIds.forEach(this::crawl);
    }

    public void clearTable() {
        albertsonsRepository.deleteAll();
    }

    public void setTable() {
        List<String> categoryIdArray = new ArrayList<>(Arrays.asList(
                "1_1_1",
                "1_1_2",
                "1_1_3",
                "1_1_4",
                "1_5_1",
                "1_5_2",
                "1_5_3",
                "1_5_4",
                "1_5_5",
                "1_5_6",
                "1_5_7",
                "1_5_8",
                "1_5_9",
                "1_5_10",
                "1_2_1",
                "1_2_2",
                "1_2_3",
                "1_2_4",
                "1_2_5",
                "1_2_6",
                "1_2_7",
                "1_2_8",
                "1_2_9",
                "1_2_10",
                "1_7_1",
                "1_7_2",
                "1_7_3",
                "1_7_4",
                "1_7_5",
                "1_7_6",
                "1_7_7",
                "1_9_1",
                "1_9_2",
                "1_9_3",
                "1_9_4",
                "1_9_5",
                "1_9_6",
                "1_9_7",
                "1_9_8",
                "1_9_9",
                "1_20_16",
                "1_20_14",
                "1_20_15",
                "1_20_2",
                "1_20_1",
                "1_20_6",
                "1_20_7",
                "1_20_10",
                "1_20_13",
                "1_20_4",
                "1_24_14",
                "1_24_15",
                "1_24_1",
                "1_24_16",
                "1_24_2",
                "1_24_3",
                "1_24_4",
                "1_24_5",
                "1_24_6",
                "1_24_17",
                "1_24_7",
                "1_24_18",
                "1_24_8",
                "1_24_9",
                "1_24_10",
                "1_24_11"
        ));
        crawl(categoryIdArray);
    }

    @Override
    public List<GroceryItem> transformGrocery(List<AlbertsonsGroceryItem> groceryList) {
        List<AlbertsonsGroceryItem> groceries = new ArrayList<>(groceryList);
        List<GroceryItem> groceryItemList = new ArrayList<>();
        groceries.forEach(grocery -> groceryItemList.add(new GroceryItem(grocery)));
        return groceryItemList;
    }

    @Override
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        return null;
    }

    public ResponseEntity<List<GroceryItem>> getGroceryByCategory(long id) {
        return new ResponseEntity<>(transformGrocery(albertsonsRepository.findByCategoryId(id)), HttpStatus.OK);
    }
}
