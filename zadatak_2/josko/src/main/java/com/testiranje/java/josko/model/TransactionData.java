package com.testiranje.java.josko.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("dbo.IDC_F")
public class TransactionData {

	@Id
	private Integer id;

	@Column("CashierNumber")
	private String cashierNumber;

	@Column("ItemCounter")
	private String itemCounter;

	@Column("TotalPrice")
	private BigDecimal totalPrice;

	@Column("TransactionId")
	private  Integer transactionId;

	public TransactionData() {

	}

	public TransactionData(String cashierNumber, String itemCounter, BigDecimal totalPrice, Integer transactionId) {
		
		this.cashierNumber = cashierNumber;
		this.itemCounter = itemCounter;
		this.totalPrice = totalPrice;
		this.transactionId = transactionId;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCashierNumber() {
		return cashierNumber;
	}

	public void setCashierNumber(String cashierNumber) {
		this.cashierNumber = cashierNumber;
	}

	public String getItemCounter() {
		return itemCounter;
	}

	public void setItemCounter(String itemCounter) {
		this.itemCounter = itemCounter;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	
	
}