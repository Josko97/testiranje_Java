package com.testiranje.java.josko.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testiranje.java.josko.model.RecordHeader;
import com.testiranje.java.josko.model.TransactionData;
import com.testiranje.java.josko.repository.RecordHeaderRepository;
import com.testiranje.java.josko.repository.TransactionDataRepository;

@Service
public class TransactionDataService {
	
	
	private final RecordHeaderRepository recordHeaderRepository;

	private final TransactionDataRepository transactionDataRepository;

	public TransactionDataService(RecordHeaderRepository recordHeaderRepository,
			TransactionDataRepository transactionDataRepository) {

		this.recordHeaderRepository = recordHeaderRepository;
		this.transactionDataRepository = transactionDataRepository;
	}

	 public void saveTransactions(List<RecordHeader> recordHeaders) {
		 
	        for (RecordHeader recordHeader : recordHeaders) {
	            
	            Integer transactionId = recordHeaderRepository.save(recordHeader);

	            
	            for (TransactionData transactionData : recordHeader.getTransactionData()) {
	                transactionData.setTransactionId(transactionId);
	            }

	     
	            transactionDataRepository.saveAll(recordHeader.getTransactionData());
	        }
	    }
}
