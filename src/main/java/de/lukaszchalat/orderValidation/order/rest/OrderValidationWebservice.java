package de.lukaszchalat.orderValidation.order.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.request.entity.ValidationRequest;
import de.lukaszchalat.orderValidation.request.repository.ValidationRequestRepository;
import de.lukaszchalat.orderValidation.rules.response.ValidationResponse;
import de.lukaszchalat.orderValidation.rules.validator.RulesValidator;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/api/order", tags="Order Validation Webservice", consumes = "JSON", produces = "JSON")
@RestController
@RequestMapping("/api/order")
public class OrderValidationWebservice {
	
	@Autowired
	private ValidationRequestRepository repository;

	@PostMapping("/validate")
	public ResponseEntity<ValidationResponse> validate(@RequestBody Order order) {
		
		ValidationResponse response = new RulesValidator(order).validate();
		
		saveValidationRequest(response, order);
		
		return new ResponseEntity<ValidationResponse>(response, HttpStatus.OK);
	}
	
	private void saveValidationRequest(ValidationResponse response, Order order) {
		ValidationRequest request = new ValidationRequest();
		
		request.setReceivingDate(LocalDateTime.now());
		request.setOrderType(order.getType());
		request.setDepartment(order.getDepartment());
		request.setStatus(response.isValid());
		
		repository.save(request);
	}
}
