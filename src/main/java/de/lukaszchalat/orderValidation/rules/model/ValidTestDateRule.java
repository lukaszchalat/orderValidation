package de.lukaszchalat.orderValidation.rules.model;

import java.time.LocalDate;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.order.model.RepairOrder;

public class ValidTestDateRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		LocalDate testDate = ((RepairOrder) order).getTestDate();
		LocalDate analysisDate = ((RepairOrder) order).getAnalysisDate();
		LocalDate endDate = order.getEndDate();
		
		return testDate != null && testDate.isAfter(analysisDate) && testDate.isBefore(endDate);
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.TEST_DATE_EMPTY_OR_NOT_BETWEEN_ANALYSIS_AND_END_DATE.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.REPAIR;
	}

}
