package ca.jeonghoon.rest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.jeonghoon.entity.*;
import ca.jeonghoon.entity.account.CheckingAccount;
import ca.jeonghoon.entity.account.MutualFundAccount;
import ca.jeonghoon.entity.account.NormalSavingAccount;
import ca.jeonghoon.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/bank")
public class BankRestController {

	// initialize data
	@PostConstruct
	public void loadData() {
		Bank bank = Bank.getInstance();

		bank.addCustomer(new Customer(10, "James", new CheckingAccount(100.50)));
		bank.addCustomer(new Customer(20, "Maria", new NormalSavingAccount(2040.00)));
		bank.addCustomer(new Customer(30, "Alexa", new MutualFundAccount(13000.00)));
		bank.addCustomer(new Customer(40, "Jeongsoo", new MutualFundAccount(3500.00)));
		bank.addCustomer(new Customer(50, "Chalie", new CheckingAccount(1735.00)));
	}

	// Define end point for "/customers" - which returns a list of customers by
	// parameter
	// Sort by id, sort by name, sort by balance
	// Order by ascending(0, default), descending(1)
	@GetMapping("/customers")
	public List<Customer> getStudentsWithParam(@RequestParam("sort") Optional<String> sortBy,
			@RequestParam("order") Optional<Integer> orderBy) {

		Stream<Customer> sortedStream = Bank.getInstance().getCustomers().stream();

		boolean descOrder = (orderBy.isPresent() && orderBy.get() == 1);

		if (sortBy.isPresent()) {
			if ("name".equalsIgnoreCase(sortBy.get())) { // sort by name
				sortedStream = descOrder 
						? sortedStream.sorted(Comparator.comparing(Customer::getName).reversed())
						: sortedStream.sorted(Comparator.comparing(Customer::getName));
			} else if ("balance".equalsIgnoreCase(sortBy.get())) { // sort by balance
				sortedStream = descOrder
						? sortedStream.sorted(Comparator.comparingDouble(c -> ((Customer) c).getAccount().getBalance()).reversed())
						: sortedStream.sorted(Comparator.comparingDouble(c -> c.getAccount().getBalance()));
			} else { // sort by id
				sortedStream = descOrder 
						? sortedStream.sorted(Comparator.comparingInt(Customer::getId).reversed())
						: sortedStream.sorted(Comparator.comparingInt(Customer::getId));
			}
		} else { // sort by id (default)
			sortedStream = descOrder 
					? sortedStream.sorted(Comparator.comparingInt(Customer::getId).reversed())
					: sortedStream.sorted(Comparator.comparingInt(Customer::getId));
		}

		return sortedStream.collect(Collectors.toList());
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = Bank.getInstance().getCustomerById(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id doesn't exist - " + customerId);
		}
		return customer;
	}
}
