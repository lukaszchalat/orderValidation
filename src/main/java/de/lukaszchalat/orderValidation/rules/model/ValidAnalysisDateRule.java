package de.lukaszchalat.orderValidation.rules.model;

import java.time.LocalDate;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.order.model.RepairOrder;

public class ValidAnalysisDateRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		LocalDate startDate = order.getStartDate();
		LocalDate endDate = order.getEndDate();
		LocalDate analysisDate = ((RepairOrder) order).getAnalysisDate();
		
		return analysisDate.isAfter(startDate) && analysisDate.isBefore(endDate);
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.ANALYSIS_DATE_IS_NOT_BETWEEN_START_AND_END_DATE.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.REPAIR;
	}

}
