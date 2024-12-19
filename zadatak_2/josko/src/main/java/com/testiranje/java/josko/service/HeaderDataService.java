package com.testiranje.java.josko.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.testiranje.java.josko.model.HeaderData;
import com.testiranje.java.josko.model.RecordHeader;
import com.testiranje.java.josko.repository.HeaderDataRepository;
import com.testiranje.java.josko.repository.RecordHeaderRepository;

@Service
public class HeaderDataService {
	
	
	private final RecordHeaderRepository recordHeaderRepository;

	private final HeaderDataRepository headerDataRepository;

	public HeaderDataService(RecordHeaderRepository recordHeaderRepository,
			HeaderDataRepository headerDataRepository) {

		this.recordHeaderRepository = recordHeaderRepository;
		this.headerDataRepository = headerDataRepository;
	}

	 public void saveHeaderData(List<RecordHeader> recordHeaders) {
		 
	        for (RecordHeader recordHeader : recordHeaders) {
	            
	            Integer transactionId = recordHeaderRepository.save(recordHeader);

	            
	            for (HeaderData HeaderData : recordHeader.getHeaderData()) {
	            	HeaderData.setTransactionId(transactionId);
	            }

	     
	            headerDataRepository.saveAll(recordHeader.getHeaderData());
	        }
	    }
}