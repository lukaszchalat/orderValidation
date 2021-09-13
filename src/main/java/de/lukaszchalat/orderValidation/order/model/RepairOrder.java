package de.lukaszchalat.orderValidation.order.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class RepairOrder extends Order {
	
	private static final long serialVersionUID = 1L;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate analysisDate;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate testDate;
	private String responsiblePerson;
	
	public LocalDate getAnalysisDate() {
		return analysisDate;
	}
	public void setAnalysisDate(LocalDate analysisDate) {
		this.analysisDate = analysisDate;
	}
	public LocalDate getTestDate() {
		return testDate;
	}
	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(analysisDate, responsiblePerson, testDate);
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
		RepairOrder other = (RepairOrder) obj;
		return Objects.equals(analysisDate, other.analysisDate)
				&& Objects.equals(responsiblePerson, other.responsiblePerson)
				&& Objects.equals(testDate, other.testDate);
	}
	@Override
	public String toString() {
		return "RepairOrder [analysisDate=" + analysisDate + ", testDate=" + testDate + ", responsiblePerson="
				+ responsiblePerson + ", type=" + getType() + ", department=" + getDepartment()
				+ ", startDate=" + getStartDate() + ", endDate=" + getEndDate() + ", currency="
				+ getCurrency() + ", cost=" + getCost() + ", parts=" + Arrays.toString(getParts());
	}
	
	
}
