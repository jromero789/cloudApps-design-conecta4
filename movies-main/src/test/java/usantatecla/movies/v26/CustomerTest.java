package usantatecla.movies.v26;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void withoutRentalsTest() {
		Customer customer = new CustomerBuilder().build();

		String statement = customer.statement();

		String result = new StatementBuilder()
				.totalAmount(0)
				.frequentRenterPoints(0)
				.build();

		assertEquals(result, statement);
	}

	@Test
	public void regularRental1DayTest() {
		String statement = statementRegularRental(1);

		String result = new StatementBuilder()
				.movie(2)
				.totalAmount(2)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}

	private String statementRegularRental(int daysRented) {
		Movie movie = new MovieBuilder().regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(daysRented).build();
		Customer customer = new CustomerBuilder().rental(rental).build();

		return customer.statement();
	}
	
	@Test
	public void regularRental2DayTest() {
		String statement = statementRegularRental(2);

		String result = new StatementBuilder()
				.movie(2)
				.totalAmount(2)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}

	@Test
	public void regularRental3DayTest() {
		String statement = statementRegularRental(3);

		String result = new StatementBuilder()
				.movie(3.5)
				.totalAmount(3.5)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental1DayTest() {
		String statement = statementNewRelease(1);

		String result = new StatementBuilder()
				.movie(3)
				.totalAmount(3)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}

	private String statementNewRelease(int daysRented) {
		Movie movie = new MovieBuilder().newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(daysRented).build();
		Customer customer = new CustomerBuilder().rental(rental).build();

		return customer.statement();
	}
	
	@Test
	public void newReleaseRental2DayTest() {
		String statement = statementNewRelease(2);

		String result = new StatementBuilder()
				.movie(3)
				.totalAmount(3)
				.frequentRenterPoints(2)
				.build();

		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental3DayTest() {
		String statement = statementNewRelease(3);

		String result = new StatementBuilder()
				.movie(3)
				.totalAmount(3)
				.frequentRenterPoints(2)
				.build();

		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental1DayTest() {
		String statement = statementChildrens(1);

		String result = new StatementBuilder()
				.movie(1.5)
				.totalAmount(1.5)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}

	private String statementChildrens(int daysRented) {
		Movie movie = new MovieBuilder().childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(daysRented).build();
		Customer customer = new CustomerBuilder().rental(rental).build();

		return customer.statement();
	}
	
	@Test
	public void childrensRental3DayTest() {
		String statement = statementChildrens(3);

		String result = new StatementBuilder()
				.movie(1.5)
				.totalAmount(1.5)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental4DayTest() {
		String statement = statementChildrens(4);

		String result = new StatementBuilder()
				.movie(6)
				.totalAmount(6)
				.frequentRenterPoints(1)
				.build();

		assertEquals(result, statement);
	}
	
	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();
		
		Customer customer = new CustomerBuilder()
				.rental(regularRental)
				.rental(newReleaseRental)
				.rental(childrensRental)
				.build();

		String statement = customer.statement();

		String result = new StatementBuilder()
				.movie(regularMovieName, 14)
				.movie(newReleaseMovieName, 3)
				.movie(childrensMovieName, 15)
				.totalAmount(32)
				.frequentRenterPoints(4)
				.build();

		assertEquals(result, statement);
	}
	
	
}
