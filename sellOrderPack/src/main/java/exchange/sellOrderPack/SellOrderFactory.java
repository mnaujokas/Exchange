package exchange.sellOrderPack;

public interface SellOrderFactory {
    SellOrder createSellOrder(String currency, double amount, double price);
    User createUser(String userID);
}
