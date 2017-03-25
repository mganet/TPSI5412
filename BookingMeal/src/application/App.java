package application;

import controller.CClient;
import controller.CReserve;
import controller.CRestaurant;
import view.*;

public class App {

    public CRestaurant restaurant = new CRestaurant();
    public CReserve reserve = new CReserve();
    public CClient client = new CClient();
    
    public static void main(String[] args) {
        
        new VRestaurant();
        new VClient();
        new VReserve();
    }
    
}
