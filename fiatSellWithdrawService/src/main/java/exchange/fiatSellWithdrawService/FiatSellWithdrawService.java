package exchange.fiatSellWithdrawService;

import exchange.sellWithdrawlService.SellWithdrawService;



public class FiatSellWithdrawService implements SellWithdrawService {



    public boolean validateAddress(String address) {
        String pattern = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";
        return address.matches(pattern);
    }









}
