package de.lukaszchalat.orderValidation.order.model;

import java.util.Arrays;
import java.util.Objects;

public class ReplacementOrder extends Order {
	
	private static final long serialVersionUID = 1L;
	
	private String factoryName;
	private String factoryOrderNumber;
	
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getFactoryOrderNumber() {
		return factoryOrderNumber;
	}
	public void setFactoryOrderNumber(String factoryOrderNumber) {
		this.factoryOrderNumber = factoryOrderNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(factoryName, factoryOrderNumber);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplacementOrder other = (ReplacementOrder) obj;
		return Objects.equals(factoryName, other.factoryName)
				&& Objects.equals(factoryOrderNumber, other.factoryOrderNumber);
	}
	
	@Override
	public String toString() {
		return "ReplacementOrder [factoryName=" + factoryName + ", factoryOrderNumber=" + factoryOrderNumber
				+ ", type=" + getType() + ", department=" + getDepartment() + ", startDate="
				+ getStartDate() + ", endDate=" + getEndDate() + ", currency=" + getCurrency()
				+ ", cost=" + getCost() + ", parts=" + Arrays.toString(getParts());
	}
}
