package de.lukaszchalat.orderValidation.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type",
		visible = true)
@JsonSubTypes({
		@Type(value = AnalysisOrder.class, name = "ANALYSIS"),
		@Type(value = RepairOrder.class, name = "REPAIR"),
		@Type(value = ReplacementOrder.class, name = "REPLACEMENT")})
public abstract class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String department;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	private String currency;
	private BigDecimal cost;
	private Part[] parts;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Part[] getParts() {
		return parts;
	}
	public void setParts(Part[] parts) {
		this.parts = parts;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(parts);
		result = prime * result + Objects.hash(cost, currency, department, endDate, startDate, type);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(currency, other.currency)
				&& Objects.equals(department, other.department) && Objects.equals(endDate, other.endDate)
				&& Arrays.equals(parts, other.parts) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(type, other.type);
	}
	
	@Override
	public String toString() {
		return "Order [type=" + type + ", department=" + department + ", startDate=" + startDate + ", endDate="
				+ endDate + ", currency=" + currency + ", cost=" + cost + ", parts=" + Arrays.toString(parts) + "]";
	}
}
