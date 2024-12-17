package com.testiranje.java.josko.converter.implementation;

import java.math.BigDecimal;

import com.testiranje.java.josko.converter.FileConverter;
import com.testiranje.java.josko.converter.PriceConverter;
import com.testiranje.java.josko.model.TransactionData;

public class TransactionDataConverter implements FileConverter{

	@Override
	public TransactionData fetchData(String line) {
		
		String cashierNumber = line.substring(39, 43);
		String itemCounter = line.substring(63, 69);
		String price = line.substring(68);
		
		BigDecimal totalPrice = PriceConverter.convertPriceToBigDecimal(price);
		
		return new TransactionData(cashierNumber, itemCounter, totalPrice);
	}

}
