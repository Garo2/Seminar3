package se.kth.iv1350.progExe.model;

import java.util.ArrayList;

import se.kth.iv1350.progExe.controller.Controller;
import se.kth.iv1350.progExe.DTO.ItemDTO;
import se.kth.iv1350.progExe.DTO.ReceiptDTO;
import se.kth.iv1350.progExe.integration.InventorySystem;
import se.kth.iv1350.progExe.integration.Printer;

/**
 * Sale
 */
public class Sale {
    
    private Controller controller;
    private ItemRegistery itemRegistery;
    private PaymentManager paymentManager;
    private ReceiptDTO receiptDTO;
    private ArrayList<ItemDTO> itemDTOLsit;
    private Printer printer;
    private InventorySystem inventorySystem;


// store items in sale, presents item descr, price and totalIncVat.
// calculations 
// 
//return ItemDTOList from ItemRegistery

    public Sale(){
        
    }
    
    public void startNewSale() {
        itemRegistery = new ItemRegistery();
        paymentManager = new PaymentManager();        
        itemDTOLsit = new ArrayList<ItemDTO>();
        printer = new Printer();
        inventorySystem = new InventorySystem();
        // int itemId = 123;
    }

    public String addItem(int itemId) {
        ItemDTO itemDTO = getItemInfo(itemId);
        System.out.println(itemDTO);
        double itemPrice = itemDTO.getItemPriceExcVat();
        double itemVatRate = itemDTO.getItemVatRate();
        itemRegistery.addItemToRegistery(itemDTO);
        itemRegistery.getItemQuantityList();
        String outPut = itemDTO.getItemDescription() + ", " + " " + paymentManager.calcItemPriceIncVat(itemPrice, itemVatRate);
        return outPut;
    }

    public double endSale() { // return totalPrice
        return 0;
    }

    public double getAmountChange(double amountPaid) {
        return 0; // pass the amountPaid and return the change to list it in ReceiptDTO.
        
    }

    public void printReceipt(ReceiptDTO receiptDTO)
    {

    }

    public ItemDTO getItemInfo(int itemId) {
        System.out.println(itemId);
        
        return inventorySystem.getItemInfo(itemId);
       
    }
    
    // public double itemPriceIncVat(double itemPrice, double itemVatRate) {
    //     return (itemPrice * itemVatRate);
    // }
}