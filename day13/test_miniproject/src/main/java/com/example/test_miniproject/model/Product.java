package com.example.test_miniproject.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Product {
    private int id;
    private String name;
    private String description;
    private String thumbnail;
    private int price;
    private double rating;
    private int priceDiscount;

}