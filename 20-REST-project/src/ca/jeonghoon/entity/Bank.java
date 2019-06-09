package ca.jeonghoon.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
	
	private volatile static Bank uniqueInstance;
	
    private ArrayList<Customer> customers;

    private Bank() {
        customers = new ArrayList<Customer>();
    }
    
    public static Bank getInstance() {
        if (uniqueInstance == null) {
        	synchronized (Bank.class) {
        		if (uniqueInstance == null) {
        			uniqueInstance = new Bank();
        		}
        	}
        }
        return uniqueInstance;
    }

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
	public Customer getCustomer(int index) {
		return customers.get(index);
	}
	
	public Customer getCustomerById(int id) {
		List<Customer> customerList = customers.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
		
		if (customerList.size() == 1) {
			return customerList.get(0);
		}	
		return null;
	}
    
	public boolean addCustomer(Customer customer) {
		return customers.add(customer);
	}
	
	public boolean deleteCustomer(Customer customer) {
		return customers.remove(customer);
	}
	
}
