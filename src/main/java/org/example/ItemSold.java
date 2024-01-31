package org.example;

import java.util.ArrayList;
import java.util.List;

public class ItemSold implements OnlineCart_Repository {

    public List<Items> getOnline_cart() {
        return online_cart;
    }

    public void setOnline_cart(List<Items> online_cart) {
        this.online_cart = online_cart;
    }

    private  List<Items> online_cart = new ArrayList<>();



    @Override
    public void save(Items item_sold) {
        if (item_sold!= null) {
            item_sold.setId(online_cart.size());
            online_cart.add(item_sold);

        }
    }


    @Override
    public void update(long id, Items updatedItemSold) {
        Items item = retrieve(id);
        int index=-1;
        if (item != null) {
            online_cart.indexOf(item);
        }
        if(index>=0 && index<online_cart.size()){
            online_cart.set( index,updatedItemSold);
        }
    }


    @Override
    public void delete(long id) {
        Items item = retrieve(id);
        if (item != null) {
            online_cart.remove(item);
        }


    }

    @Override

    public Items retrieve(long id) {
        for (Items item : online_cart) {
            if (item.getId() == id) {
                return item;
            }

        }
        return null;
    }
    @Override

    public List<Items> retrieveAll() {
        return new ArrayList<>(online_cart);

    }


}



