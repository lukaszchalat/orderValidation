package de.lukaszchalat.orderValidation.order.model;

import java.util.Objects;

public class Part {
	
	private String inventoryNumber;
	private String name;
	private int count;
	
	public Part() {
		
	}
	
	public Part(String inventoryNumber, String name, int count) {
		super();
		this.inventoryNumber = inventoryNumber;
		this.name = name;
		this.count = count;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, inventoryNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		return count == other.count && Objects.equals(inventoryNumber, other.inventoryNumber)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Part [inventoryNumber=" + inventoryNumber + ", name=" + name + ", count=" + count + "]";
	}
}
