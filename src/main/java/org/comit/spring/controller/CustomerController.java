package org.comit.spring.controller;

import java.util.Optional;

import org.comit.spring.bean.Customer;
import org.comit.spring.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import org.comit.spring.service.UserService;

@Controller
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/")
	String index() {
		
		return "index";
	}
	
	@PostMapping("/create")   // ACTION FOR '/register'
	String createUser(Customer customer, RedirectAttributes ra, BindingResult binding) {
		
		this.logger.debug("Creating User, {}", customer.toString());
		
		System.out.println(customer.toString());
		
		this.validateEmail(customer, binding);   
		
		if (binding.hasErrors()) {
			return "register";
		}
		
		this.validatePhone(customer, binding);   
		
		if (binding.hasErrors()) {
			return "register";
		}
		
		this.customerService.createUser(customer);
		
		ra.addFlashAttribute("operation", "create");
		
		return "redirect:/";  // home page
	}
	
	
	// VIEWS
	@GetMapping("/register")
	String registerCustomer(Customer customer) {
		
		return "register";
	}
	
	@GetMapping("/contact")
	String contactUs() {
		
		return "contact";
	}
	
	@GetMapping("/pickup")
	String pickupSchedule() {
		
		return "pickup";
	}
	
	@GetMapping("/bridalList")
	String bridalList() {
		
		return "bridallist";
	}
	
	
		private void validateEmail(Customer customer, BindingResult binding) {
		
		
		if (Optional.ofNullable(this.customerService.findUserEmail(customer)).isPresent()) {
			binding.addError(new FieldError("customer","email", customer.getEmail(), 
					false, null, null, "* Email already taken."));
		}
	}
		
		
		private void validatePhone(Customer customer, BindingResult binding) {
			
			
			if (Optional.ofNullable(this.customerService.findUserPhone(customer)).isPresent()) {
				binding.addError(new FieldError("customer","phoneNumber",customer.getPhoneNumber(), 
						false, null, null, "* Phone Number already exist."));
			}
		}
}
