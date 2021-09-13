package de.lukaszchalat.orderValidation.rules.model;

import java.util.Arrays;
import java.util.Optional;

import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidInventoryNumbersRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		Optional<String> result = Arrays.stream(order.getParts())
				                        .map(x -> x.getInventoryNumber())
				                        .filter(x -> x.isBlank()).findAny();
		
		return result.isEmpty();
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.INVENTORY_NUMBER_IS_EMPTY.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.REPLACEMENT;
	}

}
