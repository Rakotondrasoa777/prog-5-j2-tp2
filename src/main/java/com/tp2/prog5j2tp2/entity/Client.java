package com.tp2.prog5j2tp2.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private  String address;
    private String phoneNumber;
    private CardPayment cardPayment;
}
