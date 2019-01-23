package exchange.premiumSellOrderPack;

import exchange.sellOrderPack.User;

import java.io.Serializable;

public class PremiumUser implements User, Serializable {
    private int ID;
    private double SpendingLimit=10000;

    public PremiumUser(String userID) {
        ID = Integer.parseInt(userID);
    }

    public int getID() {
        return ID;
    }

    public double getSpendingLimit() {
        return SpendingLimit;
    }
}
