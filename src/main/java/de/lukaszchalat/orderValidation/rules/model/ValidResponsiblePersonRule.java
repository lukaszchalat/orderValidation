package de.lukaszchalat.orderValidation.rules.model;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.order.model.RepairOrder;

public class ValidResponsiblePersonRule implements ValidationRule {
	
	@Override
	public boolean validate(Order order) {
		return ((RepairOrder) order).getResponsiblePerson() != null 
			&& !((RepairOrder) order).getResponsiblePerson().isBlank();
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.RESPONSIBLE_PERSON_IS_EMPTY.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.ALL;
	}

}
