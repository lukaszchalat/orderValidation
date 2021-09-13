package de.lukaszchalat.orderValidation.order.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.lukaszchalat.orderValidation.order.model.Order;
import de.lukaszchalat.orderValidation.request.entity.ValidationRequest;
import de.lukaszchalat.orderValidation.request.repository.ValidationRequestRepository;
import de.lukaszchalat.orderValidation.rules.response.ValidationResponse;
import de.lukaszchalat.orderValidation.rules.validator.RulesValidator;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "/", tags="Order Validation Controller")
@Controller
public class OrderValidationController {
	
	@Autowired
	private ValidationRequestRepository repository;

	@GetMapping("/")
	public String formPage() {
		
		return "validationForm";
	}
	
	@PostMapping("/validate")
	public String validateOrder(@RequestParam("order") String orderJsonString, Model model) {
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Order order = objectMapper.readValue(orderJsonString, Order.class);
			ValidationResponse response = new RulesValidator(order).validate();
			String responseJsonString = objectMapper.writeValueAsString(response);
			
			saveValidationRequest(response, order);
			
			model.addAttribute("order", orderJsonString);
			model.addAttribute("response", responseJsonString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "validationForm";
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
