package de.lukaszchalat.orderValidation.rules.model;

import java.util.Arrays;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidTotalCountRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		int totalCount = Arrays.stream(order.getParts()).mapToInt(x -> x.getCount()).sum();
		
		return totalCount > 0;
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.PARTS_TOTAL_COUNT_LESS_THAN_ZERO.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.REPAIR;
	}

}
