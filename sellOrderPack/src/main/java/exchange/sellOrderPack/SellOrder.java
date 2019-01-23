package exchange.sellOrderPack;

public interface SellOrder {
    double getAmount();
    String getCurrency();
    double getLeverage();
    double getPrice();
    int getID();
}
