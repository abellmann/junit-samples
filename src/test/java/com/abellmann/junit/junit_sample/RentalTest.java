package com.abellmann.junit.junit_sample;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class RentalTest {
	@Test
	public void verifyStoreInteractions() {
		Movie movie = mock(Movie.class);
		Rental rental = a.rental.w(movie).build();
		Store store = mock(Store.class);
		rental.start(store);
		verify(store).getAvailability(movie);
		verifyNoMoreInteractions(store);
	}
	  @Test
	  public void rentalIsStartedIfInStore() {
	    Movie movie = a.movie.build();
	    Rental rental =
	      a.rental.w(movie).build();
	    Store store = mock(Store.class);
	    when(store.getAvailability(movie))
	      .thenReturn(1);
	    rental.start(store);
	    assertTrue(rental.isStarted());
	    verify(store).remove(movie);
	  }

	}