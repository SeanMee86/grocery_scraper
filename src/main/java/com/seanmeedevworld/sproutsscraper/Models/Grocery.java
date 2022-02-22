package com.seanmeedevworld.sproutsscraper.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grocery {
    private double base_price;
    private String size_string;
    private String brand_name;
    private String name;
    private Category[] categories;
}
