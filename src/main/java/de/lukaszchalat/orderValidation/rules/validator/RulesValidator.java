package de.lukaszchalat.orderValidation.rules.validator;

import java.util.ArrayList;
import java.util.List;

import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.rules.model.ValidationRule;
import de.lukaszchalat.orderValidation.rules.response.ValidationResponse;

public class RulesValidator {
	
	private final Order order;
	
	public RulesValidator(Order order) {
		this.order = order;
	}
	
	public ValidationResponse validate() {
		List<ValidationRule> validationRules = RulesProvider.provideValidationRules(order.getType());
		List<String> errorMessages = new ArrayList<>();
		
		for(ValidationRule rule : validationRules) {
			if(!rule.validate(order)) {
				errorMessages.add(rule.getErrorMessage());
			}
		}
		
		return new ValidationResponse(errorMessages.isEmpty(), errorMessages);
	}

}
