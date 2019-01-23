package exchange.sellOrderRepositoryFile;

import exchange.sellOrderPack.User;
import exchange.sellOrderRepositoryAPI.UserRepoAPI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFile implements UserRepoAPI {

    String filename="users.bin";
    public void AddUser(User user) throws IOException, ClassNotFoundException {
        List<User> allUsers=GetUsers();
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(int i=0; i<allUsers.size(); i++) {
            oos.writeObject(allUsers.get(i));
        }
        oos.writeObject(user);
        oos.close();

    }

    public User GetUser(int ID) throws  IOException,ClassNotFoundException{
        List<User> orders=GetUsers();
        for(int i=0; i<orders.size(); i++) {
            if(orders.get(i).getID()==ID) {
                return orders.get(i);
            }
        }
        return null;
    }

    public List<User> GetUsers() throws IOException, ClassNotFoundException {
        List<User> orders=new ArrayList<User>();
        FileInputStream fileIn = new FileInputStream(filename);

        ObjectInputStream in = new ObjectInputStream(fileIn);
        while (true) {
            try {
                User obj = (User) in.readObject();
                orders.add(obj);
            }
            catch (EOFException e) {
                break;
            }
        }

        return orders;
    }
}
