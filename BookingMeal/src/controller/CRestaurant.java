package controller;

import java.util.ArrayList;
import model.MClient;
import model.MRestaurant;
import model.MDish;
import model.MReserve;

public class CRestaurant {
    
    ArrayList<MRestaurant> restaurant = new ArrayList<MRestaurant>();
    ArrayList<MClient> client = new ArrayList<MClient>();
    ArrayList<MReserve> reserve = new ArrayList<MReserve>();
    
    public void insertRestaurant(String name, String address, String specialty) {
        MRestaurant restaurant_ = new MRestaurant(restaurant.size(), name, address, new MDish(specialty));
        restaurant.add(restaurant.size(), restaurant_);
        insertDish(restaurant_, new MDish(specialty));
    }
    
    public MRestaurant searchRestaurant(String name) {
        System.out.print(restaurant.size());
        for(MRestaurant restaurant_ : restaurant) {
            if(restaurant_.getName().equals(name)) return restaurant_;
        }
        return null;
    }
    
    public ArrayList<MRestaurant> listRestaurant() {
        return restaurant;
    }
    
    public void deleteRestaurant(MRestaurant restaurant_) {
        restaurant.remove(restaurant_);
    }
    
    public void insertDish(MRestaurant restaurant_, MDish dish) {
        restaurant.get(restaurant.indexOf(restaurant_)).setDish(dish);
    }
    
    public MDish searchDish(MRestaurant restaurant_, String name) {
        System.out.println(restaurant_);
        for(MDish dish_ : restaurant_.getDish()) {
            System.out.println("hey");
            if(dish_.getName().equals(name)) return dish_;
        }
        return null;
    }
    
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
