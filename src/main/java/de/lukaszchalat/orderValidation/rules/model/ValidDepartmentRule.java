package de.lukaszchalat.orderValidation.rules.model;

import de.lukaszchalat.orderValidation.enums.DepartmentEnum;
import de.lukaszchalat.orderValidation.enums.ErrorMessageEnum;
import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.order.model.Order;

public class ValidDepartmentRule implements ValidationRule {

	@Override
	public boolean validate(Order order) {
		String department = order.getDepartment();
		
		return department != null && !department.isBlank() 
				          && DepartmentEnum.checkIfDepartmentExists(order.getDepartment());
	}

	@Override
	public String getErrorMessage() {
		return ErrorMessageEnum.DEPARTMENT_EMPTY_OR_NOT_IN_LIST.getErrorMessage();
	}

	@Override
	public ValidationTypeEnum getType() {
		return ValidationTypeEnum.ALL;
	}

}
