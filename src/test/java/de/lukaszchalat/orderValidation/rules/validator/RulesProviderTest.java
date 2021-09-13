package de.lukaszchalat.orderValidation.rules.validator;

import static de.lukaszchalat.orderValidation.enums.ValidationTypeEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.lukaszchalat.orderValidation.rules.model.ValidationRule;

public class RulesProviderTest {

	@Test
	public void thatAnalysisRulesAmountIsCorrect() {
		List<ValidationRule> rules = RulesProvider.provideValidationRules(ANALYSIS.name());
		
		assertNotNull(rules);
		assertFalse(rules.isEmpty());
		assertEquals(5, rules.size());
		
	}
	
	@Test
	public void thatRepairRulesAmountIsCorrect() {
		List<ValidationRule> rules = RulesProvider.provideValidationRules(REPAIR.name());
		
		assertNotNull(rules);
		assertFalse(rules.isEmpty());
		assertEquals(9, rules.size());
		
	}
	
	@Test
	public void thatReplacementRulesAmountIsCorrect() {
		List<ValidationRule> rules = RulesProvider.provideValidationRules(REPLACEMENT.name());
		
		assertNotNull(rules);
		assertFalse(rules.isEmpty());
		assertEquals(8, rules.size());
		
	}
}
