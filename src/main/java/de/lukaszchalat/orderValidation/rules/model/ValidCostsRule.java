package de.lukaszchalat.orderValidation.rules.model;

import java.math.BigDecimal;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidCostsRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		return order.getCost().compareTo(BigDecimal.ZERO) > 0;
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.COSTS_IS_LESS_THAN_ZERO.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.ALL;
	}

}
