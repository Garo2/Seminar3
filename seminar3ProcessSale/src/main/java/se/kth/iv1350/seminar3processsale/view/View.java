package se.kth.iv1350.seminar3processsale.view;

import se.kth.iv1350.seminar3processsale.dto.ReceiptDTO;
import se.kth.iv1350.seminar3processsale.controller.Controller;

/*
View class calls from Main which will represent the cashier in our case and enter values such as itemIds.
*  */
public class View {

    private Controller controller;
/*
* View class represents the cashier which enter item Ids. So first The cashier starts a new sale, enters customer items Ids.
* When the cashier is done with registering the items, he/she ends the sale and enters the amount paid and return the change to customer
* And AFter the payment is done, the controller call a method in Sale to save the loged sale in AccountingSystem.
* */
    public View(Controller controller){
        this.controller = controller;
        controller.startNewSale();
        controller.addItemToSale(123);
        controller.addItemToSale(1234);
        controller.addItemToSale(12345);
        controller.addItemToSale(123456);
        controller.addItemToSale(123456);
        controller.addItemToSale(1111);
        controller.addItemToSale(222222);
        controller.addItemToSale(222222);
        controller.addItemToSale(222);
        controller.endSale();
        controller.enterAmountPaid(1000);

        controller.logCompletedSale();

    }
}