package controller;

import java.util.ArrayList;
import model.MRestaurant;
import model.MDish;

public class CRestaurant {
    
    ArrayList<MRestaurant> restaurant = new ArrayList<MRestaurant>();
    
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

}
