package com.testiranje.java.josko.converter;

import java.util.LinkedHashMap;
import java.util.Map;

public interface FileConverter {
	
	void fetchData(String filePath);
	
	default Map<String, Object> fetchRecordHeader(String line) {
		
		String branchNumber = line.substring(0, 4);
		String posTerminal = line.substring(5, 8);
		String dateTime = "20"+line.substring(9,15)+line.substring(16, 22);
		String receiptNumber = line.substring(23, 27);
		String itemSequence = line.substring(28, 31);
		
		Map<String, Object> recordHeader = new LinkedHashMap<>();
	    recordHeader.put("branchNumber", branchNumber);
	    recordHeader.put("posTerminal", posTerminal);
	    recordHeader.put("dateTime", dateTime);
	    recordHeader.put("receiptNumber", receiptNumber);
	    recordHeader.put("itemSequence", itemSequence);

	    return recordHeader; 
	}
		
}
