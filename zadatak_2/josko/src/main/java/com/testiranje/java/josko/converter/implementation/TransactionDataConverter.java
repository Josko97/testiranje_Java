package com.testiranje.java.josko.converter.implementation;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.testiranje.java.josko.converter.FileConverter;
import com.testiranje.java.josko.converter.JSONFileCreator;
import com.testiranje.java.josko.converter.PriceConverter;

@Component("F")
public class TransactionDataConverter implements FileConverter {

	@Override
	public void fetchData(String line) {
		
		Map<String, Object> recordHeader = fetchRecordHeader(line);

		String cashierNumber = line.substring(38, 42);
		String itemCounter = line.substring(62, 68);
		BigDecimal totalPrice = PriceConverter.convertPriceToBigDecimal(line.substring(68));
		Integer transactionId = null;

		Map<String, Object> transactionData = new LinkedHashMap<>();

		transactionData.put("cashierNumber", cashierNumber);
		transactionData.put("itemCounter", itemCounter);
		transactionData.put("totalPrice", totalPrice);
		transactionData.put("transactionId", transactionId);
		
		recordHeader.put("transactionData", List.of(transactionData));
		
		 JSONFileCreator jsonAppender = new JSONFileCreator();
		 jsonAppender.appendToJsonFile(recordHeader, "F_combinedData.json");
	}

}
