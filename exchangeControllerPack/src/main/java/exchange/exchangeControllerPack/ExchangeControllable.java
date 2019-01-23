package exchange.exchangeControllerPack;

import org.springframework.boot.CommandLineRunner;

public interface ExchangeControllable {
    void sellBuy();
    void run();
    String GetReturnAmount();
    String GetReturnCurrency();
    String GetAddress();

}
