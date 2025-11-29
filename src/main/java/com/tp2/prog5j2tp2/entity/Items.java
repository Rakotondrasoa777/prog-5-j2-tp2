package com.tp2.prog5j2tp2.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Items{
    private String id;
    private String name;
    private double price;

    public Items(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
