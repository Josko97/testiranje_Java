package com.testiranje.java.josko.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testiranje.java.josko.model.AdditionalArticleInformation;


@Repository
public class AdditionalArticleInformationRepository {
    	
	
	private final JdbcTemplate jdbcTemplate;

    public AdditionalArticleInformationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(AdditionalArticleInformation additionalArticleInformation) {
        String sql = "INSERT INTO dbo.IDC_W (ItemInfo, EanUpc, AgeRestriction, Amount, TransactionId) "
                   + "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
            additionalArticleInformation.getItemInfo(),
            additionalArticleInformation.getEanUpc(),
            additionalArticleInformation.getAgeRestriction(),
            additionalArticleInformation.getAmount(),
            additionalArticleInformation.getTransactionId()
        );
    }

    public void saveAll(List<AdditionalArticleInformation> AdditionalArticleInformationList) {
        for (AdditionalArticleInformation additionalArticleInformation : AdditionalArticleInformationList) {
            save(additionalArticleInformation);
        }
    }
}