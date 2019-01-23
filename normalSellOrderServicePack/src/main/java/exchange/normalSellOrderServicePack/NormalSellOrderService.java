package exchange.normalSellOrderServicePack;

import exchange.sellOrderPack.SellOrder;
import exchange.sellOrderServicePack.SellOrderService;

public class NormalSellOrderService implements SellOrderService {
    public double calculateReturn(SellOrder sellOrder) {
        return sellOrder.getAmount()*sellOrder.getPrice();
    }
}
