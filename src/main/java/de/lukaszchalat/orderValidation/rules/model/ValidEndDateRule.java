package de.lukaszchalat.orderValidation.rules.model;

import java.time.LocalDate;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidEndDateRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		LocalDate startDate = order.getStartDate();
		LocalDate endDate = order.getEndDate();
		
		return endDate != null && endDate.isAfter(startDate);
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.END_DATE_EMPTY_OR_BEFORE_START_DATE.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.ALL;
	}

}
