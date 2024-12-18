package com.testiranje.java.josko.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.testiranje.java.josko.model.RecordHeader;

@Repository
public class RecordHeaderRepository{
	
	private final JdbcTemplate jdbcTemplate;

    public RecordHeaderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer save(RecordHeader recordHeader) {
        String sql = "INSERT INTO RecordHeader (BranchNumber, POSTerminal, DateTime, ReceiptNumber, ItemSequence) "
                   + "VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, recordHeader.getBranchNumber());
            ps.setString(2, recordHeader.getPosTerminal());
            ps.setString(3, recordHeader.getDateTime());
            ps.setString(4, recordHeader.getReceiptNumber());
            ps.setString(5, recordHeader.getItemSequence());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue(); 
    }
}
