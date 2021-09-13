package de.lukaszchalat.orderValidation.enums;

public enum ErrorMessageEnum {
	
	DEPARTMENT_EMPTY_OR_NOT_IN_LIST("Department is not given or not in the valid department list."),
	START_DATE_EMPTY_OR_AFTER_NOW("Start date is not given or is after now."),
	END_DATE_EMPTY_OR_BEFORE_START_DATE("End date is not given or is not after start date."),
	CURRENCY_IS_NOT_ISO_CODE("Given currency is not ISO CODE 4217."),
	COSTS_IS_LESS_THAN_ZERO("Given costs are less than 0."),
	ANALYSIS_DATE_IS_NOT_BETWEEN_START_AND_END_DATE("Given analysis date has to be between start and end date."),
	RESPONSIBLE_PERSON_IS_EMPTY("Responsible person was not given."),
	TEST_DATE_EMPTY_OR_NOT_BETWEEN_ANALYSIS_AND_END_DATE("Test date is not given or is not between analysis and end date."),
	PARTS_TOTAL_COUNT_LESS_THAN_ZERO("Total count is less than zero."),
	FACTORY_NAME_IS_EMPTY("Factory name is not given."),
	FACTORY_ORDER_NUMBER_HAS_WRONG_FORMAT("Factory order number has wrong format."),
	INVENTORY_NUMBER_IS_EMPTY("None of inventory numbers is not given.");
	
	private String errorMessage;

	private ErrorMessageEnum(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
