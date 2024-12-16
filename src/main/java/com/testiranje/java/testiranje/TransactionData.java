package com.testiranje.java.testiranje;

import java.math.BigDecimal;

public class TransactionData {
	
	private String marketNumber;
	
	private String cashRegister;
	
	private BigDecimal totalPrice;

	public TransactionData(String marketNumber, String cashRegister, BigDecimal totalPrice) {
		this.marketNumber = marketNumber;
		this.cashRegister = cashRegister;
		this.totalPrice = totalPrice;
	}

	public String getMarketNumber() {
		return marketNumber;
	}

	public void setMarketNumber(String marketNumber) {
		this.marketNumber = marketNumber;
	}

	public String getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(String cashRegister) {
		this.cashRegister = cashRegister;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	

}
