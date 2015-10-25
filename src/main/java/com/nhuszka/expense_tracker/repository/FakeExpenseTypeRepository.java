package com.nhuszka.expense_tracker.repository;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.expense_tracker.bean.ExpenseType;
import com.nhuszka.expense_tracker.bean.ExpenseTypeBuilder;

/**
 * Expense Types on-the-fly without DB connection.
 */
public class FakeExpenseTypeRepository extends ExpenseTypeRepository {
	
	private static final String PREFIX = "FakeType";
	
	private enum FakeType {
		ONE, TWO, THREE
	}

	private ExpenseType createExpenseType(final FakeType fakeType) {
		return new ExpenseTypeBuilder()
				.withType(PREFIX + fakeType.name())
				.build();
	}

	@Override
	public List<ExpenseType> listExpenseTypes() {
		List<ExpenseType> fakeTypes = new ArrayList<ExpenseType>();
		for (FakeType type : FakeType.values()) {
			fakeTypes.add(createExpenseType(type));
		}
		return fakeTypes;
	}
}