package exchange.mainExchange;
import exchange.controllerOrder.ControllerOrder;
import exchange.limitSellOrderFacadePack.LimitSellFacade;
import exchange.sellOrderPack.SellOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import exchange.exchangeAppController.ExchangeAppController;
import org.springframework.context.annotation.Import;




@SpringBootApplication (scanBasePackages = { "exchange.exchangeAppController" })
public class MainExchange {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ControllerOrder.class).web(false).run(args);
    }

}
