package de.lukaszchalat.orderValidation.rules.response;

import java.util.List;
import java.util.Objects;

public class ValidationResponse {
	
	private boolean valid;
	private List<String> errorMessages;
	
	public ValidationResponse() {
		
	}
	
	public ValidationResponse(boolean valid, List<String> errorMessages) {
		super();
		this.valid = valid;
		this.errorMessages = errorMessages;
	}

	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorMessages, valid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationResponse other = (ValidationResponse) obj;
		return Objects.equals(errorMessages, other.errorMessages) && valid == other.valid;
	}

	@Override
	public String toString() {
		return "ValidationResponse [valid=" + valid + ", errorMessages=" + errorMessages + "]";
	}
}
