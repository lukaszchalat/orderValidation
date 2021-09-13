package de.lukaszchalat.orderValidation.rules.model;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.order.model.ReplacementOrder;

public class ValidFactoryNameRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		return ((ReplacementOrder) order).getFactoryName() != null
		    && !((ReplacementOrder) order).getFactoryName().isBlank();
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.FACTORY_NAME_IS_EMPTY.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.REPLACEMENT;
	}

}
