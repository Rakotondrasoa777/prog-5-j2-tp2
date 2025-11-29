package com.tp2.prog5j2tp2.service;

import com.tp2.prog5j2tp2.entity.CardPayment;
import com.tp2.prog5j2tp2.entity.Client;
import com.tp2.prog5j2tp2.entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceEntity {
    public Client instanceClient() {
        CardPayment card = new CardPayment("CARD-001", "1234-5678-9876", 150.00);

        Client client = new Client("CLIENT-001", "Alice", "Dupont",
                "10 Rue de Paris, Lyon", "0601020304", card);

        return client;
    }

    public List<Items> instanceItemRent() {
        List<Items> itemsList = List.of(
                new Items("ITEM-001", "Chaise", 15.99),
                new Items("ITEM-002", "Table", 49.99),
                new Items("ITEM-003", "Armoire", 89.00),
                new Items("ITEM-004", "Lampe", 12.50)
        );
        return itemsList;
    }
}
