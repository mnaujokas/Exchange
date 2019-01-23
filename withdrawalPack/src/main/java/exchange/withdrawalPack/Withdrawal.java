package exchange.withdrawalPack;

public interface Withdrawal {
    String getAddress();
    double getAmount();
    String getCurrency();
    int getID();
    double getFee();
}
