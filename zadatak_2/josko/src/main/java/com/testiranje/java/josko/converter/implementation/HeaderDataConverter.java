package com.testiranje.java.josko.converter.implementation;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.testiranje.java.josko.converter.FileConverter;
import com.testiranje.java.josko.converter.JSONFileCreator;
import com.testiranje.java.josko.converter.PriceConverter;

@Component("H")
public class HeaderDataConverter implements FileConverter {

	@Override
	public void fetchData(String line) {

		Map<String, Object> recordHeader = fetchRecordHeader(line);

		String cashierNumber = line.substring(38, 42);
		String additionalInformation = line.substring(43, 59);
		String itemCounter = line.substring(62, 68);
		BigDecimal totalValue = PriceConverter.convertPriceToBigDecimal(line.substring(68));
		Integer transactionId = null;

		Map<String, Object> headerData = new LinkedHashMap<>();

		headerData.put("cashierNumber", cashierNumber);
		headerData.put("additionalInformation", additionalInformation);
		headerData.put("itemCounter", itemCounter);
		headerData.put("totalValue", totalValue);
		headerData.put("transactionId", transactionId);

		recordHeader.put("headerData", List.of(headerData));

		JSONFileCreator jsonAppender = new JSONFileCreator();
		jsonAppender.appendToJsonFile(recordHeader, "H_combinedData.json");

	}

}
