package com.testiranje.java.josko.converter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JSONFileCreator {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();

	public void appendToJsonFile(Map<String, Object> recordHeader, String outputFilePath) {
		
		File file = new File(outputFilePath);
		
		List<Map<String, Object>> records;

		try {
			
			if (file.exists()) {
				records = objectMapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {
				});
			} else {
				records = new ArrayList<>();
			}

			
			records.add(recordHeader);

			
			writer.writeValue(file, records);

			System.out.println("Data successfully appended to JSON file: " + outputFilePath);
			
		} catch (IOException e) {
			System.err.println("Error appending data to JSON file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
