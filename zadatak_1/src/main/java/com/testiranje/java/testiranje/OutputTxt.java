package com.testiranje.java.testiranje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputTxt {

	private static final String OUTPUT_FOLDER = "output";

	private static void generateFolder() {

		File folder = new File(OUTPUT_FOLDER);

		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	private static String generateFileName() {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");

		return "transactions_" + now.format(formatter) + ".txt";
	}

	public static void writeToFile(List<TransactionData> transactions) {

		generateFolder();

		String fileName = generateFileName();

		File file = new File(OUTPUT_FOLDER, fileName);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

			BigDecimal totalSum = BigDecimal.ZERO;

			Map<String, BigDecimal> transactionMap = new LinkedHashMap<>();

			for (TransactionData transaction : transactions) {

				String marketNumber = transaction.getMarketNumber();
				String cashRegister = transaction.getCashRegister();
				BigDecimal totalPrice = transaction.getTotalPrice();

				String key = marketNumber + "\t" + cashRegister;

				transactionMap.put(key, transactionMap.getOrDefault(key, BigDecimal.ZERO).add(totalPrice));

				totalSum = totalSum.add(totalPrice);

			}

			for (Map.Entry<String, BigDecimal> entry : transactionMap.entrySet()) {

				String key = entry.getKey();

				String formattedPrice = PriceConverter.convertPriceToOutputFormat(entry.getValue());

				writer.write(key + "\t" + formattedPrice);

				writer.newLine();
			}

			writer.write("----------------------------");
			writer.newLine();

			String formattedTotal = PriceConverter.convertPriceToOutputFormat(totalSum);
			writer.write("UKUPNO\t\t" + formattedTotal);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}