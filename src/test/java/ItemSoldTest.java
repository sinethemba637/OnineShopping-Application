import org.example.ItemSold;
import org.example.Items;
import  org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ItemSoldTest {

    @Test
    void saveItem(){
       //Arrange

        ItemSold itemSold = new ItemSold();
        Items mockItems = mock(Items.class);

        //Act
        itemSold.save(mockItems);

        //Assert
        List<Items> online_Cart = itemSold.getOnline_cart();
        assertEquals(1,online_Cart.size());
        assertEquals(mockItems,online_Cart.get(0));
        assertEquals(0,mockItems.getId());




    }
    @Test
    void update(){
        //Arrange
        ItemSold itemSold = new ItemSold();
        Items updatedItem = new Items("jean",250.0,true);
        itemSold.save(updatedItem);

        //Act
        itemSold.update(1,updatedItem);

        //Assert
      List<Items> todoList= itemSold.getOnline_cart();
      assertEquals(1,todoList.size());
      assertEquals(updatedItem,todoList.get(0));
      assertEquals(0,updatedItem.getId());
    }
    @Test
    void delete(){
        ItemSold itemSold =new ItemSold();
        Items items = new Items("shoes",375.0,true);
        itemSold.delete(items.getId());

        itemSold.delete(0);

        List<Items> todoItem = itemSold.getOnline_cart();
        assertEquals(0,todoItem.size());
        assertEquals(0,items.getId());

    }
    @Test
    void retrieve(){
        //Arrange
        ItemSold itemSold = new ItemSold();
        Items item = new Items("shirt",460.0,false);
        itemSold.save(item);

        //Act
        itemSold.retrieve(0);

        //Assert
        assertEquals(0,item.getId());


    }
    @Test
    void retrieveAll(){
        //Arrange
        ItemSold itemSold = new ItemSold();
        Items item0 = new Items("shoe",123.0,true);
        Items item1= new Items("ring",1000.0,true);
        Items item2 =new Items("t-shirt",450.0,true);

        itemSold.save(item0);
        itemSold.save(item1);
        itemSold.save(item2);

        //Act
        List<Items>retrievedItems=itemSold.retrieveAll();

        //Assert

        assertEquals(3,retrievedItems.size());
        assertTrue(retrievedItems.contains(item0));
        assertTrue(retrievedItems.contains(item1));
        assertTrue(retrievedItems.contains(item2));









    }


}

