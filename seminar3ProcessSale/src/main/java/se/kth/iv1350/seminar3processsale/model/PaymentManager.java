package se.kth.iv1350.seminar3processsale.model;

import se.kth.iv1350.seminar3processsale.dto.ItemDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * This class calculates all calculations of totalPrice for entireSale, calculate the difference between amountPaid and totalPrice and return it as change, VatForEntireSale..
 */
public class PaymentManager {

    private double totalPrice;
    private double change;
    private int amountPaid;
    private double itemPrice;
    private double VatEntireSale;

    /**
     *  calculates the change and return the value with rounding the answer into 2 decimal number,
     */
    public PaymentManager() {
    }

    /**
     * @param amountPaid is the amount of customer payment
     * @return the amount that the cashier supposed to give the customer back.
     */
    public double calcAmountChange(int amountPaid) {
        this.amountPaid = amountPaid;
        this.change = amountPaid - totalPrice;
        RegisterIncomeHandler registerIncomeHandler = new RegisterIncomeHandler();
        registerIncomeHandler.updateRegisterAmount(amountPaid);
        return (double)Math.round( change*100 )/100;
    }

    /**
     * @param itemPrice the price for each item after calculating the price including vat
     * @param itemQuantity the quantity of registered item with the entered itemId,
     * @return return the totalPrice after each item until all items have been registered.
     */
    public double calcTotalPrice(double itemPrice, int itemQuantity)
    {
       return totalPrice += (itemPrice * itemQuantity);
    }

    /**
     * calculates the vatForEntireSale and return the value with rounding the answer into 2 decimal number.
     * @param itemPrice itemPrice excluding vat from the itemDTO.
     * @param itemVatRate itemVatRate depends on each item in InventorySystem.
     * @return the VatEntireSale after each item has been added until all items has been registered.
     */
    public double calcVatForEntireSale(double itemPrice, double itemVatRate) {
        return this.VatEntireSale += itemPrice * itemVatRate;
    }

    /**
     *  calculates the itemPriceIncVat and return the value with rounding the answer into 2 decimal number,
     * @param itemPrice
     * @param itemVatRate
     * @return update the itemPrice after by adding vatAmount to ItemPriceExcludingVat.
     */
    public double calcItemPriceIncVat(double itemPrice, double itemVatRate) {
       return this.itemPrice = itemPrice+(itemPrice * itemVatRate);
    }

    /**
     * calculates the totalPrice and return the value with rounding the answer into 2 decimal number,
     * @return return totalPrice with rounding for 2 decimals number.
     */
    public double getTotalPrice() {
        return (double)Math.round( totalPrice*100 )/100;
    }


    /**
     * @return amountPaid
     */
    public int getAmountPaid() {
        return amountPaid;
    }

    /**
     * Rounding each price which call this method, into a number with only 2 decimal numbers.
     * @param price itemPrice includingVat
     * @return rounding the price to 2 decimals number.
     */
    public double getPriceRounded(double price) {
        return ((double)Math.round( price*100 ))/ 100;
    }
}