package se.kth.iv1350.progExe.startup;

import se.kth.iv1350.progExe.DTO.*;
import se.kth.iv1350.progExe.integration.*;
import se.kth.iv1350.progExe.model.*;
import se.kth.iv1350.progExe.startup.*;
import se.kth.iv1350.progExe.view.View;

import java.util.Scanner;

import se.kth.iv1350.progExe.controller.*;


public class Main {
    public static void main(String[] args) {
        AccountingSystem accountingSystem = new AccountingSystem();
        CustomerDiscountSystem customerDiscountSystem = new CustomerDiscountSystem();
        InventorySystem inventorySystem = new InventorySystem();
        Printer printer = new Printer();
        Controller controller = new Controller(printer, inventorySystem, customerDiscountSystem, accountingSystem);
        View view = new View(controller);
        view.startNewSale();
    }
}