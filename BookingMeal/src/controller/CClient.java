package controller;

import java.util.ArrayList;
import model.MClient;

public class CClient {
    
    ArrayList<MClient> client = new ArrayList<MClient>();
    
    public void insertClient(String name, String address, String phone) {
        client.add(new MClient(client.size(), name, address, phone));
    }
    
    public MClient searchClient(int id) {
        for(int i = 0; i < client.size(); i++) {
            if(client.get(i).getId() == id) return client.get(i);
        }
        return null;
    }
    
    public ArrayList<MClient> listClient() {
        return client;
    }
    
   public void deleteClient(MClient client_) {
        client.remove(client_);
    }
    
}
