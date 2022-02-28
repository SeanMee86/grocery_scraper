package com.seanmeedevworld.sproutsscraper.Repository;

import com.seanmeedevworld.sproutsscraper.Models.AlbertsonsModels.AlbertsonsGroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbertsonsRepository extends JpaRepository<AlbertsonsGroceryItem, Long> {
    List<AlbertsonsGroceryItem> findByCategoryId(long categoryId);
}
