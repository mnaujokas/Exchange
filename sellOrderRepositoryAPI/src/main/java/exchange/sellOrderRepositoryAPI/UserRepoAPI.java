package exchange.sellOrderRepositoryAPI;

import exchange.sellOrderPack.User;

import java.io.IOException;
import java.util.List;

public interface UserRepoAPI {
    void AddUser(User user) throws IOException, ClassNotFoundException;
    User GetUser(int ID) throws  IOException,ClassNotFoundException;
    List<User> GetUsers() throws IOException, ClassNotFoundException;
}
