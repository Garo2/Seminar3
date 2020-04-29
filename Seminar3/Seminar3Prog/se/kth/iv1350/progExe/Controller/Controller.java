package se.kth.iv1350.progExe.controller;

//import se.kth.iv1350.Model.DiscountCalculator;
import se.kth.iv1350.progExe.DTO.*;
import se.kth.iv1350.progExe.integration.*;
import se.kth.iv1350.progExe.model.*;
import se.kth.iv1350.progExe.startup.*;
/**
 * Controller
 */
public class Controller {

    private Printer printer;
    private InventorySystem inventorySystem;
    private CustomerDiscountSystem customerDiscountSystem;

    private Sale sale;
    private ItemRegistery itemRegistery;
    private PaymentManager paymentManager;
   // private DiscountCalculator discountCalculator;
    private AccountingSystem accountingSystem;

    public Controller(Printer printer, InventorySystem inventorySystem, CustomerDiscountSystem customerDiscountSystem, AccountingSystem accountingSystem) {
        this.printer = printer;
        this.inventorySystem = inventorySystem;
        this.customerDiscountSystem = customerDiscountSystem;
        this.accountingSystem = accountingSystem;
    }

    public void startNewSale() {
        this.sale = new Sale();
        System.out.println("startNewSale is created");
        sale.startNewSale();
        
        // this.itemRegistery = new ItemRegistery();
        // this.paymentManager = new PaymentManager();
        // this.sale = new Sale();
    }
    public String addItemToSale(int itemId) {
       return sale.addItem(itemId);
    } 
    

    // public String endSale() {
    //     return 
    //     calcTotalPrice
    // }
    // public String addItemToSale(int itemId) {
    //     return sale.addItem(itemId);
    // }
        
    // public boolean enterItemId(int itemId, int quantity) {
    //     if ( itemId == ItemDTO.itemId){
    //         return true;
    //     }
    //     return false;
    // }
    
}