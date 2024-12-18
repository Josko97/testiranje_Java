package com.testiranje.java.josko.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "IDC_T")
public class PaymentInformation {

    @Id
    @Column("id")
    private Integer id;

    @Column("CashierNumber")
    private String cashierNumber;

    @Column("AdditionalInformation")
    private String additionalInformation;

    @Column("TenderNumber")
    private String tenderNumber;

    @Column("Counter")
    private String counter;

    @Column("AmountOfPayment")
    private Integer amountOfPayment;
    
	@Column("TransactionId")
	private int transactionId;
	
	public PaymentInformation() {};

	public PaymentInformation(String cashierNumber, String additionalInformation, String tenderNumber, String counter,
			Integer amountOfPayment, int transactionId) {
	
		this.cashierNumber = cashierNumber;
		this.additionalInformation = additionalInformation;
		this.tenderNumber = tenderNumber;
		this.counter = counter;
		this.amountOfPayment = amountOfPayment;
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

	public String getTenderNumber() {
		return tenderNumber;
	}

	public void setTenderNumber(String tenderNumber) {
		this.tenderNumber = tenderNumber;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public Integer getAmountOfPayment() {
		return amountOfPayment;
	}

	public void setAmountOfPayment(Integer amountOfPayment) {
		this.amountOfPayment = amountOfPayment;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	
}
