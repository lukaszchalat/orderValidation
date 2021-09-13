package de.lukaszchalat.orderValidation.rules.model;

import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public interface ValidationRule {

	public boolean validate(Order order);
	
	public String getErrorMessage();
	
	public ValidationTypeEnum getType();
}
