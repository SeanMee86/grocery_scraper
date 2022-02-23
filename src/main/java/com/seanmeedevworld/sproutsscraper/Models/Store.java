package com.seanmeedevworld.sproutsscraper.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Store {
    private List<Grocery> items;
}
