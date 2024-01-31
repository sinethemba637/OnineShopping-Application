package org.example;

public class Items {
    private String item;
    private double price;
    private boolean in_stock;
    private int id;

    public Items(String item, double price, boolean in_stock) {
        this.item = item;
        this.price = price;
        this.in_stock = in_stock;
//        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }
}

