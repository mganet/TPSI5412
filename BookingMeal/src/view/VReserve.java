package view;

import controller.CClient;
import controller.CReserve;
import controller.CRestaurant;
import java.util.Scanner;
import model.MClient;
import model.MDish;
import model.MReserve;
import model.MRestaurant;

public class VReserve {
    
    CReserve    reserve     = new CReserve();
    CClient     client      = new CClient();
    CRestaurant restaurant  = new CRestaurant();
    
    public VReserve() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir reserva");
            System.out.println("2 - Procurar reserva");
            System.out.println("3 - Listar reserva");
            System.out.println("4 - Apagar reserva");
            System.out.println("5 - Sair");
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
                    break;
                default:
                    break;
            }
        } while(opc != 5);
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
        
        MClient client_ = client.searchClient(id);
        MRestaurant restaurant_ = restaurant.searchRestaurant(nameRestaurant);
        System.out.print(restaurant_.getName());
        MDish dish_ = restaurant.searchDish(restaurant_, date);
        
        reserve.insertReserve(client_, restaurant_, date, dish_);
    }
    
    void searchReserveView() {
        System.out.println("Procurar reservas");
        System.out.print("Cliente: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Data   : ");
        
        MReserve reserve_ = reserve.searchReserve(new Scanner(System.in).nextLine(), name);
        
        System.out.println("Cliente    : " + reserve_.getClient().getName());
        System.out.println("Restaurante: " + reserve_.getRestaurant().getName());
        System.out.println("Data       : " + reserve_.getDate());
        System.out.println("Prato      : " + reserve_.getDish().getName());
    }
    
    void listReserveView() {
        System.out.println("Listar reservas");
        
        for(MReserve reserve_ : reserve.listReserve()) {
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
        
        reserve.deleteReserve(reserve.searchReserve(new Scanner(System.in).nextLine(), name));  
    }
    
}
