/**
 * 
 */
package com.mystore2.data.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep1;
import org.jooq.InsertValuesStep2;
import org.jooq.InsertValuesStep3;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.conf.ParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mystore2.data.dao.SaleOrderDao;
import com.mystore2.data.dto.SaleOrderDto;
import com.mystore2.data.dto.SaleOrderLineDto;
import com.mystore2.data.factory.ConditionalSupplier;
import com.mystore2.data.mapper.SaleOrderLineMapper;
import com.mystore2.data.mapper.SaleOrderMapper;
import com.mystore2.data.tables.Product;
import com.mystore2.data.tables.ProductSaleOrder;
import com.mystore2.data.tables.SaleOrder;
import com.mystore2.data.tables.SaleOrderLine;
import com.mystore2.data.tables.records.SaleOrderRecord;
import com.mystore2.data.tables.records.SaleOrderLineRecord;
import com.mystore2.data.tables.records.ProductSaleOrderRecord;
import static com.mystore2.data.constants.Constants.*;

/**
 * @author victor.t.andales.iii
 *
 */
@Repository
@Transactional
public class SaleOrderDaoImpl implements SaleOrderDao {

	final static Logger logger = Logger.getLogger(SaleOrderDaoImpl.class);

	@Autowired
	private DSLContext dslContext;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private Record saleOrderLineRecord;

	private ConditionalSupplier conditions;

	@Override
	public int insertSaleOrder(String customer_name) {
		SaleOrder saleOrder = SaleOrder.SALE_ORDER;
		final KeyHolder holderSaleOrder = new GeneratedKeyHolder();

		try (InsertValuesStep1<SaleOrderRecord, String> query = dslContext.insertInto(saleOrder,
				saleOrder.CUSTOMER_NAME)) {
			query.values(customer_name);

			final String sql = query.getSQL();

			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, customer_name);
					return ps;
				}
			};

			jdbcTemplate.update(psc, holderSaleOrder);

			Map<String, Object> generated = holderSaleOrder.getKeys();

			return (int) generated.get(ID);

		} catch (Exception e) {
			logger.error(e);
			return 0;
		}

	}

	@Override
	public List<Integer> batchInsertSaleOrderLine(SaleOrderDto saleOrderDto, int saleOrderId) {
		final KeyHolder holderSaleOrderLine = new GeneratedKeyHolder();

		SaleOrderLine saleOrderLine = SaleOrderLine.SALE_ORDER_LINE;
		try (InsertValuesStep3<SaleOrderLineRecord, Integer, Integer, BigDecimal> query = dslContext
				.insertInto(saleOrderLine, saleOrderLine.PRODUCT_ID, saleOrderLine.QUANTITY, saleOrderLine.AMOUNT)) {

			query.values(saleOrderDto.getSale_order_line().get(0).getProduct_id(),
					saleOrderDto.getSale_order_line().get(0).getQuantity(),
					saleOrderDto.getSale_order_line().get(0).getAmount());

			final String sql = query.getSQL();

			List<Integer> saleOrderLineIds = new ArrayList<>();

			PreparedStatementCreator psc = null;
			for (SaleOrderLineDto saleOrderLineDto : saleOrderDto.getSale_order_line()) {
				psc = new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, saleOrderLineDto.getProduct_id());
						ps.setInt(2, saleOrderLineDto.getQuantity());
						ps.setBigDecimal(3, saleOrderLineDto.getAmount());
						return ps;

					}
				};

				jdbcTemplate.update(psc, holderSaleOrderLine);
				Map<String, Object> generated = holderSaleOrderLine.getKeys();
				saleOrderLineIds.add((Integer) generated.get(ID));
			}
			return saleOrderLineIds;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public void orderProduct(int saleOrderId, List<Integer> saleOrderLineIds) {
		ProductSaleOrder productSaleOrder = ProductSaleOrder.PRODUCT_SALE_ORDER;

		try (InsertValuesStep2<ProductSaleOrderRecord, Integer, Integer> query = dslContext.insertInto(productSaleOrder,
				productSaleOrder.SALE_ORDER_ID, productSaleOrder.SALE_ORDER_LINE_ID)) {

			saleOrderLineIds.forEach(t -> {
				query.values(saleOrderId, t);
			});

			final String sql = query.getSQL();

			Object[] bind = query.getBindValues().toArray();

			jdbcTemplate.update(sql, bind);
		} catch (Exception e) {
			logger.error(e);
		}

	}

	@Override
	public SaleOrderDto getCurrentOrder(int id) {
		SaleOrder saleOrder = SaleOrder.SALE_ORDER;
		SaleOrderLine saleOrderLine = SaleOrderLine.SALE_ORDER_LINE;
		ProductSaleOrder productSaleOrder = ProductSaleOrder.PRODUCT_SALE_ORDER;
		Product product = Product.PRODUCT;

		try (Query query1 = dslContext.select(saleOrder.ID, saleOrder.CUSTOMER_NAME, saleOrder.STATUS,
				saleOrder.CREATED_DATE, saleOrder.LAST_MODIFIED_DATE).from(saleOrder).where(NAMED_PARAMETER_ID)) {

			String sql1 = query1.getSQL();

			SqlParameterSource namedParameters1 = new MapSqlParameterSource(ID, id);

			SaleOrderDto saleDto = new SaleOrderDto();
			saleDto = namedParameterJdbcTemplate.queryForObject(sql1, namedParameters1, new SaleOrderMapper());

			Query query = dslContext
					.select(saleOrderLine.ID, saleOrderLine.PRODUCT_ID, product.PRODUCT_NAME, product.DESCRIPTION,
							saleOrderLine.QUANTITY, saleOrderLine.AMOUNT)
					.from(saleOrderLine).leftJoin(productSaleOrder)
					.on(productSaleOrder.SALE_ORDER_LINE_ID.eq(saleOrderLine.ID)).leftJoin(product)
					.on(saleOrderLine.PRODUCT_ID.eq(product.ID)).where(NAMED_PARAMETER_SALE_ORDER_ID);

			final String sql = query.getSQL();

			SqlParameterSource namedParameters = new MapSqlParameterSource(ID, id);
			List<SaleOrderLineDto> saleOrderLineList = namedParameterJdbcTemplate.query(sql, namedParameters,
					new SaleOrderLineMapper());
			saleDto.setSale_order_line(saleOrderLineList);
			return saleDto;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<SaleOrderDto> viewAllSales() {
		return null;
	}

	@Override
	public void cancelOrder(int orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] batchUpdateSaleOrderLine(SaleOrderDto saleOrderDto, int saleOrderId) {
		SaleOrderLine saleOrderLine = SaleOrderLine.SALE_ORDER_LINE;
		ProductSaleOrder productSaleOrder = ProductSaleOrder.PRODUCT_SALE_ORDER;

		final int size = saleOrderDto.getSale_order_line().size();

		String[] sql = new String[size];

		saleOrderDto.getSale_order_line().forEach(t -> {
			saleOrderLineRecord = new SaleOrderLineRecord();
			saleOrderLineRecord.set(saleOrderLine.QUANTITY, t.getQuantity());
			saleOrderLineRecord.set(saleOrderLine.AMOUNT, t.getAmount());

			conditions = new ConditionalSupplier();
			conditions.add(() -> productSaleOrder.SALE_ORDER_LINE_ID.eq(saleOrderLine.ID));
			conditions.add(() -> productSaleOrder.SALE_ORDER_LINE_ID.eq(t.getId()));
			conditions.add(() -> productSaleOrder.SALE_ORDER_ID.eq(saleOrderId));

			Query query = dslContext.update(saleOrderLine).set(saleOrderLineRecord).from(productSaleOrder)
					.where(conditions.combineWithAnd());

			sql[COUNTER++] = query.getSQL(ParamType.INLINED);

		});

		COUNTER = 0;

		return jdbcTemplate.batchUpdate(sql);

	}

}
