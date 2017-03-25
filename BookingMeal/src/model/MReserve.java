package model;

import java.util.Date;

public class MReserve {
    
    private MClient client;
    private MRestaurant restaurant;
    private String date;
    private MDish dish;

    public MReserve(MClient client, MRestaurant restaurant, String date, MDish dish) {
        this.client = client;
        this.restaurant = restaurant;
        this.date = date;
        this.dish = dish;
    }

    public MDish getDish() {
        return dish;
    }

    public void setDish(MDish dish) {
        this.dish = dish;
    }

    public MClient getClient() {
        return client;
    }

    public void setClient(MClient client) {
        this.client = client;
    }

    public MRestaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(MRestaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
   
}
