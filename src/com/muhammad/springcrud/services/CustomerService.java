package com.muhammad.springcrud.services;

import java.util.List;

import com.muhammad.springcrud.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
		

}
