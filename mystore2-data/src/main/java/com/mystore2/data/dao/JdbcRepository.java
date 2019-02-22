package com.mystore2.data.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JdbcRepository {

	public <T> T query(String sql, SqlParameterSource namedParameters, RowMapper<T> rowMapper);

	public <T> List<T> queryList(String sql, Object[] bind, RowMapper<T> rowMapper);

	public void update(String sql, Object[] bind);
}
