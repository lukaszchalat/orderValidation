package de.lukaszchalat.orderValidation.rules.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.lukaszchalat.orderValidation.enums.ValidationTypeEnum.*;

import de.lukaszchalat.orderValidation.enums.ValidationTypeEnum;
import de.lukaszchalat.orderValidation.rules.model.ValidAnalysisDateRule;
import de.lukaszchalat.orderValidation.rules.model.ValidCostsRule;
import de.lukaszchalat.orderValidation.rules.model.ValidCurrencyRule;
import de.lukaszchalat.orderValidation.rules.model.ValidDepartmentRule;
import de.lukaszchalat.orderValidation.rules.model.ValidEndDateRule;
import de.lukaszchalat.orderValidation.rules.model.ValidFactoryNameRule;
import de.lukaszchalat.orderValidation.rules.model.ValidFactoryOrderNumberRule;
import de.lukaszchalat.orderValidation.rules.model.ValidInventoryNumbersRule;
import de.lukaszchalat.orderValidation.rules.model.ValidResponsiblePersonRule;
import de.lukaszchalat.orderValidation.rules.model.ValidStartDateRule;
import de.lukaszchalat.orderValidation.rules.model.ValidTestDateRule;
import de.lukaszchalat.orderValidation.rules.model.ValidTotalCountRule;
import de.lukaszchalat.orderValidation.rules.model.ValidationRule;

public class RulesProvider {

	private static List<ValidationRule> generalRules;
	private static List<ValidationRule> analysisRules;
	private static List<ValidationRule> repairRules;
	private static List<ValidationRule> replacementRules;
	
	static {
		init();
	}
	
	private static void init() {
		generalRules = Arrays.asList(new ValidDepartmentRule(),
				                     new ValidStartDateRule(),
				                     new ValidEndDateRule(),
				                     new ValidCurrencyRule(),
				                     new ValidCostsRule());
		
		analysisRules = new ArrayList<>();
		
		repairRules = Arrays.asList(new ValidAnalysisDateRule(),
				                    new ValidResponsiblePersonRule(),
				                    new ValidTestDateRule(),
				                    new ValidTotalCountRule());
		
		replacementRules = Arrays.asList(new ValidFactoryNameRule(),
				                         new ValidFactoryOrderNumberRule(),
				                         new ValidInventoryNumbersRule());
	}
	
	public static List<ValidationRule> provideValidationRules(String type) {
		List<ValidationRule> validationRules = new ArrayList<>(generalRules);
		
		ValidationTypeEnum enumType = ValidationTypeEnum.valueOf(type);
		
		switch(enumType) {
			case ANALYSIS:
				validationRules.addAll(analysisRules);
				return validationRules;
			case REPAIR:
				validationRules.addAll(repairRules);
				return validationRules;
			case REPLACEMENT:
				validationRules.addAll(replacementRules);
				return validationRules;
			default:
				throw new IllegalArgumentException(type + " type is not supported!");
		}
	}
}
