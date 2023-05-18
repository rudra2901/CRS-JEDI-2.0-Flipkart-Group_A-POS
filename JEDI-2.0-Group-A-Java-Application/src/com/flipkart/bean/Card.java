/**
 * 
 */
package com.flipkart.bean;

/**
 * @author rudra.tiwari
 *
 */
public class Card extends Online{
	
	private int cardNumber;
	private String cardType;
	
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
