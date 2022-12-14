package usantatecla.movies.v25;

import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {

	final static String DEFAULT_CUSTOMER_NAME = "customerName";

	private String name;
	private List<Rental> rentals;
	
	public CustomerBuilder() {
		name = DEFAULT_CUSTOMER_NAME;
		rentals = new ArrayList<Rental>();
	}
	
	public CustomerBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public CustomerBuilder rental(Rental rental) {
		rentals.add(rental);
		return this;
	}
	
	public Customer build() {
		Customer customer = new Customer(name);
		for(Rental rental : rentals) {
			customer.addRental(rental);
		}
		return customer;
	}
}
