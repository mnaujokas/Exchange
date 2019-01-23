package exchange.sellOrderRepositoryFile;

import exchange.sellOrderRepositoryAPI.WithdrawalRepoAPI;
import exchange.withdrawalPack.Withdrawal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WithdrawalFile implements WithdrawalRepoAPI {


    String filename="withdrawals.bin";
    public void AddWithdrawal(Withdrawal Withdrawal) throws IOException, ClassNotFoundException {
        List<Withdrawal> allWithdrawals=GetWithdrawals();
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(int i=0; i<allWithdrawals.size(); i++) {
            oos.writeObject(allWithdrawals.get(i));
        }
        oos.writeObject(Withdrawal);
        oos.close();

    }

    public Withdrawal GetWithdrawal(int ID) throws  IOException,ClassNotFoundException{
        List<Withdrawal> Withdrawals=GetWithdrawals();
        for(int i=0; i<Withdrawals.size(); i++) {
            if(Withdrawals.get(i).getID()==ID) {
                return Withdrawals.get(i);
            }
        }
        return null;
    }

    public List<Withdrawal> GetWithdrawals() throws IOException, ClassNotFoundException {
        List<Withdrawal> Withdrawals=new ArrayList<Withdrawal>();
        FileInputStream fileIn = new FileInputStream(filename);

        ObjectInputStream in = new ObjectInputStream(fileIn);
        while (true) {
            try {
                Withdrawal obj = (Withdrawal) in.readObject();
                Withdrawals.add(obj);
            }
            catch (EOFException e) {
                break;
            }
        }

        return Withdrawals;
    }
}
