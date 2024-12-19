package com.testiranje.java.josko.converter.implementation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.testiranje.java.josko.converter.FileConverter;
import com.testiranje.java.josko.converter.JSONFileCreator;

@Component("W")
public class AdditionalArticleInformationConverter implements FileConverter {

	@Override
	public void fetchData(String line) {
		
		Map<String, Object> recordHeader = fetchRecordHeader(line);
		
		String itemInfo = line.substring(38,42);
		String eanUpc = line.substring(43, 59);
		String ageRestriction = String.valueOf(line.charAt(67));
		Integer amount = Integer.parseInt(line.substring(69));
		Integer transactionId = null;
		
		Map<String, Object> additionalArticleInformation = new LinkedHashMap<>();
		
		additionalArticleInformation.put("itemInfo", itemInfo);
		additionalArticleInformation.put("eanUpc", eanUpc);
		additionalArticleInformation.put("ageRestriction", ageRestriction);
		additionalArticleInformation.put("amount", amount);
		additionalArticleInformation.put("transactionId", transactionId);
		
		recordHeader.put("additionalArticleInformation", List.of(additionalArticleInformation));

		JSONFileCreator jsonAppender = new JSONFileCreator();
		jsonAppender.appendToJsonFile(recordHeader, "W_combinedData.json");
		
		
		
	}
}
