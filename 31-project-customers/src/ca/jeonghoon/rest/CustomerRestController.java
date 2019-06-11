package ca.jeonghoon.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.jeonghoon.entity.*;
import ca.jeonghoon.entity.payment.*;
import ca.jeonghoon.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private List<Customer> customers;

	// initialize data
	@PostConstruct
	public void loadData() {
		customers = new ArrayList<Customer>();

		// initialize data
		try {
			
			customers.add(new Customer(10, "James", "Smith", new SimpleDateFormat("yyyy-MM-dd").parse("1983-12-10"),
					new ArrayList<String>(Arrays.asList("smith0908@gmail.com")), "514-123-1234", Customer.Gender.M,
					new Address("1234", "Grand Boulevard", "Montreal", "Quebec", "Canada", "H4B2Y1"),
					new MasterCard("James", "1234567890123456", 123.40, 2000.0)));

			customers.add(new Customer(20, "Thomas", "Cory", new SimpleDateFormat("yyyy-MM-dd").parse("1977-05-01"),
					new ArrayList<String>(Arrays.asList("thomas.cory@gmail.com", "cory0501@hotmail.com")), "414-111-6578",
					Customer.Gender.M, new Address("21275", "Lakeshore", "Sainte-Anne-de-Bellevue", "Quebec", "Canada", "H9X3L9"),
					new MasterCard("Thomas", "2345678901234567", 1341.0, 3000.0)));

			customers.add(new Customer(30, "Kelly", "Vitor", new SimpleDateFormat("yyyy-MM-dd").parse("1990-11-26"),
					new ArrayList<String>(Arrays.asList("kelly452@gmail.com")), "783-123-9999",
					Customer.Gender.F, new Address("21", "Shebrooke", "Montreal", "Quebec", "Canada", "H2B1A3"),
					new MasterCard("Kelly", "1234567890123456", 123.40, 2000.0)));

			customers.add(new Customer(40, "Chalie", "Morton", new SimpleDateFormat("yyyy-MM-dd").parse("1985-12-02"),
					new ArrayList<String>(Arrays.asList("chalie@gmail.com", "chalie123@yahoo.com")), "511-333-2334",
					Customer.Gender.M, new Address("48", "Coolbrook", "Toronto", "Ontario", "Canada", "H3C3A2"),
					new MasterCard("Chalie", "1234567890123456", 0.0, 5000.0)));

			customers.add(new Customer(50, "Alexa", "Kim", new SimpleDateFormat("yyyy-MM-dd").parse("1988-07-15"),
					new ArrayList<String>(Arrays.asList("alexa.kim@gmail.com")), "567-2341-0098",
					Customer.Gender.F, new Address("4350 ", "Saint-Catherine", "Westmount", "Quebec", "Canada", "H3Z1R1"),
					new MasterCard("James", "1234567890123456", 123.40, 2000.0)));

			customers.add(new Customer(60, "Maria", "Smith", new SimpleDateFormat("yyyy-MM-dd").parse("1990-11-26"),
					new ArrayList<String>(Arrays.asList("maria@gmail.com", "maria.smith@hotmail.com")), "514-123-1234",
					Customer.Gender.F, new Address("21", "Shebrooke", "Montreal", "Quebec", "Canada", "H2B1A3"),
					new MasterCard("James", "1234567890123456", 123.40, 2000.0)));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Define end point for "/customers" - which returns a list of customers without parameter
//	@GetMapping("/customers")
//	public List<Customer> getCustomers() {
//		return customers;
//	}
	
	// sort using parameters
	// Define end point for "/customers" - which returns a list of customers by parameter
	// Sort by name, sort by family, sort by city, sort by id(default)
	// Order by ascending(0, default), descending(1)
	@GetMapping("/customers")
	public List<Customer> getStudentsWithParam(@RequestParam("sort") Optional<String> sortBy,
			@RequestParam("order") Optional<Integer> orderBy) {

		boolean descOrder = (orderBy.isPresent() && orderBy.get() == 1);

		if (sortBy.isPresent()) {
			if ("name".equalsIgnoreCase(sortBy.get())) { // sort by name
				if (descOrder) {
					return customers.stream()
							.sorted(Comparator.comparing(Customer::getName).reversed())
							.collect(Collectors.toList());
				}
				return customers.stream().sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
			} else if ("family".equalsIgnoreCase(sortBy.get())) { // sort by family
				if (descOrder) {
					return customers.stream()
							.sorted(Comparator.comparing(Customer::getFamily).reversed())
							.collect(Collectors.toList());
				}
				return customers.stream().sorted(Comparator.comparing(Customer::getFamily)).collect(Collectors.toList());
			} else if ("city".equalsIgnoreCase(sortBy.get())) { // sort by city
				if (descOrder) {
					return customers.stream()
							.sorted((c1, c2) -> c2.getAddress().getCity().compareTo(c1.getAddress().getCity()))
							.collect(Collectors.toList());
				}
				return customers.stream()
						.sorted((c1, c2) -> c1.getAddress().getCity().compareTo(c2.getAddress().getCity()))
						.collect(Collectors.toList());
			}
		} 
		
		// sort by id (default behavior)
		if (descOrder) {
			return customers.stream().sorted(Comparator.comparingInt(Customer::getId).reversed()).collect(Collectors.toList());
		}
		return customers.stream().sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
	}

// 	@GetMapping("/customers/{customerId}")
	@GetMapping("/customers/{customerId:^[0-9]+$}")
	public Customer getCustomer(@PathVariable int customerId) {
		List<Customer> matched = customers.stream().filter(c -> c.getId() == customerId).collect(Collectors.toList());

		if (matched.size() == 0) {
			throw new CustomerNotFoundException("Customer id doesn't exist - " + customerId);
		}

		return matched.get(0);
	}
	
	// using REGEX to handle city name
	@GetMapping("/customers/{city:^[A-Za-z]+$}")
	public List<Customer> getCustomers(@PathVariable String city) {
		return customers.stream().filter(c -> c.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}
	
	@GetMapping("/customers/city/{city}")
	public List<Customer> getCustomersByCity(@PathVariable String city) {
		return customers.stream().filter(c -> c.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}	

	@GetMapping("/customers/sorted/family")
	public List<Customer> sortCustomersByFamily() {
		return customers.stream().sorted(Comparator.comparing(Customer::getFamily)).collect(Collectors.toList());
	}	
	
	@GetMapping("/customers/find/{family}")
	public List<Customer> getCustomersByFamily(@PathVariable String family) {
		return customers.stream().filter(c-> c.getFamily().equals(family)).collect(Collectors.toList());
	}
	
	// for testing
	// upgrade find method using parameters
/*
	@GetMapping("/customers/find")
	public List<Customer> getCustomersByParameters(@RequestParam("name") Optional<String> name,
			@RequestParam("family") Optional<String> family, @RequestParam("gender") Optional<String> gender) {
		
		if (!name.isPresent() && !family.isPresent() && !gender.isPresent())
			throw new CustomerNotFoundException("No handler found");
		
		List<Customer> result = customers;

		if (name.isPresent()) {
			result = result.stream().filter(c -> c.getName().equals(name.get())).collect(Collectors.toList());
		}

		if (family.isPresent()) {
			result = result.stream().filter(c -> c.getFamily().equals(family.get())).collect(Collectors.toList());
		}

		if (gender.isPresent()) {
			result = result.stream().filter(c -> c.getGender().equals(gender.get())).collect(Collectors.toList());
		}
	
		return result;
	}
*/
}
