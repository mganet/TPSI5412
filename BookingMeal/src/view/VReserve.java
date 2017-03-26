package view;


import controller.CRestaurant;
import java.util.Scanner;
import model.MClient;
import model.MDish;
import model.MReserve;
import model.MRestaurant;

public class VReserve {
    
    CRestaurant restaurant = new CRestaurant();
    
    public VReserve() {
        int opc = 0;
        
        do {
            System.out.println("1  - Inserir reserva");
            System.out.println("2  - Procurar reserva");
            System.out.println("3  - Listar reserva");
            System.out.println("4  - Apagar reserva");
            System.out.println("5  - Inserir Restaurante");
            System.out.println("6  - Procurar Restaurante");
            System.out.println("7  - Listar Restaurante");
            System.out.println("8  - Apagar Restaurante");
            System.out.println("9  - Inserir pratos a restaurante");
            System.out.println("10 - Inserir cliente");
            System.out.println("11 - Procurar cliente");
            System.out.println("12 - Listar cliente");
            System.out.println("13 - Apagar cliente");
            System.out.println("14 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertReserveView();
                    break;
                case 2 :
                    searchReserveView();
                    break;
                case 3 :
                    listReserveView();
                    break;
                case 4 :
                    deleteReserveView();
                    break;
                case 5 :
                    insertRestaurantView();
                    break;
                case 6 :
                    searchRestaurantView();
                    break;
                case 7 :
                    listRestaurantView();
                    break;
                case 8 :
                    deleteRestaurantView();
                    break;
                case 9 :
                    insertDishView();
                    break;
                case 10 :
                    insertClientView();
                    break;
                case 11 :
                    searchClientView();
                    break;
                case 12 :
                    listClientView();
                    break;
                case 13 :
                    deleteClientView();
                    break;
                case 14 :
                    break;
                default:
                    break;
            }
        } while(opc != 14);
    }
    
    void insertReserveView() {
        
        int id;
        String nameRestaurant;
        String date;
        String nameDish;
        
        System.out.println("Inserir reservas");
        System.out.print("Id cliente: ");
        id = new Scanner(System.in).nextInt();
        System.out.print("Nome restaurante: ");
        nameRestaurant = new Scanner(System.in).nextLine();
        System.out.print("Data: ");
        date = new Scanner(System.in).nextLine();
        System.out.print("Prato: ");
        nameDish = new Scanner(System.in).nextLine();
        
        MClient client_ = restaurant.searchClient(id);
        MRestaurant restaurant_ = restaurant.searchRestaurant(nameRestaurant);
        System.out.print(restaurant_.getName());
        MDish dish_ = restaurant.searchDish(restaurant_, date);
        
        restaurant.insertReserve(client_, restaurant_, date, dish_);
    }
    
    void searchReserveView() {
        System.out.println("Procurar reservas");
        System.out.print("Cliente: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Data   : ");
        
        MReserve reserve_ = restaurant.searchReserve(new Scanner(System.in).nextLine(), name);
        
        System.out.println("Cliente    : " + reserve_.getClient().getName());
        System.out.println("Restaurante: " + reserve_.getRestaurant().getName());
        System.out.println("Data       : " + reserve_.getDate());
        System.out.println("Prato      : " + reserve_.getDish().getName());
    }
    
    void listReserveView() {
        System.out.println("Listar reservas");
        
        for(MReserve reserve_ : restaurant.listReserve()) {
            System.out.println("Cliente    : " + reserve_.getClient().getName());
            System.out.println("Restaurante: " + reserve_.getRestaurant().getName());
            System.out.println("Data       : " + reserve_.getDate());
            System.out.println("Prato      : " + reserve_.getDish().getName());
        }
    }
    
    void deleteReserveView() {
        System.out.println("Apagar reservas");
        
        System.out.print("Cliente: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Data   : ");
        
        restaurant.deleteReserve(restaurant.searchReserve(new Scanner(System.in).nextLine(), name));  
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
    
    void insertClientView() {
        String name;
        String address;
        String phone;
        
        System.out.println("Inserir cliente");
        System.out.print("Nome     : ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Morada   : ");
        address = new Scanner(System.in).nextLine();
        System.out.print("Telemovel: ");
        phone = new Scanner(System.in).nextLine();
        
        restaurant.insertClient(name, address, phone);
    }
    
    void searchClientView() {
        int id;
        
        System.out.println("Procurar cliente");
        System.out.print("Id: ");
        MClient client_ = restaurant.searchClient(new Scanner(System.in).nextInt());
        
        System.out.println("Id       : " + client_.getId());
        System.out.println("Nome     : " + client_.getName());
        System.out.println("Morada   : " + client_.getAddress());
        System.out.println("Telemovel: " + client_.getPhone());
    }
    
    void listClientView() {
        System.out.println("Lista cliente");
        for(MClient client_ : restaurant.listClient()) {
            System.out.println("Id       : " + client_.getId());
            System.out.println("Nome     : " + client_.getName());
            System.out.println("Morada   : " + client_.getAddress());
            System.out.println("Telemovel: " + client_.getPhone());
        }
    }
    
    void deleteClientView() {
        int id;
        
        System.out.println("Apagar cliente");
        System.out.print("Id: ");
        restaurant.deleteClient(restaurant.searchClient(new Scanner(System.in).nextInt()));
    }
    
}
