package com.muhammad.springcrud.dao;

import java.util.List;

import com.muhammad.springcrud.entities.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
