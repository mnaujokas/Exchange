package exchange.cryptoSellWithdrawService;

import exchange.sellWithdrawlService.SellWithdrawService;



public class CryptoSellWithdrawService implements SellWithdrawService {


    public boolean validateAddress(String address) {
        String pattern = "^0x[A-Za-z0-9]{40}$";
        return address.matches(pattern);
    }



}
