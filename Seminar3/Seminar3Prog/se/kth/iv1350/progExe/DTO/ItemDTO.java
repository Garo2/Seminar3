package se.kth.iv1350.progExe.DTO;

import java.util.ArrayList;

import se.kth.iv1350.progExe.integration.InventorySystem;


public class ItemDTO {

	private int itemIdentification;
	private String itemDescription;
	private double itemPriceExcVat;
	private double itemVatRate;

	// public ItemDTO()
	// {
	// 	this.itemIdentification = 0;
	//  	this.itemDescription = "";
	//  	this.itemPriceExcVat = 0;
	//  	this.itemVatRate = 0;
	// }

	public ItemDTO(int itemIdentification, String itemDescription, double itemPriceExcVat, double itemVatRate)
	{
		this.itemIdentification = itemIdentification;
		this.itemDescription = itemDescription;
		this.itemPriceExcVat = itemPriceExcVat;
		this.itemVatRate = itemVatRate;
	}
	/**
	 * @return the itemIdentification
	 */
	public int getItemIdentification() {
		return itemIdentification;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @return the itemPriceExcVat
	 */
	public double getItemPriceExcVat() {
		return itemPriceExcVat;
	}
	/**
	 * @return the itemVatRate
	 */
	public double getItemVatRate() {
		return itemVatRate;
	}
	// /**
	//  * @param itemDescription the itemDescription to set
	//  */
	// public void setItemDescription(String itemDescription) {
	// 	this.itemDescription = itemDescription;
	// }
	// /**
	//  * @param itemIdentification the itemIdentification to set
	//  */
	// public void setItemIdentification(int itemIdentification) {
	// 	this.itemIdentification = itemIdentification;
	// }
	// /**
	//  * @param itemPriceExcVat the itemPriceExcVat to set
	//  */
	// public void setItemPriceExcVat(double itemPriceExcVat) {
	// 	this.itemPriceExcVat = itemPriceExcVat;
	// }
	// /**
	//  * @param itemVatRate the itemVatRate to set
	//  */
	// public void setItemVatRate(double itemVatRate) {
	// 	this.itemVatRate = itemVatRate;
	// }
}