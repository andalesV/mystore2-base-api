package com.mystore2.data.dao.impl;

import static com.mystore2.data.constants.Constants.*;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.InsertValuesStep1;
import org.jooq.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mystore2.data.tables.Category;
import com.mystore2.data.tables.records.CategoryRecord;
import com.common.api.custom.exception.MyStoreFatalException;
import com.mystore2.data.dao.CategoryDao;
import com.mystore2.data.dto.CategoryDto;
import com.mystore2.data.mapper.CategoryMapper;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private DSLContext dslContext;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void create(CategoryDto categoryDto) {
		Category category = Category.CATEGORY;

		try (InsertValuesStep1<CategoryRecord, String> query = dslContext.insertInto(category, category.NAME)) {
			query.values(categoryDto.getName());

			String sql = query.getSQL();
			Object[] bind = query.getBindValues().toArray();

			jdbcTemplate.update(sql, bind);
		} catch (Exception e) {
			throw new MyStoreFatalException(e);
		}
	}

	@Override
	public void delete(String code) {
		Category category = Category.CATEGORY;

		try (Query query = dslContext.deleteFrom(category).where(category.CODE.eq(code))) {
			String sql = query.getSQL();
			Object[] bind = query.getBindValues().toArray();

			jdbcTemplate.update(sql, bind);
		} catch (Exception e) {
			throw new MyStoreFatalException(e);
		}
	}

	@Override
	public CategoryDto fetch(String code) {
		Category category = Category.CATEGORY;

		try (Query query = dslContext.select(category.ID, category.CODE, category.NAME).from(category)
				.where(NAMED_PARAMETER_CODE)) {

			SqlParameterSource namedParameters = new MapSqlParameterSource("code", code);
			String sql = query.getSQL();

			return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new CategoryMapper());
		} catch (Exception e) {
			throw new MyStoreFatalException(e);
		}
	}

	@Override
	public List<CategoryDto> fetchAll() {
		try (Query query = dslContext.selectFrom(Category.CATEGORY)) {

			String sql = query.getSQL();

			Object[] bind = query.getBindValues().toArray();

			return jdbcTemplate.query(sql, bind, new CategoryMapper());
		} catch (Exception e) {
			throw new MyStoreFatalException(e);
		}
	}

	@Override
	public void update(CategoryDto categoryDto) {
		Category category = Category.CATEGORY;

		try (Query query = dslContext.update(category).set(category.NAME, categoryDto.getName())
				.where(category.ID.eq(categoryDto.getId()))) {
			String sql = query.getSQL();
			Object[] bind = query.getBindValues().toArray();

			jdbcTemplate.update(sql, bind);
		} catch (Exception e) {
			throw new MyStoreFatalException(e);
		}

	}

}