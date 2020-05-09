package se.kth.iv1350.seminar3processsale.main;

import se.kth.iv1350.seminar3processsale.dto.*;
import se.kth.iv1350.seminar3processsale.integration.*;
import se.kth.iv1350.seminar3processsale.model.*;
import se.kth.iv1350.seminar3processsale.main.*;
import se.kth.iv1350.seminar3processsale.view.View;
import se.kth.iv1350.seminar3processsale.controller.*;

/**
 * Main class runs first and creaste instances of some classes that will be created only once when the whole system start for the first time
 */
public class Main {
    public static void main(String[] args) {
        AccountingSystem accountingSystem = new AccountingSystem();
        CustomerDiscountSystem customerDiscountSystem = new CustomerDiscountSystem();
        InventorySystem inventorySystem = new InventorySystem();
        Printer printer = new Printer();
        Controller controller = new Controller(printer, inventorySystem, customerDiscountSystem, accountingSystem);
        View view = new View(controller);
    }
}