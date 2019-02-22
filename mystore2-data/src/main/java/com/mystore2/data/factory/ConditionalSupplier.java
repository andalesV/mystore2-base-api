/**
 * 
 */
package com.mystore2.data.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.jooq.Condition;
import org.jooq.impl.DSL;

/**
 * @author victor.t.andales.iii
 *
 */
public class ConditionalSupplier {
	List<Supplier<Condition>> conditionSuppliers = new ArrayList<>();

	public ConditionalSupplier add(boolean isPresent, Supplier<Condition> conditionSupplier) {
		if (isPresent)
			conditionSuppliers.add(conditionSupplier);
		return this;
	}

	public ConditionalSupplier add(Supplier<Condition> conditionSupplier) {
		conditionSuppliers.add(conditionSupplier);
		return this;
	}

	public Condition combineWithAnd() {
		return conditionSuppliers.stream().map(Supplier::get).reduce(DSL.trueCondition(), (a, b) -> a.and(b));
	}

	public Condition combineWithOr() {
		return conditionSuppliers.stream().map(Supplier::get).reduce(DSL.falseCondition(), (a, b) -> a.or(b));
	}
}