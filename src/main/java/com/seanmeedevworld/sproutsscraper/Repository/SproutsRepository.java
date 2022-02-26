package com.seanmeedevworld.sproutsscraper.Repository;

import com.seanmeedevworld.sproutsscraper.SproutsModels.SproutsGroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SproutsRepository extends JpaRepository<SproutsGroceryItem, Long> {
    List<SproutsGroceryItem> findByCategoryId(long categoryId);
}
