package com.tp2.prog5j2tp2.service;

import com.tp2.prog5j2tp2.entity.Items;
import com.tp2.prog5j2tp2.entity.typeRent.SimpleRental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleRentalService {
    InstanceEntity instanceEntity = new InstanceEntity();
    SimpleRental simpleRental = new SimpleRental(instanceEntity.instanceClient());

    public List<Items> showAllItemsOfClient() {
        simpleRental.rent(instanceEntity.instanceItemRent());
        return simpleRental.showAllItemsRentOfClient();
    }

    public void addItemRented() {
        simpleRental.rent(instanceEntity.instanceItemRent());
    }

    public void payRental() {
        simpleRental.pay();
    }
}
