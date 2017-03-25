package view;

import controller.CRestaurant;
import model.MRestaurant;
import model.MDish;
import java.util.Scanner;

public class VRestaurant {
    
    CRestaurant restaurant = new CRestaurant();
    
    public VRestaurant() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir Restaurante");
            System.out.println("2 - Procurar Restaurante");
            System.out.println("3 - Listar Restaurante");
            System.out.println("4 - Apagar Restaurante");
            System.out.println("5 - Inserir pratos a restaurante");
            System.out.println("6 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertRestaurantView();
                    break;
                case 2 :
                    searchRestaurantView();
                    break;
                case 3 :
                    listRestaurantView();
                    break;
                case 4 :
                    deleteRestaurantView();
                    break;
                case 5 :
                    insertDishView();
                    break;
                case 6 :
                    break;
                default:
                    break;
            }
        } while(opc != 6);
    }
    
    void insertRestaurantView() { 
        String name;
        String address;
        String specialty;
        
        System.out.println("Inserir Restaurante");
        System.out.print("Nome         : ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Morada       : ");
        address = new Scanner(System.in).nextLine();
        System.out.print("Especialidade: ");
        specialty = new Scanner(System.in).nextLine();
        
        restaurant.insertRestaurant(name, address, specialty);
    }
    
    void searchRestaurantView() {
        String name;
        
        System.out.println("Procurar Restaurante");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        MRestaurant restaurant_ = restaurant.searchRestaurant(name);

        System.out.println("Id           : " + restaurant_.getId());
        System.out.println("Nome         : " + restaurant_.getName());
        System.out.println("Morada       : " + restaurant_.getAddress());
        System.out.println("Especialidade: " + restaurant_.getSpecialty().getName());
        System.out.println("\tPratos:");
        for(MDish mdish_ : restaurant_.getDish()) {
            System.out.println("\t- " + mdish_.getName());
        }
    }
    
    void listRestaurantView() {
        System.out.println("Listar Restaurante");
        
        for(MRestaurant restaurant_ : restaurant.listRestaurant()) {
            System.out.println("Id           : " + restaurant_.getId());
            System.out.println("Nome         : " + restaurant_.getName());
            System.out.println("Morada       : " + restaurant_.getAddress());
            System.out.println("Especialidade: " + restaurant_.getSpecialty().getName());
            System.out.println("\tPratos:");
            for(MDish mdish_ : restaurant_.getDish()) {
                System.out.println("\t- " + mdish_.getName());
            }
        }
    }
    
    void deleteRestaurantView() {
        String name;
        
        System.out.println("Apagar Restaurante");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        restaurant.deleteRestaurant(restaurant.searchRestaurant(name));
    }
    
    void insertDishView() {
        String name;
        String dish;
        
        System.out.println("Inserir Prato");
        System.out.print("Nome Restaurante: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Nome Prato      : ");
        dish = new Scanner(System.in).nextLine();
        
        restaurant.insertDish(restaurant.searchRestaurant(name), new MDish(dish));
    }
    
}
