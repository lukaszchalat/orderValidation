package de.lukaszchalat.orderValidation.request.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ValidationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDateTime receivingDate;
	
	private String orderType;
	
	private String department;
	
	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(LocalDateTime receivingDate) {
		this.receivingDate = receivingDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, id, orderType, receivingDate, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationRequest other = (ValidationRequest) obj;
		return Objects.equals(department, other.department) && Objects.equals(id, other.id)
				&& Objects.equals(orderType, other.orderType) && Objects.equals(receivingDate, other.receivingDate)
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "ValidationRequest [id=" + id + ", receivingDate=" + receivingDate + ", orderType=" + orderType
				+ ", department=" + department + ", status=" + status + "]";
	}
}
