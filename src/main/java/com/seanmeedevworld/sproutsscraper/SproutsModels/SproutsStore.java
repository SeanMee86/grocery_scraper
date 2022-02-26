package com.seanmeedevworld.sproutsscraper.SproutsModels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SproutsStore {
    private List<SproutsGroceryItem> items;
}
