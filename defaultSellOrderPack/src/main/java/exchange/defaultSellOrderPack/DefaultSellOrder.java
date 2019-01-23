package exchange.defaultSellOrderPack;
import exchange.sellOrderPack.SellOrder;

import java.io.Serializable;
import java.util.Random;


public class DefaultSellOrder implements SellOrder, Serializable {
    private double Amount;
    private int ID;
    private String Currency;
    private double Price;
    private double Leverage=2;

    public DefaultSellOrder(String currency, double amount, double price){
        Currency = currency;
        Amount = amount;
        Price = price;
        ID = genID();
    }
    public double getAmount() {
        return Amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public double getLeverage() {
        return Leverage;
    }

    public int getID() {
        return ID;
    }

    private int genID() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        return n;
    }

    public double getPrice() {
        return Price;
    }
}
