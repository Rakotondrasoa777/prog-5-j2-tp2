package com.tp2.prog5j2tp2.service;

import com.tp2.prog5j2tp2.entity.Items;
import com.tp2.prog5j2tp2.entity.typeRent.PremiumRental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumRentalService {
    InstanceEntity instanceEntity = new InstanceEntity();
    PremiumRental premiumRental = new PremiumRental(instanceEntity.instanceClient(), 0.1);

    public List<Items> showAllItemsOfClient() {
        return premiumRental.showAllItemsRentOfClient();
    }

    public void addItemRented(Items itemToAdd) {
        premiumRental.rent(itemToAdd);
    }

    public void payRental() {
        premiumRental.pay();
    }
}
