package view;

import model.MClient;
import controller.CClient;
import java.util.Scanner;

public class VClient {

    CClient client = new CClient();
    
    public VClient() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir cliente");
            System.out.println("2 - Procurar cliente");
            System.out.println("3 - Listar cliente");
            System.out.println("4 - Apagar cliente");
            System.out.println("5 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertClientView();
                    break;
                case 2 :
                    searchClientView();
                    break;
                case 3 :
                    listClientView();
                    break;
                case 4 :
                    deleteClientView();
                    break;
                case 5 :
                    break;
                default:
                    break;
            }
        } while(opc != 5);
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
        
        client.insertClient(name, address, phone);
    }
    
    void searchClientView() {
        int id;
        
        System.out.println("Procurar cliente");
        System.out.print("Id: ");
        MClient client_ = client.searchClient(new Scanner(System.in).nextInt());
        
        System.out.println("Id       : " + client_.getId());
        System.out.println("Nome     : " + client_.getName());
        System.out.println("Morada   : " + client_.getAddress());
        System.out.println("Telemovel: " + client_.getPhone());
    }
    
    void listClientView() {
        System.out.println("Lista cliente");
        for(MClient client_ : client.listClient()) {
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
        client.deleteClient(client.searchClient(new Scanner(System.in).nextInt()));
    }
    
}
