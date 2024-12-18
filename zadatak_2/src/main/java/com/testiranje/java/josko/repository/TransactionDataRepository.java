package com.testiranje.java.josko.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testiranje.java.josko.model.TransactionData;

@Repository
public class TransactionDataRepository {
    	
	
	private final JdbcTemplate jdbcTemplate;

    public TransactionDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TransactionData transactionData) {
        String sql = "INSERT INTO dbo.IDC_F (CashierNumber, ItemCounter, TotalPrice, TransactionId) "
                   + "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
            transactionData.getCashierNumber(),
            transactionData.getItemCounter(),
            transactionData.getTotalPrice(),
            transactionData.getTransactionId());
    }

    public void saveAll(List<TransactionData> transactionDataList) {
        for (TransactionData transactionData : transactionDataList) {
            save(transactionData);
        }
    }
}
