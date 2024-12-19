package com.testiranje.java.josko.converter.implementation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.testiranje.java.josko.converter.FileConverter;
import com.testiranje.java.josko.converter.JSONFileCreator;

@Component("T")
public class PaymentInformationConverter implements FileConverter{

	@Override
	public void fetchData(String line) {
		
		Map<String, Object> recordHeader = fetchRecordHeader(line);
		
		String cashierNumber = line.substring(38,42);
		String additionalInformation = line.substring(43,59);
		String tenderNumber = line.substring(60,62);
		String counter = line.substring(62,68);
		Integer amountOfPayment = Integer.parseInt(line.substring(69));
		Integer transactionId = null;
		
		Map<String, Object> paymentInformation = new LinkedHashMap<>();
		
		paymentInformation.put("cashierNumber", cashierNumber);
		paymentInformation.put("additionalInformation", additionalInformation);
		paymentInformation.put("tenderNumber", tenderNumber);
		paymentInformation.put("counter", counter);
		paymentInformation.put("amountOfPayment", amountOfPayment);
		paymentInformation.put("transactionId", transactionId);
		
		recordHeader.put("paymentInformation", List.of(paymentInformation));

		JSONFileCreator jsonAppender = new JSONFileCreator();
		jsonAppender.appendToJsonFile(recordHeader, "T_combinedData.json");
		
		
		
	}

}
