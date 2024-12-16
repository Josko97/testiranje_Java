package com.testiranje.java.testiranje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {

	
	public static List<TransactionData> fetchData(String inputFile) {
		
		File file = new File(inputFile);
		
		List<TransactionData> transactions = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			
			String line;

			while ((line = reader.readLine()) != null) {

				if (file.length() % (line.length()+2) != 0) {
					System.out.println("Invalid row!");
					continue;
				}

				if (line.charAt(32) != 'F' || line.charAt(34) != '1') {
					continue;
				}

				
				String marketNumber = line.substring(0,4);
				String cashRegister = line.substring(5,8);
				String priceSection = line.substring(68);
				
				BigDecimal totalPrice = PriceConverter.convertPriceToBigDecimal(priceSection);
				
				TransactionData transaction = new TransactionData(marketNumber, cashRegister, totalPrice);
				
				transactions.add(transaction);

			}

		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

}
