package com.tp2.prog5j2tp2.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CardPayment {
    private String id;
    private String code;
    private double balance;
}
