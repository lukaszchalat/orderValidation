package de.lukaszchalat.orderValidation.rules.model;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.order.model.ReplacementOrder;

public class ValidFactoryOrderNumberRule implements ValidationRule {
	
	private final String factoryOrderNumberFormat = "[a-zA-Z]{2}[0-9]{8}";

	@Override
	public boolean validate(Order order) {
		String factoryOrderNumber = ((ReplacementOrder) order).getFactoryOrderNumber();
		
		return factoryOrderNumber != null && !factoryOrderNumber.isBlank() 
			&& factoryOrderNumber.matches(factoryOrderNumberFormat);
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.FACTORY_ORDER_NUMBER_HAS_WRONG_FORMAT.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.REPLACEMENT;
	}

}
