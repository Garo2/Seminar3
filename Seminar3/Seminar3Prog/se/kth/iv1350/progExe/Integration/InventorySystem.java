package se.kth.iv1350.progExe.integration;

import se.kth.iv1350.progExe.DTO.ItemDTO;
import se.kth.iv1350.progExe.model.Item;

public class InventorySystem {

    private ItemDTO[] storeStock;
    
    public InventorySystem() {
        this.storeStock = new ItemDTO[] {
            new ItemDTO(123, "Milk", 10.90, 0.12),
            new ItemDTO(1234, "Strawberry", 39.99, 0.6),
            new ItemDTO(12345, "Blueberry", 29.99, 0.6),
            new ItemDTO(123456, "Water", 15.95, 0.6),
            new ItemDTO(654321, "Cola", 17.95, 0.12),
            new ItemDTO(54321, "Pepsi", 18.95, 0.12),
            new ItemDTO(4321, "Chips", 21.95, 0.25),
            new ItemDTO(321, "Apple", 20.95, 0.12),
            new ItemDTO(111111, "Orange", 20.95, 0.12),
            new ItemDTO(222222, "Lemon", 9.99, 0.12),
            new ItemDTO(333333, "Cucumber", 19.95, 0.12),
            new ItemDTO(444444, "Tomato", 25.95, 0.12),
        };
    }

    public ItemDTO getItemInfo(int itemIdentification) 
    {
        ItemDTO emptyItem = new ItemDTO(0, "", 0.0, 0.0);
        for(int i=0; i<storeStock.length; i++)
        {
            
            ItemDTO tempItemDTO = storeStock[i];
            //itemDTO = storeStock[i];
            int itemId = tempItemDTO.getItemIdentification();
            
            if(itemIdentification == itemId)
            {
                return storeStock[i];
            }
        }
        return emptyItem;
    }

  
/*
    public void updateInventorySystem (SaleLog saleLog){ // reieve SaleLog to update Inventory System.

     }*/

    
}