package org.example;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        OnlineCart_Service onlineCartService = new OnlineCart_Service();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n save (s), update (u), delete (d), retrieve (r), quit (q):");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("q")) {
                break;
            }

            if (response.equalsIgnoreCase("r")) {
                onlineCartService.displayItems();
            } else if (response.equalsIgnoreCase("s")) {
                onlineCartService.saveItem();
            } else if (response.equalsIgnoreCase("u")) {
                onlineCartService.updateItem();
            } else if (response.equalsIgnoreCase("d")) {
                onlineCartService.deleteItem();
            } else {
                System.out.println("Please enter a valid option.");
            }
        }
    }
}
