package com.tp2.prog5j2tp2.service;

import com.tp2.prog5j2tp2.entity.Items;
import com.tp2.prog5j2tp2.entity.typeRent.PremiumRental;

import java.util.List;

public class PremiumRentalService {
    InstanceEntity instanceEntity = new InstanceEntity();
    PremiumRental premiumRental = new PremiumRental(instanceEntity.instanceClient(), 0.1);

    public List<Items> showAllItemsOfClient() {
        return premiumRental.showAllItemsRentOfClient();
    }

    public void addItemRented() {
        premiumRental.rent(instanceEntity.instanceItemRent());
    }

    public void payRental() {
        premiumRental.pay();
    }
}
