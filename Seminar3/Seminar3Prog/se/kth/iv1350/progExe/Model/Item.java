package se.kth.iv1350.progExe.model;

import java.util.ArrayList;

import se.kth.iv1350.progExe.DTO.ItemDTO;

public class Item {
    private int itemQuantity;
    private int itemId;
    private String itemDescription;
    private double itemPriceExclVat, itemVatRate;
    private ItemDTO itemDTO = new ItemDTO(itemId, itemDescription, itemPriceExclVat, itemVatRate);
    private ArrayList<ItemDTO> itemDTOList;
    private ArrayList<Item> itemsList;

    public Item(){
        
    }
    public Item(int itemId, String itemDescription, double priceExclVat, double itemVatRate){
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.itemPriceExclVat = itemPriceExclVat;
        this.itemVatRate = itemVatRate;
    }

    public Item (int itemQuantity, ItemDTO itemDTO){
        this.itemQuantity = itemQuantity;
        this.itemDTO = itemDTO;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }
    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }
    /**
     * @return the itemPriceExclVat
     */
    public double getItemPriceExclVat() {
        return itemPriceExclVat;
    }
    /**
     * @return the itemVatRate
     */
    public double getItemVatRate() {
        return itemVatRate;
    }
    /**
     * @return the itemsList
     */
    public ArrayList<Item> getItemsList() {
        return itemsList;
    }
    /**
     * @param itemDTO the itemDTO to set
     */
    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }
    /**
     * @param itemDTOList the itemDTOList to set
     */
    public void setItemDTOList(ArrayList<ItemDTO> itemDTOList) {
        this.itemDTOList = itemDTOList;
    }
    /**
     * @param itemDescription the itemDescription to set
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    /**
     * @param itemPriceExclVat the itemPriceExclVat to set
     */
    public void setItemPriceExclVat(double itemPriceExclVat) {
        this.itemPriceExclVat = itemPriceExclVat;
    }
    /**
     * @param itemVatRate the itemVatRate to set
     */
    public void setItemVatRate(double itemVatRate) {
        this.itemVatRate = itemVatRate;
    }
    /**
     * @param itemsList the itemsList to set
     */
    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }
    

    public void updateItemQuantity (int itemQuantity){
        this.itemQuantity = this.itemQuantity + itemQuantity;
    }

    public ItemDTO chekItemInfo(int itemIdentification){
        return itemDTO;
    }
    /**
     * @return the itemDTOList
     */
    public ArrayList<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }
    /**
     * @return the itemDTO
     */
    public ItemDTO getItemDTO() {
        return itemDTO;
    }
    
    /**
     * @return the itemQuantity
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    public void storeItem(int itemId){

    }

}
