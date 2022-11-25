package usantatecla.movies.v26;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {

		final String TITLE = "Rental Record for %s\n";
		final String RENT_ITEM = "\t%s\t%s\n";
		final String FOOTER_CHARGE = "Amount owed is %s\n";
		final String FOOTER_POINTS = "You earned %s frequent renter points";

		StringBuilder bld = new StringBuilder();
		bld.append(String.format(TITLE, this.getName()));
		for (Rental rental : rentals) {
			bld.append(String.format(RENT_ITEM, rental.getTitle(), rental.getCharge()));
		}
		bld.append(String.format(FOOTER_CHARGE, this.getTotalCharge()));
		bld.append(String.format(FOOTER_POINTS, this.getTotalFrequentRenterPoints()));
		
		return bld.toString();
	}

	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : rentals) {
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}

}
