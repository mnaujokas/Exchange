package exchange.exchangeAppController;

import exchange.exchangeControllerPack.ExchangeControllable;
import exchange.sellOrderFacadePack.OrderSellable;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;


public class ExchangeAppController implements ExchangeControllable {

    @Autowired
    private OrderSellable orderSellable;
    private String userID = "0";
    private double limit = 0;


    public void run(){
        String amount, price,address;
        Scanner scanner = new Scanner(System.in);


        if(userID=="0"){
            System.out.println("Įveskite ID");
            userID = scanner.nextLine();
            limit = orderSellable.getLimit(userID);
        }
        System.out.println("Sveiki, ID: "+userID+" Jūsų limitas: "+limit+" \n norite įsigyti(1) ar parduoti(2) valiutos. Peržiūrėti orderius (3) Baigti(4)");
        String choice = scanner.nextLine();
        switch (choice){
            case "1": {
                System.out.println("Pasirinkite pora \n 1. eth/eur \n 2. eth/usd \n 3. btc/eth");

            }
            case "2": {
                System.out.println("Pasirinkite pora \n 1. eth/eur \n 2. eth/usd \n 3. btc/usd");
                String option = scanner.nextLine();
                switch (option){
                    case "1": {sellSequence("eth", "eur");break;}
                    case "2": {sellSequence("eth","usd");break;}
                    case "3": {sellSequence("btc","eth");break;}
                    }
                run();
            }
            case "3":
            {
                List<String> orders = orderSellable.getOrders();
                for(int i=0; i<orders.size(); i++){
                    System.out.println(orders.get(i));
                }
                run();
            }
            case "4":break;

        }


    }

    private void sellSequence(String currency, String forCurrency){
        System.out.println("Pasirinkta pora "+currency+ "/" + forCurrency+ " \n Kiek norite parduoti?");
        String amount, price,address;
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextLine();
        System.out.println("Vieneto kaina?");
        price = scanner.nextLine();
        double x = Double.parseDouble(price);
        double y = Double.parseDouble(amount);
        if(x*y<limit) {
            limit -= x*y;
            int resultID = orderSellable.placeSellOrder(amount, currency, forCurrency, price, userID);
            double total = orderSellable.getReturn(resultID);
            System.out.println("Gausite " + total + forCurrency);
            System.out.println("Įveskite sąskaitą:");
            address = scanner.nextLine();
            boolean resultW = orderSellable.createWithdrawal(address, total, forCurrency, resultID);
            while (!resultW) {
                System.out.println("netinkamas adresas, įveskite naują");
                address = scanner.nextLine();
                resultW = orderSellable.createWithdrawal(address, total, forCurrency, resultID);
            }
            System.out.println("Operacija ID: " + resultID + " uzregistruota. \nĮ saskaitą " + address + " bus pervesta " + total + forCurrency);
            System.out.println("Mokestis " + orderSellable.getFee(resultID) + forCurrency);
        }
        else {
            System.out.println("Per mažas limitas");
        }
    }


    @Override
    public void sellBuy() {

    }

    @Override
    public String GetReturnAmount() {
        return null;
    }

    @Override
    public String GetReturnCurrency() {
        return null;
    }

    @Override
    public String GetAddress() {
        return null;
    }




}
