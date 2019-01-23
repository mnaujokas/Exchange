package exchange.limitSellOrderFacadePack;
import exchange.exchangeIntegration.ExchangeAPI;
import exchange.sellOrderFacadePack.OrderSellable;
import exchange.sellOrderPack.SellOrder;
import exchange.sellOrderPack.SellOrderFactory;
import exchange.sellOrderPack.User;
import exchange.sellOrderRepositoryAPI.SellOrderRepoAPI;
import exchange.sellOrderRepositoryAPI.UserRepoAPI;
import exchange.sellOrderRepositoryAPI.WithdrawalRepoAPI;
import exchange.sellOrderServicePack.SellOrderService;
import exchange.sellWithdrawlService.SellWithdrawService;
import exchange.withdrawalPack.Withdrawal;
import exchange.withdrawalPack.WithdrawalFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LimitSellFacade implements OrderSellable{

    @Autowired
    SellOrderService sellOrderService;

    @Autowired
    SellWithdrawService sellWithdrawService;


    @Autowired
    private SellOrderFactory sellOrderFactory;

    @Autowired
    private SellOrderRepoAPI sellOrderRepoAPI;

    @Autowired
    ExchangeAPI exchangeAPI;


    @Autowired
    WithdrawalFactory withdrawalFactory;

    @Autowired
    WithdrawalRepoAPI withdrawalRepoAPI;

    @Autowired
    UserRepoAPI userRepoAPI;

    @Qualifier("cryptoWithdrawalFactory")
    @Autowired
    WithdrawalFactory cryptoWithdrawalFactory;


    @Override
    public int placeSellOrder(String amount, String currency, String forCurrency, String price, String userID) {
        double data = Double.parseDouble(amount);
        double Price = Double.parseDouble(price);
        int UserID = Integer.parseInt(userID);

        int result = addOrder(currency, data, Price);
        return result;
    }

    @Override
    public double getReturn(int orderID){

        try {SellOrder sellOrder = sellOrderRepoAPI.GetOrder(orderID);
            return sellOrderService.calculateReturn(sellOrder);
        }
        catch (Exception e){}
        return 0;
    }

    @Override
    public boolean validateAddress(String address) {
        return sellWithdrawService.validateAddress(address);
    }

    @Override
    public boolean createWithdrawal(String address, double amount, String currency, int orderID) {
        if(validateAddress(address)){
            return createWithdrawalRepo(address, amount, currency, orderID);
        }
        return false;
    }
    @Override
    public double getFee(int orderID){
        return getFeeRepo(orderID);
    }



    public int addOrder(String currency, double amount, double price) {

        SellOrder sellOrder = sellOrderFactory.createSellOrder(currency, amount, price);


        try {sellOrderRepoAPI.AddOrder(sellOrder);
        }
        catch (IOException e){System.out.println("vienas");}
        catch (ClassNotFoundException f){System.out.println("du");}



        return sellOrder.getID();
    }
    public List<String> getOrders() {
        try {List<SellOrder> data = sellOrderRepoAPI.GetOrders();
            List<String> orders = new ArrayList<String>();
            for(int i=0; i<data.size(); i++) {
                String line = "ID: "+ data.get(i).getID()+" Valiuta: "+ data.get(i).getCurrency() + " Kiekis: " + data.get(i).getAmount() +" Vieneto kaina:"+ data.get(i).getPrice() + " Leverage: " + data.get(i).getLeverage();
                orders.add(line);

            }
            return orders;
        }
        catch (Exception e){return null;}

    }

    @Override
    public double getLimit(String userID) {
        User user;
        int ID = Integer.parseInt(userID);

        try {user = userRepoAPI.GetUser(ID);
            return user.getSpendingLimit();
        }
        catch (Exception e){
            try {
                user = sellOrderFactory.createUser(userID);
                userRepoAPI.AddUser(user);
                return user.getSpendingLimit();
            }
            catch(Exception r){return 0;}
        }


    }


    public boolean createWithdrawalRepo(String address, double amount, String currency, int orderID) {


        Withdrawal withdrawal;

        withdrawal = withdrawalFactory.createWithdrawal(address, amount, currency, orderID);

        try {
            withdrawalRepoAPI.AddWithdrawal(withdrawal);
            return true;
        }
        catch (Exception e){System.out.println("neveikia withdrawlai2");}
        return false;
    }

    public double getFeeRepo(int orderID) {
        try {Withdrawal withdrawal = withdrawalRepoAPI.GetWithdrawal(orderID);
            return withdrawal.getAmount()*withdrawal.getFee();
        }

        catch (Exception e){System.out.println("neveikia withdrawlai");}
        return 0;
    }



}
