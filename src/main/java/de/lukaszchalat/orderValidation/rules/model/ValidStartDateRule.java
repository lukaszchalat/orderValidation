package de.lukaszchalat.orderValidation.rules.model;

import java.time.LocalDate;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidStartDateRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		LocalDate startDate = order.getStartDate();
		
		return startDate != null && startDate.isBefore(LocalDate.now());
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.START_DATE_EMPTY_OR_AFTER_NOW.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.ALL;
	}

}
