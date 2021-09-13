package de.lukaszchalat.orderValidation.order.model;

import java.util.Arrays;

public class AnalysisOrder extends Order {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "AnalysisOrder [type=" + getType() + ", department=" + getDepartment() + ", startDate="
				+ getStartDate() + ", endDate=" + getEndDate() + ",currency=" + getCurrency()
				+ ", cost=" + getCost() + ", parts=" + Arrays.toString(getParts());
	}
}
