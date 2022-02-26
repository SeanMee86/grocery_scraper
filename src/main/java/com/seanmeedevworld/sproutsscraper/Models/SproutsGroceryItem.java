package com.seanmeedevworld.sproutsscraper.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sprouts")
public class SproutsGroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "price")
    private double base_price;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private String size_string;
    @Column(name = "brand")
    private String brand_name;
    @Column(name = "category_id")
    private long categoryId;
}
