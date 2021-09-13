package de.lukaszchalat.orderValidation.rules.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import de.lukaszchalat.orderValidation.order.model.AnalysisOrder;
import de.lukaszchalat.orderValidation.order.model.RepairOrder;
import de.lukaszchalat.orderValidation.order.model.ReplacementOrder;
import de.lukaszchalat.orderValidation.rules.response.ValidationResponse;
import de.lukaszchalat.orderValidation.util.TestDataProvider;

public class RulesValidatorTest {
	
	@Test
	public void thatAnalysisOrderIsValid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		
		ValidationResponse result = new RulesValidator(order).validate();
		
		assertNotNull(result);
		assertTrue(result.isValid());
		assertTrue(result.getErrorMessages().isEmpty());
	}
	
	@Test
	public void thatAnalysisOrderIsInvalid() {
		AnalysisOrder order = TestDataProvider.provideTestAnalysisOrder();
		order.setDepartment("FAKE DEPARTMENT");
		order.setCurrency("FAKE CURRENCY");
		
		ValidationResponse result = new RulesValidator(order).validate();
		
		assertNotNull(result);
		assertFalse(result.isValid());
		assertFalse(result.getErrorMessages().isEmpty());
		assertEquals(2, result.getErrorMessages().size());
	}
	
	@Test
	public void thatRepairOrderIsValid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		
		ValidationResponse result = new RulesValidator(order).validate();
		
		assertNotNull(result);
		assertTrue(result.isValid());
		assertTrue(result.getErrorMessages().isEmpty());
	}
	
	@Test
	public void thatRepairOrderIsInvalid() {
		RepairOrder order = TestDataProvider.provideTestRepairOrder();
		order.setAnalysisDate(LocalDate.of(2020, 7, 30));
		order.setResponsiblePerson(null);
		order.setTestDate(LocalDate.of(2020, 7, 30));
		order.getParts()[0].setCount(-100);
		
		ValidationResponse result = new RulesValidator(order).validate();
		
		assertNotNull(result);
		assertFalse(result.isValid());
		assertFalse(result.getErrorMessages().isEmpty());
		assertEquals(4, result.getErrorMessages().size());
	}
	
	@Test
	public void thatReplacementOrderIsValid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		
		ValidationResponse result = new RulesValidator(order).validate();
		
		assertNotNull(result);
		assertTrue(result.isValid());
		assertTrue(result.getErrorMessages().isEmpty());
	}
	
	@Test
	public void thatReplacementOrderIsInvalid() {
		ReplacementOrder order = TestDataProvider.provideTestReplacementOrder();
		order.setFactoryName(null);
		order.setFactoryOrderNumber("ABC1234567");
		order.getParts()[0].setInventoryNumber("");
		
		ValidationResponse result = new RulesValidator(order).validate();
		
		assertNotNull(result);
		assertFalse(result.isValid());
		assertFalse(result.getErrorMessages().isEmpty());
		assertEquals(3, result.getErrorMessages().size());
	}
}
