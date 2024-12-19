package com.testiranje.java.josko.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testiranje.java.josko.model.AdditionalArticleInformation;
import com.testiranje.java.josko.model.RecordHeader;
import com.testiranje.java.josko.repository.AdditionalArticleInformationRepository;
import com.testiranje.java.josko.repository.RecordHeaderRepository;

@Service
public class AdditionalArticleInformationService {
	
	
	private final RecordHeaderRepository recordHeaderRepository;

	private final AdditionalArticleInformationRepository additionalArticleInformationRepository;

	public AdditionalArticleInformationService(RecordHeaderRepository recordHeaderRepository,
			AdditionalArticleInformationRepository additionalArticleInformationRepository) {

		this.recordHeaderRepository = recordHeaderRepository;
		this.additionalArticleInformationRepository = additionalArticleInformationRepository;
	}

	 public void saveAdditionalArticleInformation(List<RecordHeader> recordHeaders) {
		 
	        for (RecordHeader recordHeader : recordHeaders) {
	            
	            Integer transactionId = recordHeaderRepository.save(recordHeader);

	            
	            for (AdditionalArticleInformation additionalArticleInformation : recordHeader.getAdditionalArticleInformation()) {
	            	additionalArticleInformation.setTransactionId(transactionId);
	            }

	     
	            additionalArticleInformationRepository.saveAll(recordHeader.getAdditionalArticleInformation());
	        }
	    }
}

