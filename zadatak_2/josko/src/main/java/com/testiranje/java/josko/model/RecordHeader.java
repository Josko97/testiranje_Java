package com.testiranje.java.josko.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "RecordHeader")
public class RecordHeader {

	@Id
	@Column("TransactionId")
	private Integer transactionId;

	@Column("BranchNumber")
	private String branchNumber;

	@Column("POSTerminal")
	private String posTerminal;

	@Column("DateTime")
	private String dateTime;

	@Column("ReceiptNumber")
	private String receiptNumber;

	@Column("ItemSequence")
	private String itemSequence;

	@MappedCollection(idColumn = "TransactionId", keyColumn = "id")
	private List<TransactionData> transactionData;

	@MappedCollection(idColumn = "TransactionId", keyColumn = "id")
	private List<ArticleData> articleData;

	@MappedCollection(idColumn = "TransactionId", keyColumn = "id")
	private List<AdditionalArticleInformation> additionalArticleInformation;

	@MappedCollection(idColumn = "TransactionId", keyColumn = "id")
	private List<PaymentInformation> paymentInformation;

	@MappedCollection(idColumn = "TransactionId", keyColumn = "id")
	private List<HeaderData> headerData;

	public RecordHeader() {
		
	}

	public RecordHeader(String branchNumber, String posTerminal, String dateTime, String receiptNumber,
			String itemSequence) {

		this.branchNumber = branchNumber;
		this.posTerminal = posTerminal;
		this.dateTime = dateTime;
		this.receiptNumber = receiptNumber;
		this.itemSequence = itemSequence;
		this.transactionData = new ArrayList<>();
		this.articleData = new ArrayList<>();
		this.additionalArticleInformation = new ArrayList<>();
		this.paymentInformation = new ArrayList<>();
		this.headerData = new ArrayList<>();
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getBranchNumber() {
		return branchNumber;
	}

	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}

	public String getPosTerminal() {
		return posTerminal;
	}

	public void setPosTerminal(String posTerminal) {
		this.posTerminal = posTerminal;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public String getItemSequence() {
		return itemSequence;
	}

	public void setItemSequence(String itemSequence) {
		this.itemSequence = itemSequence;
	}

	public List<TransactionData> getTransactionData() {
		return transactionData;
	}

	public void setTransactionData(List<TransactionData> transactionData) {
		this.transactionData = transactionData;
	}

	public List<ArticleData> getArticleData() {
		return articleData;
	}

	public void setArticleData(List<ArticleData> articleData) {
		this.articleData = articleData;
	}

	public List<AdditionalArticleInformation> getAdditionalArticleInformation() {
		return additionalArticleInformation;
	}

	public void setAdditionalArticleInformation(List<AdditionalArticleInformation> additionalArticleInformation) {
		this.additionalArticleInformation = additionalArticleInformation;
	}

	public List<PaymentInformation> getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(List<PaymentInformation> paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public List<HeaderData> getHeaderData() {
		return headerData;
	}

	public void setHeaderData(List<HeaderData> headerData) {
		this.headerData = headerData;
	}

	
	
	
	
	
	
}
