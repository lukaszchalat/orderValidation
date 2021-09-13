package de.lukaszchalat.orderValidation.util;

import static de.lukaszchalat.orderValidation.enums.ValidationTypeEnum.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import de.lukaszchalat.orderValidation.enums.DepartmentEnum;

import de.lukaszchalat.orderValidation.order.model.AnalysisOrder;
import de.lukaszchalat.orderValidation.order.model.Part;
import de.lukaszchalat.orderValidation.order.model.RepairOrder;
import de.lukaszchalat.orderValidation.order.model.ReplacementOrder;

public class TestDataProvider {
	
	private static final String ANALYSIS_JSON_STRING; 
	private static final String REPAIR_JSON_STRING;
	private static final String REPLACEMENT_JSON_STRING;
	
	static {
		ANALYSIS_JSON_STRING = "{ \"type\" : \"ANALYSIS\", \"department\"	: \"GOoD analysis department\", \"startDate\"	: \"2020-08-13\" , \"endDate\"	: \"2020-08-15\" , \"currency\"	: \"USD\" , \"cost\" : 123.12 , \"parts\"	: [{ \"inventoryNumber\"	: \"InventoryNumber1\" , \"name\" : \"PartNumber1\"	, \"count\"	: 1 } , { \"inventoryNumber\"	: \"InventoryNumber2\"	, \"name\" : \"PartNumber2\"	, \"count\"	: 2 }]}";
		REPAIR_JSON_STRING = "{ \"type\" : \"REPAIR\"	, \"department\"	: \"GOoD repair department\"	, \"startDate\"	: \"2020-08-13\" , \"endDate\"	: \"2020-08-16\" , \"analysisDate\"	: \"2020-08-14\" , \"testDate\"	: \"2020-08-15\" , \"responsiblePerson\"	: \"GOdD responsiblePerson\"	, \"currency\"	: \"USD\" , \"cost\" : 123.12 , \"parts\"	: [{ \"inventoryNumber\"	: \"InventoryNumber3\"	, \"name\" : \"PartNumber3\"	, \"count\"	: 3 } , { \"inventoryNumber\"	: \"InventoryNumber4\" , \"name\" : \"PartNumber4\"	, \"count\"	: 4 }]}";
		REPLACEMENT_JSON_STRING = "{ \"type\" : \"REPLACEMENT\"	, \"department\"	: \"GOoD  replacementdepartment\"	, \"startDate\"	: \"2020-08-13\" , \"endDate\"	: \"2020-08-16\" , \"factoryName\"	: \"GOoD factory\"	, \"factoryOrderNumber\"	: \"DE12345678\"	, \"currency\"	: \"USD\" , \"cost\" : 123.12 , \"parts\" : [{ \"inventoryNumber\"	: \"InventoryNumber5\"	, \"name\" : \"PartNumber5\"	, \"count\"	: 5 } ,\r\n"
				+ "{ \"inventoryNumber\"	: \"InventoryNumber6\"	, \"name\" : \"PartNumber6\"	, \"count\"	: 6 }]}";
	}

	public static String provideAnalysisJsonString() {
		return ANALYSIS_JSON_STRING;
	}

	public static String provideRepairJsonString() {
		return REPAIR_JSON_STRING;
	}

	public static String provideReplacementJsonString() {
		return REPLACEMENT_JSON_STRING;
	}

	public static AnalysisOrder provideTestAnalysisOrder() {
		AnalysisOrder  order = new AnalysisOrder();
		
		order.setType(ANALYSIS.name());
		order.setDepartment(DepartmentEnum.ANALYSIS.getDepartmentName());
		order.setStartDate(LocalDate.of(2020, 8, 13));
		order.setEndDate(LocalDate.of(2020, 8, 16));
		order.setCurrency("USD");
		order.setCost(BigDecimal.valueOf(123.12));
		
		Part part1 = new Part("InventoryNumber1", "PartNumber1", 1);
		Part part2 = new Part("InventoryNumber2", "PartNumber2", 2);
		Part[] parts = {part1, part2};
		
		order.setParts(parts);
		
		return order;
	}
	
	public static RepairOrder provideTestRepairOrder() {
		RepairOrder  order = new RepairOrder();
		
		order.setType(REPAIR.name());
		order.setDepartment(DepartmentEnum.REPAIR.getDepartmentName());
		order.setStartDate(LocalDate.of(2020, 8, 13));
		order.setAnalysisDate(LocalDate.of(2020, 8, 14));
		order.setEndDate(LocalDate.of(2020, 8, 16));
		order.setTestDate(LocalDate.of(2020, 8, 15));
		order.setResponsiblePerson("GOdD responsiblePerson");
		order.setCurrency("USD");
		order.setCost(BigDecimal.valueOf(123.12));
		
		Part part1 = new Part("InventoryNumber3", "PartNumber3", 3);
		Part part2 = new Part("InventoryNumber4", "PartNumber4", 4);
		Part[] parts = {part1, part2};
		
		order.setParts(parts);
		
		return order;
	}
	
	public static ReplacementOrder provideTestReplacementOrder() {
		ReplacementOrder  order = new ReplacementOrder();
		
		order.setType(REPLACEMENT.name());
		order.setDepartment(DepartmentEnum.REPLACEMENT.getDepartmentName());
		order.setStartDate(LocalDate.of(2020, 8, 13));
		order.setEndDate(LocalDate.of(2020, 8, 16));
		order.setFactoryName("GOoD factory");
		order.setFactoryOrderNumber("DE12345678");
		order.setCurrency("USD");
		order.setCost(BigDecimal.valueOf(123.12));
		
		Part part1 = new Part("InventoryNumber5", "PartNumber5", 5);
		Part part2 = new Part("InventoryNumber6", "PartNumber6", 6);
		Part[] parts = {part1, part2};
		
		order.setParts(parts);
		
		return order;
	}

}
