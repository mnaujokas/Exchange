package exchange.configurations;

import exchange.cryptoSellWithdrawService.CryptoSellWithdrawService;
import exchange.cryptoWithdrawal.CryptoWithdrawalFactory;
import exchange.krakenExchangeAPI.KrakenExchange;
import exchange.defaultSellOrderPack.DefaultSellOrderFactory;
import exchange.exchangeAppController.ExchangeAppController;
import exchange.exchangeControllerPack.ExchangeControllable;
import exchange.fiatSellWithdrawService.FiatSellWithdrawService;
import exchange.fiatWithdrawal.FiatWithdrawalFactory;
import exchange.limitSellOrderFacadePack.LimitSellFacade;
import exchange.marginSellOrderServicePack.MarginSellOrderService;
import exchange.marketSellOrderFacadePack.MarketSellFacade;
import exchange.normalSellOrderServicePack.NormalSellOrderService;
import exchange.premiumSellOrderPack.PremiumSellOrderFactory;
import exchange.sellOrderFacadePack.OrderSellable;
import exchange.sellOrderPack.SellOrderFactory;
import exchange.sellOrderRepositoryAPI.SellOrderRepoAPI;
import exchange.sellOrderRepositoryAPI.UserRepoAPI;
import exchange.sellOrderRepositoryAPI.WithdrawalRepoAPI;
import exchange.sellOrderRepositoryFile.SellOrderFile;
import exchange.sellOrderRepositoryFile.UserFile;
import exchange.sellOrderRepositoryFile.WithdrawalFile;
import exchange.sellOrderServicePack.SellOrderService;
import exchange.sellWithdrawlService.SellWithdrawService;
import exchange.withdrawalPack.WithdrawalFactory;
import exchange.exchangeIntegration.ExchangeAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfiguration {



    @Bean
    public OrderSellable orderSellable(){
        return new LimitSellFacade();
    }

    @Bean
    public ExchangeControllable exchangeControllable(){
        return new ExchangeAppController();
    }

    @Bean
    public SellOrderService sellOrderService(){
        return new NormalSellOrderService();
    }

    @Bean
    public SellOrderFactory sellOrderFactory(){return new PremiumSellOrderFactory();
    }

    @Bean
    public SellOrderRepoAPI sellOrderRepoAPI() {return new SellOrderFile();}

    @Bean
    public SellWithdrawService sellWithdraw(){return new CryptoSellWithdrawService();}

    @Bean
    public WithdrawalFactory withdrawalFactory(){return new FiatWithdrawalFactory();}

    @Bean
    public WithdrawalRepoAPI withdrawalRepoAPI(){ return new WithdrawalFile();}

    @Bean
    public ExchangeAPI exchangeAPI(){
        return new KrakenExchange();
    }

    @Bean
    public UserRepoAPI userRepoAPI(){return new UserFile(); }

    @Bean(name="cryptoWithdrawalFactory")
    public WithdrawalFactory cryptoWithdrawalFactory(){
        return new CryptoWithdrawalFactory();
    }

}
