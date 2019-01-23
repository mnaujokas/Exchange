package exchange.marginSellOrderServicePack;
import exchange.sellOrderPack.SellOrder;

import exchange.sellOrderServicePack.SellOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import exchange.exchangeIntegration.ExchangeAPI;
import java.io.IOException;
import java.util.*;

public class MarginSellOrderService implements SellOrderService {


    @Override
    public double calculateReturn(SellOrder sellOrder){

        return sellOrder.getAmount()*sellOrder.getLeverage()*sellOrder.getPrice();


    }


}
