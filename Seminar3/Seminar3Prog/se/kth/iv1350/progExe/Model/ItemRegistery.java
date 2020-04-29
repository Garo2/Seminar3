package se.kth.iv1350.progExe.model;
import se.kth.iv1350.progExe.DTO.ItemDTO;
import se.kth.iv1350.progExe.DTO.ReceiptDTO;
import se.kth.iv1350.progExe.model.*;
import java.util.ArrayList;
import se.kth.iv1350.progExe.integration.InventorySystem;

/**
 * ItemRegistery
 */
public class ItemRegistery {

    private ArrayList<ItemDTO> itemDTOList;
    private Item item;
    private double totalPrice;
    private ArrayList<Integer> itemQuantityList;

    public ItemRegistery() {
        itemDTOList = new ArrayList<ItemDTO>();
        itemQuantityList = new ArrayList<Integer>();
    }

    /**
     * @return the itemDTO
     */
    public void addItemToRegistery(ItemDTO item) // return itemDTO //only the current item;
    {
        for (int i =0; i<itemDTOList.size(); i++) {
            if (item.getItemDescription().equals(itemDTOList.get(i).getItemDescription())) {
               int itemQuantity = this.itemQuantityList.get(i);
               itemQuantity++;
               this.itemQuantityList.set(i, itemQuantity);
               return;
            }
        }
        itemDTOList.add(item);      
        itemQuantityList.add(1);
    }

    /**
     * @return the itemDTOList
     */
    public ArrayList<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }
    /**
     * @return the itemQuantityList
     */
    public ArrayList<Integer> getItemQuantityList() {
        return itemQuantityList;
    }
    // public void updateItemQuantity(int itemId) {
    //     //for () // update the item quantity by looping through itemDTOList;
    //     for(int i=0; i<itemDTOList.size(); i++){
    //       if(itemId == itemDTOList.get(i).getItemIdentification())
    //       {
    //         itemQuantity.get(i);
    //       }
    //     }
    // }
    
    // /**
    //   * @return the itemsList
    //   */
    // public ArrayList<ItemDTO> getItemDTOList() {
    //     return itemDTOList;
    // }

    
}