package se.kth.iv1350.progExe.DTO;

import java.util.Date;

public class ReceiptDTO {
    private Date dateOfSale;
    private final String storesName;
    private final String storesaddress;
    private String itemDescription;
    private int itemQuantity;
    private double totalPrice;
    private double vatForEntireSale;
    private double amountPaid;
    private double change;
    private double discountRateForEntireSale;
    private double discountedTotalPrice;

    
    public ReceiptDTO(final Date dateOfSale, final String itemDescription, final int itemQuantity, final double totalPrice, final double vatForEntireSale, 
    final double amountPaid, final double change, final double discountRateForEntireSale, final double discountedTotalPrice){
        this.dateOfSale = dateOfSale;
        this.storesName="Alpha Store";
        this.storesaddress = "Kampevagen 20, 15163 Sodertalje";
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.totalPrice = totalPrice;
        this.vatForEntireSale = vatForEntireSale;
        this.amountPaid = amountPaid;
        this.change = change;
        this.discountRateForEntireSale = discountRateForEntireSale;
        this.discountedTotalPrice = discountedTotalPrice;
    }

    /**
     * @return the amountPaid
     */
    public double getAmountPaid() {
        return amountPaid;
    }
    /**
     * @return the change
     */
    public double getChange() {
        return change;
    }
    /**
     * @return the dateOfSale
     */
    public Date getDateOfSale() {
        return dateOfSale;
    }
    /**
     * @return the discountRateForEntireSale
     */
    public double getDiscountRateForEntireSale() {
        return discountRateForEntireSale;
    }
    /**
     * @return the discountedTotalPrice
     */
    public double getDiscountedTotalPrice() {
        return discountedTotalPrice;
    }
    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }
    /**
     * @return the itemQuantity
     */
    public int getItemQuantity() {
        return itemQuantity;
    }
    /**
     * @return the storesName
     */
    public String getStoresName() {
        return storesName;
    }
    /**
     * @return the storesaddress
     */
    public String getStoresaddress() {
        return storesaddress;
    }
    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }
    /**
     * @return the vatForEntireSale
     */
    public double getVatForEntireSale() {
        return vatForEntireSale;
    }

    
}