package com.seanmeedevworld.sproutsscraper.Service;

import com.seanmeedevworld.sproutsscraper.AlbertsonsModels.AlbertsonsGroceryItem;
import com.seanmeedevworld.sproutsscraper.AlbertsonsModels.AlbertsonsStore;
import com.seanmeedevworld.sproutsscraper.Models.GroceryItem;
import com.seanmeedevworld.sproutsscraper.SproutsModels.SproutsStore;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AlbertsonsService implements GroceryService {

    public void crawl(String categoryId) {
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

    }

    public void crawl(String[] categoryIds) {

    }

    public void clearTable() {

    }

    public void setTable() {

    }

    public ResponseEntity<List<GroceryItem>> getGroceryByCategory(long id) {
        return null;
    }
}
