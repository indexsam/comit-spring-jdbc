package org.comit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.comit.spring.bean.Customer;
import org.comit.spring.bean.PickUp;
import org.comit.spring.bean.ServiceType;
import org.comit.spring.bean.ShopingCart;
import org.comit.spring.bean.Transaction;
import org.comit.spring.service.CustomerService;
import org.comit.spring.service.PickUpService;
import org.comit.spring.service.ServiceTypeService;
import org.comit.spring.service.ShopingCartService;
import org.comit.spring.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ServiceTypeService servicetypeService;
	
	@Autowired
	ShopingCartService shopingcartService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	PickUpService pickupService;
	
	
	@ModelAttribute("servicetypebridal")
	List<ServiceType> listServiceTypeBridal() {
		
		return this.servicetypeService.listServiceTypeBridal();
	}
	
	@ModelAttribute("servicetypewinter")
	List<ServiceType> listServiceTypeWinter() {
		
		return this.servicetypeService.listServiceTypeWinter();
	}
	
	@ModelAttribute("servicetypesummer")
	List<ServiceType> listServiceTypeSummer() {
		
		return this.servicetypeService.listServiceTypeSummer();
	}
	
	@ModelAttribute("shopingcartservice")
	public List<ShopingCart> listShopingCart() {
		
		return this.shopingcartService.listShopingCart();
	}
	
	

	
	
	@GetMapping("/")
	String index() {
		
		this.customerService.idU();
		
		return "index";
	}
	
	
	// ACTION POINTS
	
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
		
		this.customerService.createUser(customer); // the customer object is used (see CustomerDao)
		
		ra.addFlashAttribute("operation", "create"); // (variable, value) returned
		
		return "redirect:/";  // home page
	}
	
	
	@PostMapping("/schedule")   // ACTION FOR '/pickup'
	String createPickup(PickUp pickup, RedirectAttributes ra) {
		
		this.logger.debug("Creating pick up schedule, {}", pickup.toString());
		
				
		this.pickupService.createPickup(pickup); // 
		
		ra.addFlashAttribute("operation", "schedule"); // (variable, value) returned
		
		return "redirect:/";  // home page
	}
	
	
	
	
	
	 // ACTION FOR '/cart'
	@GetMapping("/addcart/{id}")
	ModelAndView addCart(@PathVariable int id) {
		
		this.servicetypeService.findItem(id);
		
		List<ShopingCart> cart = this.shopingcartService.listShopingCart();
		
		return new ModelAndView("Cartfile","cart", cart);
	}
	
	
	
	
	@GetMapping("/deletecart")
	String deleteCart(RedirectAttributes ra) {
		
		this.servicetypeService.deleteItem();
		
		ra.addFlashAttribute("operation", "delete");	
		
		return "redirect:/";
	}
	
	
	// VIEWS
	@GetMapping("/register")
	String registerCustomer(Customer customer) {
		
		return "register";  // customer model sent in automatically, for a controller object. ONLY for 1 controller object!!!
	}
	
	
	@GetMapping("/pickup")
	ModelAndView pickupCall(PickUp pickup) {
		
		return new ModelAndView( "pickup", "pickup", pickup); // sending in the pickup model 
	}
	
	@GetMapping("/contact")
	String contactUs() {
		
		return "contact";
	}
	
	@GetMapping("/pickupvoucher")
	ModelAndView  pickupSchedule(Transaction transaction) {
		
		this.servicetypeService.CheckoutItem();
		
		transaction = transactionService.transCustomer();
		
		return new ModelAndView("pickupvoucher","transaction", transaction);
	}
	
	
	//  The list of services end points
	@GetMapping("/bridalList")
	String bridalList(ServiceType serviceType) {
		
		return "bridallist";
	}
	
	@GetMapping("/winter")
	String winterList(ServiceType serviceType) {
		
		return "winter";
	}
	
	@GetMapping("/summer")
	String sumerList(ServiceType serviceType) {
		
		return "summer";
	}
	
	@GetMapping("/shoppingcart")
	String shoppingCart(ServiceType serviceType) {
		
		return "ViewCartfile";
	}
	
	 // validating email
		private void validateEmail(Customer customer, BindingResult binding) {
		
		
		if (Optional.ofNullable(this.customerService.findUserEmail(customer)).isPresent()) {
			binding.addError(new FieldError("customer","email", customer.getEmail(), 
					false, null, null, "* Email already taken."));
		}
	}
		
		// validating phone numbers
		private void validatePhone(Customer customer, BindingResult binding) {
			
			
			if (Optional.ofNullable(this.customerService.findUserPhone(customer)).isPresent()) {
				binding.addError(new FieldError("customer","phoneNumber",customer.getPhoneNumber(), 
						false, null, null, "* Phone Number already exist."));
			}
		}
}
