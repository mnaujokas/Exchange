package exchange.controllerOrder;

import exchange.configurations.AppConfiguration;
import exchange.exchangeControllerPack.ExchangeControllable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Import;


@Import(AppConfiguration.class)
public class ControllerOrder implements CommandLineRunner {

    @Autowired
    ExchangeControllable exchangeControllable;
    @Override
    public void run(String... args) {
        exchangeControllable.run();
    }
}
