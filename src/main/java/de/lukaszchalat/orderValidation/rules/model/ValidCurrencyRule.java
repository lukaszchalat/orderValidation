package de.lukaszchalat.orderValidation.rules.model;

import de.lukaszchalat.orderValidation.enums.CurrencyCodeEnum;
import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidCurrencyRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		String currency = order.getCurrency();
		
		return currency != null && CurrencyCodeEnum.checkIfCurrencyExists(currency);
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.CURRENCY_IS_NOT_ISO_CODE.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.ALL;
	}

}
