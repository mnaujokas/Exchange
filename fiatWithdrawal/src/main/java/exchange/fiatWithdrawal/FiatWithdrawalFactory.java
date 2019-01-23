package exchange.fiatWithdrawal;

import exchange.withdrawalPack.Withdrawal;
import exchange.withdrawalPack.WithdrawalFactory;

public class FiatWithdrawalFactory implements WithdrawalFactory {
    public Withdrawal createWithdrawal(String Address, double amount, String currency, int ID) {
        return new FiatWithdrawal(Address, amount, currency, ID);
    }
}
