package com.mystore2.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.mystore2.data.dao.JdbcRepository;

@Service
public class JdbcRepositoryImpl implements JdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public <T> T query(String sql, SqlParameterSource namedParameters, RowMapper<T> rowMapper) {
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, rowMapper);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<?> queryList(String sql, Object[] bind, RowMapper rowMapper) {
		return jdbcTemplate.query(sql, bind, rowMapper);
	}

	@Override
	public void update(String sql, Object[] bind) {
		jdbcTemplate.update(sql, bind);
	}

}
