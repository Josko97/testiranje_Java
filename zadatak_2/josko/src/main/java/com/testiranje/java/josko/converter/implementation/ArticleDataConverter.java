package com.testiranje.java.josko.converter.implementation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.testiranje.java.josko.converter.FileConverter;
import com.testiranje.java.josko.converter.JSONFileCreator;


@Component("S")
public class ArticleDataConverter implements FileConverter{

	@Override
	public void fetchData(String line) {
		
		Map<String, Object> recordHeader = fetchRecordHeader(line);
		
		String departmentNumber = line.substring(38, 42);
		String pluNumber = line.substring(43, 59);
		Integer quantity = Integer.parseInt(line.substring(61,64));
		Integer weight = null;
		Integer amountAbsolute = 1;
		Integer originalItemPrice = Integer.parseInt(line.substring(69));
		Integer transactionId = null;
		
		Map<String, Object> articleData = new LinkedHashMap<>();
		
		articleData.put("departmentNumber", departmentNumber);
		articleData.put("pluNumber", pluNumber);
		articleData.put("quantity", quantity);
		articleData.put("weight", weight);
		articleData.put("amountAbsolute", amountAbsolute);
		articleData.put("originalItemPrice", originalItemPrice);
		articleData.put("transactionId", transactionId);
		
		recordHeader.put("articleData", List.of(articleData));
		
		 JSONFileCreator jsonAppender = new JSONFileCreator();
		 jsonAppender.appendToJsonFile(recordHeader, "S_combinedData.json");
	}
	

}
