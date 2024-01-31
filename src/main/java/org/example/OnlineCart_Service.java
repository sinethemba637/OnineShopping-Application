package org.example;

import java.util.List;
import java.util.Scanner;

public class   OnlineCart_Service {
    private final OnlineCart_Repository onlineCartRepository;
    private final Scanner scanner;

    public OnlineCart_Service() {
        this.onlineCartRepository = new ItemSold();
        this.scanner = new Scanner(System.in);
    }

    public void displayItems(){
        Items items =new Items("jacket",123.0,true);
        int sum=0;
        int count=0;
        List<Items> itemsList=onlineCartRepository.retrieveAll();
        for(Items item: itemsList){
            sum += (int) item.getPrice();
            count+=1;
            int cartId = item.getId();
            String cartItem = item.getItem();
            double cartPrice = item.getPrice();
            boolean item_Instock = item.isIn_stock();
            System.out.println("id: " + cartId + ", cart item: " + cartItem + ", cart price: " +
                    cartPrice + ", item in stock: " + item_Instock);
            System.out.println("items retrieved successfully");
            System.out.println("The total price is:"+" "+sum+" "+"of"+" "+count+" "+"item/s");
        }

    }
    public void saveItem(){
        int id = getNextItemId();
        System.out.println("Enter the name of the item you want to buy: ");
        String item = scanner.nextLine();


        double price=0.0;
        boolean isValid=false;
        try{
            while(!isValid){
                System.out.println("Enter the price of the item bought: ");
                price=scanner.nextDouble();
                isValid=true;

            }




        } catch (Exception e) {
            System.out.println("Please enter  valid price for an item");
        }


        System.out.println("Is the item in or out of stock:");
        boolean in_stock = scanner.nextBoolean();

        Items items= new Items(
                item,
                price,
                in_stock


        );

        onlineCartRepository.save(items);
        System.out.println("Items saved successfully");

    }
    private static int itemIdCounter = 0;


    private int getNextItemId() {
        return ++itemIdCounter;
    }


    public void updateItem(){
        System.out.println("Enter items id:");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid numeric ID:");
            scanner.next();
        }

        int updatedId = scanner.nextInt();
        scanner.nextLine();

        Items updatedItem =onlineCartRepository.retrieve(updatedId);

        System.out.println("Enter name of new item:");
        String updatedItem_sold=scanner.nextLine();

        System.out.println("Enter items price:");
        double updatedItemsPrice=scanner.nextDouble();

        System.out.println("Is the item in or out of stock:");
        boolean updatedItem_instock= scanner.hasNextBoolean();

        updatedItem_sold = updatedItem_sold.isEmpty()?updatedItem.getItem():updatedItem_sold;

        Items updatedItems = new Items(
                updatedItem_sold,
                updatedItemsPrice,
                updatedItem_instock



        );
        onlineCartRepository.update(updatedId,updatedItems);
        System.out.println("Item updated successfully");

    }
    public void deleteItem(){
        int id=0;
        if(!scanner.hasNextInt()){
            System.out.println("please enter valid:");
            Items item = onlineCartRepository.retrieve(id);
            String task1="id:"+" "+(item.getId()+", title=" +item.getItem()+" "+", price="+item.getPrice())+" " +",instock="+item.isIn_stock();
            System.out.println(task1);
            System.out.println("item deleted successfully");


        }


    }


}







