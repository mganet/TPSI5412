package controller;

import java.util.ArrayList;
import java.util.Date;
import model.MClient;
import model.MDish;
import model.MReserve;
import model.MRestaurant;

public class CReserve {
    
    ArrayList<MReserve> reserve = new ArrayList<MReserve>();
    
    public void insertReserve(MClient client, MRestaurant restaurant, String date, MDish dish) {
        reserve.add(new MReserve(client, restaurant, date, dish));
    }
    
    public MReserve searchReserve(String date, String name) {
        for(int i = 0; i < reserve.size(); i++) {
            if(reserve.get(i).getDate() == date && reserve.get(i).getClient().getName() == name) return reserve.get(i);
        }
        return null;
    }
    
    public ArrayList<MReserve> listReserve() {
        return reserve;
    }
    
    public void deleteReserve(MReserve reserve_) {
        reserve.remove(reserve_);
    }
    
}
