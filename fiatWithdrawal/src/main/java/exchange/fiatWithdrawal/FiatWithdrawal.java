package exchange.fiatWithdrawal;

import exchange.withdrawalPack.Withdrawal;

import java.io.Serializable;

public class FiatWithdrawal implements Withdrawal, Serializable {
    private  String Address;
    private double Amount;
    private String Currency;
    private int ID;
    private double Fee=.005;

    public double getFee() {
        return Fee;
    }

    public FiatWithdrawal(String address, double amount, String currency, int id){
        Address = address;
        Amount = amount;
        Currency = currency;
        ID = id;

    }
    public String getAddress() {
        return Address;
    }

    public double getAmount() {
        return Amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public int getID() {
        return ID;
    }
}
