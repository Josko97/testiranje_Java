package com.testiranje.java.josko.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "IDC_H")
public class HeaderData {

	@Id
	@Column("id")
	private Integer id;

	@Column("CashierNumber")
	private String cashierNumber;

	@Column("AdditionalInformation")
	private String additionalInformation;

	@Column("ItemCounter")
	private String itemCounter;

	@Column("TotalValue")
	private BigDecimal totalValue;

	@Column("TransactionId")
	private Integer transactionId;

	public HeaderData() {

	}

	public HeaderData(String cashierNumber, String additionalInformation, String itemCounter, BigDecimal totalValue,
			Integer transactionId) {

		this.cashierNumber = cashierNumber;
		this.additionalInformation = additionalInformation;
		this.itemCounter = itemCounter;
		this.totalValue = totalValue;
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

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getItemCounter() {
		return itemCounter;
	}

	public void setItemCounter(String itemCounter) {
		this.itemCounter = itemCounter;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	

}
