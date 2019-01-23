package exchange.cryptoWithdrawal;

import exchange.withdrawalPack.Withdrawal;
import exchange.withdrawalPack.WithdrawalFactory;

public class CryptoWithdrawalFactory implements WithdrawalFactory {
    public Withdrawal createWithdrawal(String Address, double amount, String currency, int ID) {
        return new CryptoWithdrawl(Address, amount, currency, ID);
    }
}
