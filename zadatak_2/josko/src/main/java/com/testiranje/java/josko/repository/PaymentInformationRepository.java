package com.testiranje.java.josko.repository;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.testiranje.java.josko.model.PaymentInformation;


@Repository
public class PaymentInformationRepository {
    	
	
	private final JdbcTemplate jdbcTemplate;

    public PaymentInformationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(PaymentInformation paymentInformation) {
        String sql = "INSERT INTO dbo.IDC_T (CashierNumber, AdditionalInformation, TenderNumber, Counter, AmountOfPayment, TransactionId) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
        		paymentInformation.getCashierNumber(),
        		paymentInformation.getAdditionalInformation(),
        		paymentInformation.getTenderNumber(),
        		paymentInformation.getCounter(),
        		paymentInformation.getAmountOfPayment(),
        		paymentInformation.getTransactionId());
    }

    public void saveAll(List<PaymentInformation> paymentInformationList) {
        for (PaymentInformation paymentInformation : paymentInformationList) {
            save(paymentInformation);
        }
    }
}

