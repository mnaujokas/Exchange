package exchange.sellOrderFacadePack;

import java.util.List;

public interface OrderSellable {
    int placeSellOrder(String amount, String currency, String forCurrency, String price, String userID);

    double getReturn(int OrderID);

    boolean validateAddress(String address);

    boolean createWithdrawal(String address, double amount, String currency, int orderID);

    double getFee(int orderID);

    List<String> getOrders();

    double getLimit(String userID);
}
