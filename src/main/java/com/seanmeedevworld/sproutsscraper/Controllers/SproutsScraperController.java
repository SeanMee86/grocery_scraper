package com.seanmeedevworld.sproutsscraper.Controllers;

import com.seanmeedevworld.sproutsscraper.Models.Store;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SproutsScraperController {

    @GetMapping("/produce")
    public Store getProduce() throws Exception {
        return callSproutsApi("1");
    }

    @GetMapping("/deli")
    public Store getDeli() throws Exception {
        return callSproutsApi("41");
    }

    @GetMapping("/bakery")
    public Store getBakery() throws Exception {
        return callSproutsApi("54");
    }

    @GetMapping("/bulk")
    public Store getBulk() throws Exception {
        return callSproutsApi("103");
    }

    @GetMapping("/dairy")
    public Store getDairy() throws Exception {
        return callSproutsApi("124");
    }

    @GetMapping("/meats")
    public Store getMeats() throws Exception {
        return callSproutsApi("67");
    }

    @GetMapping("/aisles")
    public Store getAisles() throws Exception {
        return callSproutsApi("132");
    }

    @GetMapping("/frozen")
    public Store getFrozen() throws Exception {
        return callSproutsApi("218");
    }

    @GetMapping("/vitamins")
    public Store getVitamins() throws Exception {
        return callSproutsApi("230");
    }

    @GetMapping("/booze")
    public Store getBooze() throws Exception {
        return callSproutsApi("269");
    }

    public Store callSproutsApi(String categoryNumber) {
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
        return response.getBody();
    }
}
