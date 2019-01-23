package exchange.sellOrderRepositoryAPI;

import exchange.withdrawalPack.Withdrawal;

import java.io.IOException;
import java.util.List;

public interface WithdrawalRepoAPI {
    void AddWithdrawal(Withdrawal sellOrder) throws IOException, ClassNotFoundException;
    Withdrawal GetWithdrawal(int ID) throws  IOException,ClassNotFoundException;
    List<Withdrawal> GetWithdrawals() throws IOException, ClassNotFoundException;
}
