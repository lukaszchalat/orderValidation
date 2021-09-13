package de.lukaszchalat.orderValidation.request.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.lukaszchalat.orderValidation.request.entity.ValidationRequest;
import de.lukaszchalat.orderValidation.request.repository.ValidationRequestRepository;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/api/requests", tags="Request Validation Webservice", consumes = "JSON", produces = "JSON")
@RestController
@RequestMapping("/api/request")
public class ValidationRequestWebservice {

	@Autowired
	private ValidationRequestRepository repository;
	
	@GetMapping("/all")
    public ResponseEntity<List<ValidationRequest>> getAllRequests() {
		List<ValidationRequest> allRequests = new ArrayList<>();
		
		repository.findAll().forEach(allRequests::add);
		
		return new ResponseEntity<List<ValidationRequest>>(allRequests, HttpStatus.OK);
	}
}
