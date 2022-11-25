package usantatecla.movies.v26;

public class MovieBuilder {

	final static String DEFAULT_MOVIE_NAME = "movieName";

	private String title;
	
	private Price price;
	
	public MovieBuilder() {
		title = DEFAULT_MOVIE_NAME;
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder childrens() {
		this.price = new ChildrenPrice();
		return this;
	}
	
	public MovieBuilder regular() {
		this.price = new RegularPrice();
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.price = new NewReleasePrice();
		return this;
	}
	
	public Movie build() {
		return new Movie(title, price);
	}
}
