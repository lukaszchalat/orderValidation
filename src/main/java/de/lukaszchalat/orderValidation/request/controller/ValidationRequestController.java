package de.lukaszchalat.orderValidation.request.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.lukaszchalat.orderValidation.request.entity.ValidationRequest;
import de.lukaszchalat.orderValidation.request.repository.ValidationRequestRepository;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/requests", tags="Request Validation Controller")
@Controller
public class ValidationRequestController {
	
	@Autowired
	private ValidationRequestRepository repository;
	
	@GetMapping("/requests")
	public String getAllRequests(Model model) {
		List<ValidationRequest> allRequests = new ArrayList<>();
		
		repository.findAll().forEach(allRequests::add);
		
		model.addAttribute("requests", allRequests);
		
		return "requestsList";
	}

}
