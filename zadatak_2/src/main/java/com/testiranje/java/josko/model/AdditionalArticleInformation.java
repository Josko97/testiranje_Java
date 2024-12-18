package com.testiranje.java.josko.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "IDC_W")
public class  AdditionalArticleInformation{

    @Id
    @Column("id")
    private Integer id;

    @Column("ItemInfo")
    private String itemInfo;

    @Column("EanUpc")
    private String eanUpc;

    @Column("AgeRestriction")
    private String ageRestriction;

    @Column("Amount")
    private Integer amount;
    
    @Column("TransactionId")
	private int transactionId;
    
    public AdditionalArticleInformation() {};

	public AdditionalArticleInformation(String itemInfo, String eanUpc, String ageRestriction, Integer amount,
			int transactionId) {
		this.itemInfo = itemInfo;
		this.eanUpc = eanUpc;
		this.ageRestriction = ageRestriction;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public String getEanUpc() {
		return eanUpc;
	}

	public void setEanUpc(String eanUpc) {
		this.eanUpc = eanUpc;
	}

	public String getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(String ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

   
}
