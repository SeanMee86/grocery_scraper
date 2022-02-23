package com.seanmeedevworld.sproutsscraper.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sprouts")
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "price")
    private double base_price;
    @Column(name = "name")
    private String name;
    @Column(name = "size_string")
    private String size_string;
    @Column(name = "brand_name")
    private String brand_name;
//    @Column(name = "categories")
//    private Category[] categories;
}
