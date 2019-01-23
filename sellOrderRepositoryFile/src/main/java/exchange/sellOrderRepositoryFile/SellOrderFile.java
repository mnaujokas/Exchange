package exchange.sellOrderRepositoryFile;

import exchange.sellOrderPack.SellOrder;
import exchange.sellOrderRepositoryAPI.SellOrderRepoAPI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SellOrderFile implements SellOrderRepoAPI {
    String filename="sellOrders.bin";
    public void AddOrder(SellOrder sellOrder) throws IOException, ClassNotFoundException {
        List<SellOrder> allOrders=GetOrders();
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(int i=0; i<allOrders.size(); i++) {
            oos.writeObject(allOrders.get(i));
        }
        oos.writeObject(sellOrder);
        oos.close();

    }

    public SellOrder GetOrder(int ID) throws  IOException,ClassNotFoundException{
        List<SellOrder> orders=GetOrders();
        for(int i=0; i<orders.size(); i++) {
            if(orders.get(i).getID()==ID) {
                return orders.get(i);
            }
        }
        return null;
    }

    public List<SellOrder> GetOrders() throws IOException, ClassNotFoundException {
        List<SellOrder> orders=new ArrayList<SellOrder>();
        FileInputStream fileIn = new FileInputStream(filename);

        ObjectInputStream in = new ObjectInputStream(fileIn);
        while (true) {
            try {
                SellOrder obj = (SellOrder) in.readObject();
                orders.add(obj);
            }
            catch (EOFException e) {
                break;
            }
        }

        return orders;
    }
}
