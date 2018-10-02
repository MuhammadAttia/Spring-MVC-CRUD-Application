package com.muhammad.springcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.muhammad.springcrud.entities.Customer;
import com.muhammad.springcrud.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomer = customerService.getCustomers();

		theModel.addAttribute("customers", theCustomer);

		return "list-customers";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {

		Customer customer = new Customer();

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showUpdateForm")
	public String UpdateForm(@RequestParam("customerId") int theId, Model theModel) {

		Customer theCustomer = customerService.getCustomer(theId);

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";

	}
}
