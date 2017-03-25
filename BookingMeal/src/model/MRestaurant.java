package model;

import java.util.ArrayList;

public class MRestaurant {
    
    private int id;
    private String name;
    private String address;
    private MDish specialty;
    private ArrayList<MDish> dish = new ArrayList<MDish>();

    public MRestaurant(int id, String name, String address, MDish specialty) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MDish getSpecialty() {
        return specialty;
    }

    public void setSpecialty(MDish specialty) {
        this.specialty = specialty;
    }

    public ArrayList<MDish> getDish() {
        return dish;
    }

    public void setDish(MDish dish_) {
        dish.add(dish_);
    }    
    
}
