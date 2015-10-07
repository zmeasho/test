package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
     private List<Customer> ListOFCustomer = new ArrayList<Customer>();
     
	public InMemoryCustomerRepository() {
		Customer zeray =new Customer("1111", "Zeray", "Verginia", 23);
		Customer Dawit = new Customer("222","Dawit","Seattlle",20);
		Customer filmon =new Customer("333","filmon","california",100);
		Customer simon  = new Customer("444","simona","Vergina",50);
		ListOFCustomer.add(zeray);
		ListOFCustomer.add(Dawit);
		ListOFCustomer.add(filmon);
		ListOFCustomer.add(simon);
		
	}
	

	public List<Customer> getAllCoustomer() {
		
		return ListOFCustomer;
	}
	

}
