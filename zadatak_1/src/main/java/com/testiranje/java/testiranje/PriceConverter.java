package com.testiranje.java.testiranje;

import java.math.BigDecimal;

public class PriceConverter {

	public static String convertPriceToOutputFormat(BigDecimal totalPrice) {
		
		String formattedPrice = totalPrice.toString().replace('.', ',');

		formattedPrice = String.format("%11s", formattedPrice);

		return formattedPrice + "€";
	}

	public static BigDecimal convertPriceToBigDecimal(String priceSection) {
	
		if (priceSection.length() != 10) {
		    throw new IllegalArgumentException("Invalid format!");
		}

		BigDecimal priceB = new BigDecimal(String.valueOf(priceSection));

		priceB = priceB.movePointLeft(2);

		return priceB;
	}

}
