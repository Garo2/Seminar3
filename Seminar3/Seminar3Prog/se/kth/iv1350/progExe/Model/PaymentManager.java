package se.kth.iv1350.progExe.model;

import se.kth.iv1350.progExe.DTO.ItemDTO;

public class PaymentManager {

    //private double totalPriceIncVat;
    private double totalPrice;
    private double change;
    private double amountPaid;

    public PaymentManager() {
    }

    public double calcAmountChange(double totalPriceIncVat, double amountPaid) {
        this.amountPaid = amountPaid;     
        this.change = amountPaid - totalPriceIncVat;   
        return change;
    }

    public double calcTotalPrice(double itemPrice, double itemVatRate, int itemQuantity)
    {
        //double itemPriceIncVat =  itemPrice * itemVatRate;
        return totalPrice += (calcItemPriceIncVat(itemPrice, itemVatRate) * itemQuantity);
    }

    public double calcItemPriceIncVat(double itemPrice, double itemVatRate) {
        return (itemPrice * itemVatRate); 
    }

    // public double calcDiscountedTotalPrice() {
    //     return 0;
        
    // }
    
}