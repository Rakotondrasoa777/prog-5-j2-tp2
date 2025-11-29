package com.tp2.prog5j2tp2.entity.typeRent;

import com.tp2.prog5j2tp2.entity.Client;
import com.tp2.prog5j2tp2.entity.Items;
import com.tp2.prog5j2tp2.entity.Rental;
import com.tp2.prog5j2tp2.entity.RentalFunctions;
import com.tp2.prog5j2tp2.exception.InsufficientFundsException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
@ToString
public class PremiumRental extends Rental implements RentalFunctions {
    private double discountRate;

    public PremiumRental(Client client, double discountRate) {
        super(client);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPriceOfItemRented() {
        List<Items> listOfItemRented = getListOfItemRented();
        double sum = 0;
        for (Items items : listOfItemRented) {
            sum += items.getPrice();
        }

        return sum * (1 - discountRate);
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
