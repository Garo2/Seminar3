package se.kth.iv1350.progExe.View;

import java.util.Scanner;

import se.kth.iv1350.progExe.Controller.Controller;
public class View {

    private Controller controller;

    public View(Controller controller){
        this.controller = controller;
       // Scanner askForNewSale = new Scanner("Do you want to start a new sale? (yes/no)");
      //  String answer = askForNewSale.nextLine();
        startNewSale();
    }
    public void startNewSale() {
        controller.startNewSale();
        addNewItem(123);
        addNewItem(1234);
        addNewItem(321);
    }
    public String addNewItem(int itemId) {
       return controller.addItemToSale(itemId);
    }
    // import functions that will run by controller 
    // add the rest of functions like, endSale, call the fun that returns the total price, Payment, store completed sale, updateRegisterIncomeHandler, 
    // return the change to view, and call the fun that will store saleLog in ReceiptDTO and print it out. 
}