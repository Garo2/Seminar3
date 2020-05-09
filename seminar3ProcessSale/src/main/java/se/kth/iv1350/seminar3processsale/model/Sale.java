package se.kth.iv1350.seminar3processsale.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import se.kth.iv1350.seminar3processsale.controller.Controller;
import se.kth.iv1350.seminar3processsale.dto.ItemDTO;
import se.kth.iv1350.seminar3processsale.dto.ReceiptDTO;
import se.kth.iv1350.seminar3processsale.integration.AccountingSystem;
import se.kth.iv1350.seminar3processsale.integration.InventorySystem;
import se.kth.iv1350.seminar3processsale.integration.Printer;
import se.kth.iv1350.seminar3processsale.dto.SaleLog;

/**
 * Sale is the core of the saleProcess here, it pass itemId to register in ItemRegistery, get the totalPrice, itemPrice, vatForEntireSale, etc. from PaymentManager
 * creates an ArrayList of itemDTO to pass them to Printer.
 */
public class Sale {
    private Controller controller;
    private ItemRegistery itemRegistery;
    private PaymentManager paymentManager;
    private AccountingSystem accountingSystem;
    private ReceiptDTO receiptDTO;
    private ArrayList<ItemDTO> itemDTOList;
    private Printer printer;
    private InventorySystem inventorySystem;
    private ArrayList<String> itemDTOListString;
    private int itemquantity;
    private double vatRateForEntireSale;
    private String itemDTOToString ="";
    private SaleLog saleLog;

    /**
     * creating an empty constructor
     */
    public Sale(){

    }

    /**
     * startNewSale by creating instances of following Classes to be able to use them later
     */
    public void startNewSale() {
        itemRegistery = new ItemRegistery();
        paymentManager = new PaymentManager();
        itemDTOList = new ArrayList<ItemDTO>();
        printer = new Printer();
        inventorySystem = new InventorySystem();
    }

    /**
     * call this method by Controller and View to pass the itemId that needs to be added.
     * add items to itemDTOList and itemQuantity.
     * Print out the added item after every addItem call if the item exists.
     *
     * @param itemId passing the itemId to return the itemDetails for adding them to saleList.
     * @return output return the item details as string
     */
    public String addItem(int itemId) {
        ItemDTO itemDTO = getItemInfo(itemId);
        if(itemDTO == null) {
            return null;
        }
        else {
            double itemPrice = itemDTO.getItemPriceExcVat();
            double itemVatRate = itemDTO.getItemVatRate();
            itemRegistery.addItemToRegistery(itemDTO);
            itemRegistery.getItemQuantityList();
            itemDTOList = itemRegistery.getItemDTOList();
            double itemPriceIncVat = paymentManager.calcItemPriceIncVat(itemPrice, itemVatRate);
            vatRateForEntireSale = paymentManager.calcVatForEntireSale(itemPrice, itemVatRate);
            double totalPrice = paymentManager.calcTotalPrice(itemPriceIncVat,1); // set as 1 temp but in logSale multiplies with quantity
            String output = (itemDTO.getItemDescription() + ", " + itemPriceIncVat + ", " + totalPrice);
            if(itemDTO.getItemDescription() == ""){

            }
            else {
                System.out.println("ItemDescription: " + itemDTO.getItemDescription()+", ItemPrice(Including Vat): "+paymentManager.getPriceRounded(itemPriceIncVat) + "kr, TotalPrice is:\t" + paymentManager.getPriceRounded(totalPrice) + "kr");
            }
            return output;
        }
    }

    /**
     * @return return the totalPrice from paymentManager.
     */
    public double endSale() {
        System.out.println("The sale has been ended. The total price is: "+ paymentManager.getTotalPrice());
        return paymentManager.getTotalPrice();
    }

    /**
     * @param amountPaid the amount of money that customer paid.
     * @return return the change from the payment and return it to cashier, and add it to receiptDTO.
     */
    public double getAmountChange(int amountPaid) {

        System.out.println("The customer has paid: "+amountPaid + " kr");
        System.out.println("The change is :"+ paymentManager.calcAmountChange(amountPaid) +" kr");
        return paymentManager.calcAmountChange(amountPaid); // pass the amountPaid and return the change to list it in ReceiptDTO.

    }

    /**
     * @return currentTime of Sale.
     */
    public String getCurrentTime() {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        return  currentTime;
    }

    /**
     * Write the itemDTOList as string to show the list on receipt. later and send a copy to AccountingSystem and returning the itemDTOString as a String.
     * @return itemDTOToString which will be listed on receipt.
     */
    public String itemsToString() {
        for (int i=0; i<itemDTOList.size(); i++) {
            if(itemDTOList.get(i).getItemDescription() == "") {

            }
            else {
                itemquantity = itemRegistery.getItemQuantityList().get(i);
                itemDTOToString += "-" + itemDTOList.get(i).getItemDescription() + "" + itemquantity+ " piece/s\t\t price: "+
                        (itemquantity * paymentManager.getPriceRounded(paymentManager.calcItemPriceIncVat(itemDTOList.get(i).getItemPriceExcVat(), itemDTOList.get(i).getItemVatRate())) + " kr\n");

            }

        }
        return itemDTOToString;
    }

    /**
     * @return itemDTOList which contains the list of added items.
     */
    public ArrayList<ItemDTO> getitemDTOList() {
        return itemDTOList;
    }

    /**
     * save the sale's information, such as itemDTOList, totalPrice, change, the date of sale, etc.
     */
    public void logedSale() {
        receiptDTO = new ReceiptDTO(getCurrentTime(), getitemDTOList(), paymentManager.getTotalPrice(), paymentManager.getPriceRounded(vatRateForEntireSale),paymentManager.getAmountPaid(),
                paymentManager.calcAmountChange(paymentManager.getAmountPaid()), itemsToString());
        saleLog = new SaleLog(receiptDTO);
        saveLogedSale(saleLog);
        printReceipt(receiptDTO);
        updateInventorySystem(saleLog);
    }

    /**
     * create an instance of Printer
     * @param receiptDTO be passed to Printer.
     */
    public void printReceipt(ReceiptDTO receiptDTO)
    {
        printer = new Printer();
        printer.printOutReceipt(receiptDTO);
    }

    /**
     * @param itemId pass the itemId to InventorySystem to return ItemDTO from Invenotry.
     * @return ItemInfo to Sale.
     */
    public ItemDTO getItemInfo(int itemId) {
        return inventorySystem.getItemInfo(itemId);
    }

    /**
     * @param saleLog save the logedSale in AccountingSystem.
     */
    public void saveLogedSale(SaleLog saleLog) {
        AccountingSystem accountingSystem = new AccountingSystem();
        accountingSystem.addSaleLogToSystem(saleLog);
    }

    /**
     * @param saleLog send the saleLog to InventorySystem to update the database.
     */
    public void updateInventorySystem(SaleLog saleLog) {
        InventorySystem.updateInvSystem(saleLog);
    }
}