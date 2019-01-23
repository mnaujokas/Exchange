package exchange.withdrawalPack;

public interface WithdrawalFactory {
    Withdrawal createWithdrawal(String Address, double amount, String Currency, int ID);
}
