package com.tp2.prog5j2tp2.controller;

import com.tp2.prog5j2tp2.entity.Items;
import com.tp2.prog5j2tp2.service.PremiumRentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PremiumRentalController {
    private final PremiumRentalService premiumRentalService;

    public PremiumRentalController(PremiumRentalService premiumRentalService) {
        this.premiumRentalService = premiumRentalService;
    }

    @GetMapping("/premiumrental/items")
    public List<Items> getItemsOfCLient() {
        return premiumRentalService.showAllItemsOfClient();
    }

    @PostMapping("/premiumrental/items/add")
    public void addItemToCLient(@RequestBody Items itemToAdd) {
        premiumRentalService.addItemRented(itemToAdd);
    }

    @PostMapping("/premiumrental/pay")
    public void pay() {
        premiumRentalService.payRental();
    }
}
