package com.tp2.prog5j2tp2.controller;

import com.tp2.prog5j2tp2.entity.Items;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tp2.prog5j2tp2.service.SimpleRentalService;

import java.util.List;

@RestController
public class SimpleRentalController {
    public final SimpleRentalService simpleRentalService;

    public SimpleRentalController(SimpleRentalService simpleRentalService) {
        this.simpleRentalService = simpleRentalService;
    }


    @GetMapping("/")
    public String home() {
        return "API is running";
    }

    @GetMapping("/simplerental/items")
    public List<Items> getItemsOfCLient() {
        return simpleRentalService.showAllItemsOfClient();
    }

    @PostMapping("/simplerental/items/add")
    public void addItemToCLient(@RequestBody Items itemToAdd) {
        simpleRentalService.addItemRented(itemToAdd);
    }

    @PostMapping("/simplerental/pay")
    public void pay() {
        simpleRentalService.payRental();
    }
}
