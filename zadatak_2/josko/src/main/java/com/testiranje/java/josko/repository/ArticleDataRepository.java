package com.testiranje.java.josko.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testiranje.java.josko.model.ArticleData;


@Repository
public class ArticleDataRepository {
    	
	
	private final JdbcTemplate jdbcTemplate;

    public ArticleDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ArticleData articleData) {
        String sql = "INSERT INTO dbo.IDC_S (DepartmentNumber, PluNumber, Quantity, Weight, AmountAbsolute, OriginalItemPrice, TransactionId) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
        		articleData.getDepartmentNumber(),
        		articleData.getPluNumber(),
        		articleData.getQuantity(),
        		articleData.getWeight(),
        		articleData.getAmountAbsolute(),
        		articleData.getOriginalItemPrice(),
        		articleData.getTransactionId());
    }

    public void saveAll(List<ArticleData> articleDataList) {
        for (ArticleData articleData : articleDataList) {
            save(articleData);
        }
    }
}

