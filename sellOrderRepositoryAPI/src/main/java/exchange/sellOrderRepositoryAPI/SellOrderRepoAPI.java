package exchange.sellOrderRepositoryAPI;

import exchange.sellOrderPack.SellOrder;

import java.io.IOException;
import java.util.List;

public interface SellOrderRepoAPI {
    void AddOrder(SellOrder sellOrder) throws IOException, ClassNotFoundException;
    SellOrder GetOrder(int ID) throws  IOException,ClassNotFoundException;
    List<SellOrder> GetOrders() throws IOException, ClassNotFoundException;
}
