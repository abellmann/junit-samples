package com.abellmann.junit.junit_sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a {
	public static CustomerBuilder customer = new CustomerBuilder();
	public static RentalBuilder rental = new RentalBuilder();
	public static MovieBuilder movie = new MovieBuilder();
	public static StoreBuilder store = new StoreBuilder();

	public static class CustomerBuilder {
		Rental[] rentals;
		String name;

		CustomerBuilder() {
			this("Jim", new Rental[0]);
		}

		CustomerBuilder(String name, Rental[] rentals) {
			this.name = name;
			this.rentals = rentals;
		}

		public CustomerBuilder w(RentalBuilder... builders) {
			Rental[] rentals = new Rental[builders.length];
			for (int i = 0; i < builders.length; i++) {
				rentals[i] = builders[i].build();
			}
			return new CustomerBuilder(name, rentals);
		}

		public CustomerBuilder w(String name) {
			return new CustomerBuilder(name, rentals);
		}

		public Customer build() {
			Customer result = new Customer(name);
			for (Rental rental : rentals) {
				result.addRental(rental);
			}
			return result;
		}
	}

	public static class RentalBuilder {
		final Movie movie;
		final int days;

		RentalBuilder() {
			this(new MovieBuilder().build(), 3);
		}

		RentalBuilder(Movie movie, int days) {
			this.movie = movie;
			this.days = days;
		}

		public RentalBuilder w(MovieBuilder movie) {
			return new RentalBuilder(movie.build(), days);
		}

		public RentalBuilder w(Movie movie) {
			return new RentalBuilder(movie, days);
		}

		public Rental build() {
			return new Rental(movie, days);
		}
	}

	public static class MovieBuilder {
		final String name;
		final Movie.Type type;

		MovieBuilder() {
			this("Godfather 4", Movie.Type.NEW_RELEASE);
		}

		MovieBuilder(String name, Movie.Type type) {
			this.name = name;
			this.type = type;
		}

		public MovieBuilder w(Movie.Type type) {
			return new MovieBuilder(name, type);
		}

		public MovieBuilder w(String name) {
			return new MovieBuilder(name, type);
		}

		public Movie build() {
			return new Movie(name, type);
		}
	}

	public static class StoreBuilder {

		List<Movie> movieList = new LinkedList<Movie>();
		
		public StoreBuilder(Movie[] movieList) {
			this.movieList.addAll(Arrays.asList(movieList));
		}

		public StoreBuilder() {
			// TODO Auto-generated constructor stub
		}

		public Store build() {
			// TODO Auto-generated method stub
			Map<Movie, Integer> movies = new HashMap<Movie, Integer>();
			for (Movie movieEntry : movieList) {
				if (movies.containsKey(movieEntry)) {
					movies.put(movieEntry, new Integer(movies.get(movieEntry).intValue() + 1));
				} else {
					movies.put(movieEntry, new Integer(1));
				}

			}

			return new Store(movies);

		}

		public StoreBuilder w(Movie... movieList) {
			return new StoreBuilder(movieList);
		}

	}
}