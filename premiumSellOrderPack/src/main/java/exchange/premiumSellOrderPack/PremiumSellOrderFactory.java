package exchange.premiumSellOrderPack;

import exchange.sellOrderPack.SellOrder;
import exchange.sellOrderPack.SellOrderFactory;
import exchange.sellOrderPack.User;

public class PremiumSellOrderFactory implements SellOrderFactory {
    public SellOrder createSellOrder(String currency, double amount, double price) {
        return new PremiumSellOrder(currency, amount, price);
    }
    public User createUser(String userID) {
        return new PremiumUser(userID);
    }
}
