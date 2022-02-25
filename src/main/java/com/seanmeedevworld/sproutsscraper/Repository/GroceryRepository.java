package com.seanmeedevworld.sproutsscraper.Repository;

import com.seanmeedevworld.sproutsscraper.Models.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
    List<Grocery> findByCategoryId(long categoryId);
}
