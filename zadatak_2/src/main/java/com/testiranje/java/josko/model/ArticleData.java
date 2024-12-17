package com.testiranje.java.josko.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("dbo.IDC_S")
public class ArticleData {

	@Id
	@Column("TransactionId")
	private Integer transactionId;

	@Column("TransactionStep")
	private short transactionStep;

	@Column("DepartmentNumber")
	private String departmentNumber;

	@Column("PLUNumber")
	private String pluNumber;

	@Column("Quantity")
	private Integer quantity;

	@Column("Weight")
	private Integer weight;

	@Column("AmountAbsolute")
	private Integer amountAbsolute;

	@Column("IDCDate")
	private String idcDate;

	@Column("OriginalItemPrice")
	private Integer originalItemPrice;

	@Column("ArticleDescription")
	private String articleDescription;

	public ArticleData() {

	}

	public ArticleData(short transactionStep, String departmentNumber, String pluNumber, Integer quantity,
			Integer weight, Integer amountAbsolute, String idcDate, Integer originalItemPrice,
			String articleDescription) {
		super();
		this.transactionStep = transactionStep;
		this.departmentNumber = departmentNumber;
		this.pluNumber = pluNumber;
		this.quantity = quantity;
		this.weight = weight;
		this.amountAbsolute = amountAbsolute;
		this.idcDate = idcDate;
		this.originalItemPrice = originalItemPrice;
		this.articleDescription = articleDescription;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public short getTransactionStep() {
		return transactionStep;
	}

	public void setTransactionStep(short transactionStep) {
		this.transactionStep = transactionStep;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getPluNumber() {
		return pluNumber;
	}

	public void setPluNumber(String pluNumber) {
		this.pluNumber = pluNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getAmountAbsolute() {
		return amountAbsolute;
	}

	public void setAmountAbsolute(Integer amountAbsolute) {
		this.amountAbsolute = amountAbsolute;
	}

	public String getIdcDate() {
		return idcDate;
	}

	public void setIdcDate(String idcDate) {
		this.idcDate = idcDate;
	}

	public Integer getOriginalItemPrice() {
		return originalItemPrice;
	}

	public void setOriginalItemPrice(Integer originalItemPrice) {
		this.originalItemPrice = originalItemPrice;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

}
