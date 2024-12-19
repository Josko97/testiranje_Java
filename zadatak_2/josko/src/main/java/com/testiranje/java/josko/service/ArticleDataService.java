package com.testiranje.java.josko.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testiranje.java.josko.model.ArticleData;
import com.testiranje.java.josko.model.RecordHeader;

import com.testiranje.java.josko.repository.ArticleDataRepository;
import com.testiranje.java.josko.repository.RecordHeaderRepository;


@Service
public class ArticleDataService {
	
	
	private final RecordHeaderRepository recordHeaderRepository;

	private final ArticleDataRepository articleDataRepository;

	public ArticleDataService(RecordHeaderRepository recordHeaderRepository,
			ArticleDataRepository articleDataRepository) {

		this.recordHeaderRepository = recordHeaderRepository;
		this.articleDataRepository = articleDataRepository;
	}

	 public void saveArticleData(List<RecordHeader> recordHeaders) {
		 
	        for (RecordHeader recordHeader : recordHeaders) {
	            
	            Integer transactionId = recordHeaderRepository.save(recordHeader);

	            
	            for (ArticleData articleData : recordHeader.getArticleData()) {
	            	articleData.setTransactionId(transactionId);
	            }

	     
	            articleDataRepository.saveAll(recordHeader.getArticleData());
	        }
	    }
}
