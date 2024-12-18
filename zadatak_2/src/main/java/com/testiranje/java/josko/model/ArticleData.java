package com.testiranje.java.josko.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("dbo.IDC_S")
public class ArticleData {

	@Id
	@Column("id")
	private Integer id;

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

	@Column("OriginalItemPrice")
	private Integer originalItemPrice;

	@Column("ArticleDescription")
	private String articleDescription;

	@Column("TransactionId")
	private int transactionId;

	public ArticleData() {

	}

	public ArticleData(String departmentNumber, String pluNumber, Integer quantity, Integer weight,
			Integer amountAbsolute, Integer originalItemPrice, String articleDescription, int transactionId) {

		this.departmentNumber = departmentNumber;
		this.pluNumber = pluNumber;
		this.quantity = quantity;
		this.weight = weight;
		this.amountAbsolute = amountAbsolute;
		this.originalItemPrice = originalItemPrice;
		this.articleDescription = articleDescription;
		this.transactionId = transactionId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	};

}
