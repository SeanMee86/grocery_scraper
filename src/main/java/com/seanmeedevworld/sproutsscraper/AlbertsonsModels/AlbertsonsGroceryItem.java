package com.seanmeedevworld.sproutsscraper.AlbertsonsModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "albertsons")
public class AlbertsonsGroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "price")
    private double price;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private String size;
    @Column(name = "brand")
    private String brand_name;
    @Column(name = "category_id")
    private long categoryId;
}
