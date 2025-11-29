package com.tp2.prog5j2tp2.entity.typeRent;

import com.tp2.prog5j2tp2.entity.Client;
import com.tp2.prog5j2tp2.entity.Items;
import com.tp2.prog5j2tp2.entity.Rental;
import com.tp2.prog5j2tp2.entity.RentalFunctions;
import com.tp2.prog5j2tp2.exception.InsufficientFundsException;

import java.util.List;
import java.util.logging.Logger;

public class SimpleRental extends Rental implements RentalFunctions {
    public SimpleRental(Client client) {
        super(client);
    }

    @Override
    public double calculateTotalPriceOfItemRented() {
        double sum = 0;
        List<Items> listOfItemRented = getListOfItemRented();
        for (Items items : listOfItemRented) {
            sum += items.getPrice();
        }
        return sum;
    }


    @Override
    public List<Items> showAllItemsRentOfClient() {
        return getListOfItemRented();
    }

    @Override
    public void pay() {
        try{
            double balanceClient = getClient().getCardPayment().getBalance();
            double totalPriceItems = calculateTotalPriceOfItemRented();
            double result = balanceClient - totalPriceItems;
            Logger logger = getLogger();

            if(result < 0)
                throw new InsufficientFundsException("Insufficient Balance");

            getClient().getCardPayment().setBalance(result);
            logger.info("Payment Successfull.");
        } catch(InsufficientFundsException e){
            throw e;
        }
    }
}
