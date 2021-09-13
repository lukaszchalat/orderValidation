package de.lukaszchalat.orderValidation.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DepartmentEnum {
	ANALYSIS("GOoD analysis department"), 
	REPAIR("GOoD repair department"), 
	REPLACEMENT("GOoD  replacementdepartment");
	
	private String departmentName;
	
	private DepartmentEnum(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public static boolean checkIfDepartmentExists(String department) {
		Optional<String> result = Arrays.asList(values()).stream().map(x -> x.getDepartmentName()).filter(x -> x.equals(department)).findAny();
		
		return result.isPresent();
	}

	public String getDepartmentName() {
		return departmentName;
	}
}
