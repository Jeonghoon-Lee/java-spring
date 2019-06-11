package ca.jeonghoon.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.jeonghoon.entity.*;
import ca.jeonghoon.entity.payment.*;
import ca.jeonghoon.exception.PassengerNotFoundException;

@RestController
@RequestMapping("/api")
public class PassengerRestController {

	private List<Passenger> passengers;

	// initialize data
	@PostConstruct
	public void loadData() {
		passengers = new ArrayList<Passenger>();

		// initialize data
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			
			passengers.add(new Passenger(10, "James", "Smith", new SimpleDateFormat("yyyy-MM-dd").parse("1983-12-10"),
					"smith0908@gmail.com", "514-123-1234", Passenger.Gender.M,
					new Address("1234", "Grand Boulevard", "Montreal", "Quebec", "Canada", "H4B2Y1"),
					new MasterCard("James", "1234567890123456", 123.40, 2000.0),
					new Flight("Montreal", LocalDateTime.parse("2019-05-11 17:30", formatter), 
							"Toronto", LocalDateTime.parse("2019-05-11 19:30", formatter))));

			passengers.add(new Passenger(20, "Thomas", "Cory", new SimpleDateFormat("yyyy-MM-dd").parse("1977-05-01"),
					"thomas.cory@gmail.com", "414-111-6578", Passenger.Gender.M, 
					new Address("21275", "Lakeshore", "Sainte-Anne-de-Bellevue", "Quebec", "Canada", "H9X3L9"),
					new MasterCard("Thomas", "2345678901234567", 1341.0, 3000.0),
					new Flight("Montreal", LocalDateTime.parse("2019-05-11 17:30", formatter), 
							"Toronto", LocalDateTime.parse("2019-05-11 19:30", formatter))));

			passengers.add(new Passenger(30, "Kelly", "Vitor", new SimpleDateFormat("yyyy-MM-dd").parse("1990-11-26"),
					"kelly452@gmail.com", "783-123-9999", Passenger.Gender.F, 
					new Address("21", "Shebrooke", "Montreal", "Quebec", "Canada", "H2B1A3"),
					new MasterCard("Kelly", "1234567890123456", 123.40, 2000.0),
					new Flight("Montreal", LocalDateTime.parse("2019-05-11 17:30", formatter), 
							"Paris", LocalDateTime.parse("2019-05-12 02:00", formatter))));

			passengers.add(new Passenger(40, "Chalie", "Morton", new SimpleDateFormat("yyyy-MM-dd").parse("1985-12-02"),
					"chalie123@yahoo.com", "511-333-2334", Passenger.Gender.M, 
					new Address("48", "Coolbrook", "Toronto", "Ontario", "Canada", "H3C3A2"),
					new MasterCard("Chalie", "1234567890123456", 0.0, 5000.0),
					new Flight("Toronto", LocalDateTime.parse("2019-05-13 07:00", formatter), 
							"Montreal", LocalDateTime.parse("2019-05-13 09:00", formatter))));

			passengers.add(new Passenger(50, "Alexa", "Kim", new SimpleDateFormat("yyyy-MM-dd").parse("1988-07-15"),
					"alexa.kim@gmail.com", "567-2341-0098",	Passenger.Gender.F, 
					new Address("4350 ", "Saint-Catherine", "Westmount", "Quebec", "Canada", "H3Z1R1"),
					new MasterCard("James", "1234567890123456", 123.40, 2000.0),
					new Flight("Toronto", LocalDateTime.parse("2019-06-01 11:20", formatter), 
							"New York", LocalDateTime.parse("2019-06-01 12:50", formatter))));

			passengers.add(new Passenger(60, "Maria", "Smith", new SimpleDateFormat("yyyy-MM-dd").parse("1990-11-26"),
					"maria@gmail.com", "514-123-1234",
					Passenger.Gender.F, new Address("21", "Shebrooke", "Montreal", "Quebec", "Canada", "H2B1A3"),
					new MasterCard("James", "1234567890123456", 123.40, 2000.0),
					new Flight("Toronto", LocalDateTime.parse("2019-06-03 08:30", formatter), 
							"Seattle", LocalDateTime.parse("2019-06-03 12:30", formatter))));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Define end point for "/Passengers" - which returns a list of Passengers without parameter
	@GetMapping("/passengers")
	public List<Passenger> getPassengers() {
		return passengers;
	}
	
 	@GetMapping("/passengers/{passengerId}")
	public Passenger getPassenger(@PathVariable int passengerId) {
		if (0 > passengerId || passengers.size() <= passengerId) {
			throw new PassengerNotFoundException("Passenger id doesn't exist - " + passengerId);
		}

		return passengers.get(passengerId);
	}

	@GetMapping("/passengers/find/{family}")
	public List<Passenger> getPassengersByFamily(@PathVariable String family) {
		return passengers.stream().filter(c-> c.getFamily().equals(family)).collect(Collectors.toList());
	}	
 	
	@GetMapping("/passengers/city/{city}")
	public List<Passenger> getPassengersByCity(@PathVariable String city) {
		return passengers.stream().filter(c -> c.getFlight().getTo().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	@GetMapping("/passengers/sorted/family")
	public List<Passenger> sortPassengersByFamily() {
		return passengers.stream().sorted(Comparator.comparing(Passenger::getFamily)).collect(Collectors.toList());
	}	
	
	@GetMapping("/passengers/find/date/{departureDate}")
	public List<Passenger> getPassengersByDepartureDate(@PathVariable String departureDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return passengers.stream()
				.filter(c -> c.getFlight().getDepartureDate().equals(LocalDate.parse(departureDate,formatter))).collect(Collectors.toList());
	}

	@GetMapping("/passengers/find/date/{date}/city/{city}")
	public List<Passenger> getPassengersByDateAndCity(@PathVariable String date, @PathVariable String city) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return passengers.stream()
				.filter(c -> c.getFlight().getDepartureDate().equals(LocalDate.parse(date, formatter))
						&& c.getFlight().getTo().equals(city))
				.collect(Collectors.toList());
	}
	
	 @DeleteMapping("/passengers/{passengerId}")
	 public String deletePassenger(@PathVariable int passengerId) {
		 if (passengerId < 0 || passengerId > passengers.size()) {
			throw new PassengerNotFoundException("Passenger id doesn't exist - " + passengerId);
		 }
		 passengers.remove(passengerId);
		 
		 return "Deleted Successfully";
	}	
}
