/**
 * 
 */
package com.flipkart.bean;

/**
 * @author rudra.tiwari
 *
 */
public class NetBanking extends Online {
	
	private String modeOfTransaction;
	private int accountNumber;
	private String IFSCcode;
	
	
	public String getModeOfTransaction() {
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
}
