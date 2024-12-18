package com.testiranje.java.josko.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testiranje.java.josko.model.RecordHeader;
import com.testiranje.java.josko.service.TransactionDataService;

@RestController
@RequestMapping("/transaction")
public class TransactionDataController {

	private final TransactionDataService transactionDataService;

	public TransactionDataController(TransactionDataService transactionDataService) {

		this.transactionDataService = transactionDataService;
	}

	@PostMapping
	public ResponseEntity<String> saveTransactions(@RequestParam("file") MultipartFile file) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();

			List<RecordHeader> recordHeaderList = objectMapper.readValue(file.getInputStream(),
					objectMapper.getTypeFactory().constructCollectionType(List.class, RecordHeader.class));

			transactionDataService.saveTransactions(recordHeaderList);

			return ResponseEntity.status(HttpStatus.CREATED).body("Data successfully saved to the database!");
			
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing JSON file: " + e.getMessage());
		}
	}
}
