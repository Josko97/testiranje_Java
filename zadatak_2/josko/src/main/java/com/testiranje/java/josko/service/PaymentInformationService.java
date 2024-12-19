package com.testiranje.java.josko.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.testiranje.java.josko.model.PaymentInformation;
import com.testiranje.java.josko.model.RecordHeader;
import com.testiranje.java.josko.repository.PaymentInformationRepository;
import com.testiranje.java.josko.repository.RecordHeaderRepository;

@Service
public class PaymentInformationService {
	
	
	private final RecordHeaderRepository recordHeaderRepository;

	private final PaymentInformationRepository paymentInformationRepository;

	public PaymentInformationService(RecordHeaderRepository recordHeaderRepository,
			PaymentInformationRepository paymentInformationRepository) {

		this.recordHeaderRepository = recordHeaderRepository;
		this.paymentInformationRepository = paymentInformationRepository;
	}

	 public void savePaymentInformation(List<RecordHeader> recordHeaders) {
		 
	        for (RecordHeader recordHeader : recordHeaders) {
	            
	            Integer transactionId = recordHeaderRepository.save(recordHeader);

	            
	            for (PaymentInformation PaymentInformation : recordHeader.getPaymentInformation()) {
	            	PaymentInformation.setTransactionId(transactionId);
	            }

	     
	            paymentInformationRepository.saveAll(recordHeader.getPaymentInformation());
	        }
	    }
}
