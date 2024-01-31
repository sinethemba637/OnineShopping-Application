package org.example;

import java.util.List;

public interface OnlineCart_Repository {

    public void save(Items item_sold);

    public void update(long id,Items updatedItemSold);



    public void delete(long id);

    public Items retrieve(long id);

    public List<Items> retrieveAll();

//public List<Items> clearAll();
}

