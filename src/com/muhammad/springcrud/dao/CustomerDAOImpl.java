package com.muhammad.springcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muhammad.springcrud.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		Session theSession = sessionFactory.getCurrentSession();

		Customer customer = theSession.get(Customer.class, theId);

		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session deleteSession = sessionFactory.getCurrentSession();

		Customer customer = deleteSession.get(Customer.class, theId);

		deleteSession.delete(customer);

	}

}
