package com.testiranje.java.josko.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.testiranje.java.josko.converter.implementation.ArticleDataConverter;
import com.testiranje.java.josko.converter.implementation.TransactionDataConverter;
import com.testiranje.java.josko.model.ArticleData;
import com.testiranje.java.josko.model.TransactionData;

public class FileIterator {

	private static final Map<String, List<Object>> recordStorage = new HashMap<>();

	private final ArticleDataConverter articleDataConverter;
	private final TransactionDataConverter transactionDataConverter;
	
	

	public FileIterator(ArticleDataConverter articleDataConverter, TransactionDataConverter transactionDataConverter) {

		this.articleDataConverter = articleDataConverter;
		this.transactionDataConverter = transactionDataConverter;
	}
	
	

	static {
		recordStorage.put("S", new ArrayList<>());
		recordStorage.put("F", new ArrayList<>());
	}
	

	public void fileIterator(String filePath) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			File file = new File(filePath);

			String line;

			while ((line = reader.readLine()) != null) {

				if (file.length() % (line.length()+2) != 0) {
					System.out.println("Invalid row!");
					continue;
				}

				String recordType = getRecordType(line);

				switch (recordType) {

				case "S":
					ArticleData articleData = articleDataConverter.fetchData(line);
					recordStorage.get("S").add(articleData);
					break;
				case "F":
					TransactionData transactionData = transactionDataConverter.fetchData(line);
					recordStorage.get("F").add(transactionData);
				default:
					System.out.println("Unknown record type: " + line);
				}

			}

		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}

	}

	private static String getRecordType(String line) {

		if (line.contains(":S:")) {
			return "S";
		}

		return null;
	}

}
