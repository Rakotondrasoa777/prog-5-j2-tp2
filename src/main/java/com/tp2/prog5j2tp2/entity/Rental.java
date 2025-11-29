package com.tp2.prog5j2tp2.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Rental {
    private Client client;
    private List<Items> listOfItemRented =  new ArrayList<>();
    private boolean isPaid = false;
    private final Logger logger = Logger.getLogger(Rental.class.getName());

    public Rental(Client client) {
        this.client = client;
    }

    public void rent(Items item)
    {
        boolean added = listOfItemRented.add(item);

        if (added) {
            logger.info("Item add susccefully : " + item);
        } else {
            logger.warning("Faile to add item : " + item);
        }
    }

    public void rent(List<Items> listOfItem)
    {
        boolean addedAny = listOfItemRented.addAll(listOfItem);

        if (addedAny) {
            logger.info(listOfItem.size() + "Items added susccedely.");
        } else {
            logger.warning("Failed (Probably List empty)");
        }
    }

    void pay()
    {

    }

    public abstract double calculateTotalPriceOfItemRented();
}
