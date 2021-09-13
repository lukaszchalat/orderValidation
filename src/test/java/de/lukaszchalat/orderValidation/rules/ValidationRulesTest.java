package de.lukaszchalat.orderValidation.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import de.lukaszchalat.orderValidation.order.model.AnalysisOrder;
import de.lukaszchalat.orderValidation.order.model.RepairOrder;
import de.lukaszchalat.orderValidation.order.model.ReplacementOrder;
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
import de.lukaszchalat.orderValidation.util.TestDataProvider;

public class ValidationRulesTest {
	
	@Test
	public void thatDepartmentRuleIsValid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		
		boolean result = new ValidDepartmentRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatDepartmentRuleIsInvalid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		order.setDepartment(null);
		
		boolean result = new ValidDepartmentRule().validate(order);
		
		assertFalse(result);
		
		order.setDepartment("");
		
		result = new ValidDepartmentRule().validate(order);
		
		assertFalse(result);
		
		order.setDepartment("FAKE");
		
		result = new ValidDepartmentRule().validate(order);
		
		assertFalse(result);
	}
	
	
	@Test
	public void thatStartDateRuleIsValid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		
		boolean result = new ValidStartDateRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatStartDateRuleIsInvalid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		order.setStartDate(null);
		
		boolean result = new ValidStartDateRule().validate(order);
		
		assertFalse(result);
		
		order.setStartDate(LocalDate.of(2020, 8, 17));
		
		assertFalse(result);
	}
	

	@Test
	public void thatEndDateRuleIsValid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		
		boolean result = new ValidEndDateRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatEndDateRuleIsInvalid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		order.setEndDate(null);
		
		boolean result = new ValidEndDateRule().validate(order);
		
		assertFalse(result);
		
		order.setEndDate(LocalDate.of(2020, 8, 12));
		
		result = new ValidEndDateRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatCurrencyRuleIsValid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		
		boolean result = new ValidCurrencyRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatCurrencyRuleIsInvalid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		order.setCurrency("FAKE");
		
		boolean result = new ValidCurrencyRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatCostsRuleIsValid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		
		boolean result = new ValidCostsRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatCostsRuleIsInvalid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		order.setCost(BigDecimal.valueOf(-100));
		
		boolean result = new ValidCostsRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatAnalysisDateRuleIsValid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		
		boolean result = new ValidAnalysisDateRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatAnalysisDateRuleIsInvalid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		order.setAnalysisDate(LocalDate.of(2020, 7, 30));
		
		boolean result = new ValidAnalysisDateRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatResponsiblePersonRuleIsValid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		
		boolean result = new ValidResponsiblePersonRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatResponsiblePersonRuleIsInvalid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		order.setResponsiblePerson(null);
		
		boolean result = new ValidResponsiblePersonRule().validate(order);
		
		assertFalse(result);
		
		order.setResponsiblePerson("");
		
		result = new ValidResponsiblePersonRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatTestDateRuleIsValid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		
		boolean result = new ValidTestDateRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatTestDateRuleIsInvalid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		order.setTestDate(null);
		
		boolean result = new ValidTestDateRule().validate(order);
		
		assertFalse(result);
		
		order.setTestDate(LocalDate.of(2020, 7, 30));
		
		result = new ValidTestDateRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatTotalCountRuleIsValid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		
		boolean result = new ValidTotalCountRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatTotalCountRuleIsInvalid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		order.getParts()[0].setCount(-100);
		
		boolean result = new ValidTotalCountRule().validate(order);
		
		assertFalse(result);
	}

	@Test
	public void thatFactoryNameRuleIsValid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		
		boolean result = new ValidFactoryNameRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatFactoryNameRuleIsInvalid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		order.setFactoryName(null);
		
		boolean result = new ValidFactoryNameRule().validate(order);
		
		assertFalse(result);
		
		order.setFactoryName("");
		
		result = new ValidFactoryNameRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatFactoryOrderNumberRuleIsValid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		
		boolean result = new ValidFactoryOrderNumberRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatFactoryOrderNumberRuleIsInvalid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		order.setFactoryOrderNumber(null);
		
		boolean result = new ValidFactoryOrderNumberRule().validate(order);
		
		assertFalse(result);
		
		order.setFactoryOrderNumber("");
		
		result = new ValidFactoryOrderNumberRule().validate(order);
		
		assertFalse(result);
		
		order.setFactoryOrderNumber("1234567890");
		
		result = new ValidFactoryOrderNumberRule().validate(order);
		
		assertFalse(result);
	}
	
	@Test
	public void thatInventoryNumberRuleIsValid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		
		boolean result = new ValidInventoryNumbersRule().validate(order);
		
		assertTrue(result);
	}
	
	@Test
	public void thatInventoryNumberRuleIsInvalid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		order.getParts()[0].setInventoryNumber("");
		
		boolean result = new ValidInventoryNumbersRule().validate(order);
		
		assertFalse(result);
	}
}
