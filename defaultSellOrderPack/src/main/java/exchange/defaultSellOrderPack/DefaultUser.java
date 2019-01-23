package exchange.defaultSellOrderPack;

import exchange.sellOrderPack.User;

import java.io.Serializable;

public class DefaultUser implements User, Serializable {
    private int ID;
    private double SpendingLimit=5000;

    public DefaultUser(String userID) {
        ID = Integer.parseInt(userID);
    }

    public int getID() {
        return ID;
    }

    public double getSpendingLimit() {
        return SpendingLimit;
    }
}
