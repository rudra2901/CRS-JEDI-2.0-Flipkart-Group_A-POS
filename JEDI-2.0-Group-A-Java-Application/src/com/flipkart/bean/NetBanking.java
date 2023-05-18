package com.flipkart.bean;

public class NetBanking {

	private String ModeOfTransfer;
	private String AccountNumber;
	private String IFSC;

	public String getModeOfTransfer() {
		return ModeOfTransfer;
	}

	public void setModeOfTransfer(String modeOfTransfer) {
		ModeOfTransfer = modeOfTransfer;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

}
