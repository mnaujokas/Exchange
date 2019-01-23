package exchange.defaultSellOrderPack;

import exchange.sellOrderPack.SellOrder;
import exchange.sellOrderPack.SellOrderFactory;
import exchange.sellOrderPack.User;

public class DefaultSellOrderFactory implements SellOrderFactory {
    public SellOrder createSellOrder(String currency, double amount, double price) {
        return new DefaultSellOrder(currency, amount, price);
    }

    public User createUser(String userID) {
        return new DefaultUser(userID);
    }

}
