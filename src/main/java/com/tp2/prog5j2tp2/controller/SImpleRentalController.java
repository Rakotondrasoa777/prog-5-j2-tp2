package com.tp2.prog5j2tp2.controller;

import com.tp2.prog5j2tp2.entity.Items;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp2.prog5j2tp2.service.SimpleRentalService;

import java.util.List;

@RestController
public class SImpleRentalController {
    public final SimpleRentalService simpleRentalService;

    public SImpleRentalController(SimpleRentalService simpleRentalService) {
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
}
