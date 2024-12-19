package com.testiranje.java.josko.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testiranje.java.josko.model.HeaderData;



@Repository
public class HeaderDataRepository {
    	
	
	private final JdbcTemplate jdbcTemplate;

    public HeaderDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(HeaderData headerData) {
        String sql = "INSERT INTO dbo.IDC_H (CashierNumber, AdditionalInformation, ItemCounter, TotalValue, TransactionId) "
                   + "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
        		headerData.getCashierNumber(),
        		headerData.getAdditionalInformation(),
        		headerData.getItemCounter(),
        		headerData.getTotalValue(),
        		headerData.getTransactionId());
    }

    public void saveAll(List<HeaderData> headerDataList) {
        for (HeaderData headerData : headerDataList) {
            save(headerData);
        }
    }
}

