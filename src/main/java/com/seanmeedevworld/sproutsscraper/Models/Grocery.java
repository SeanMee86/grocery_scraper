package com.seanmeedevworld.sproutsscraper.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grocery {
    private double base_price;
    private String name;
    private Category[] categories;
}
