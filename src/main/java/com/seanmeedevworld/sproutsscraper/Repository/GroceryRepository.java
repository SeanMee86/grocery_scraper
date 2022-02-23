package com.seanmeedevworld.sproutsscraper.Repository;

import com.seanmeedevworld.sproutsscraper.Models.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
}
