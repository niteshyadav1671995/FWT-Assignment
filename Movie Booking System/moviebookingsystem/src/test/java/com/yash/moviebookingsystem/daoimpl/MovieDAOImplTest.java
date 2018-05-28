package com.yash.moviebookingsystem.daoimpl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.exception.ScreenNotAvailableException;
import com.yash.moviebookingsystem.model.Movie;

public class MovieDAOImplTest {
	
	
	private MovieDAO movieDAO = new MovieDAOImpl();

	@Test
	public void insert_GivenScreenNameNotAvailable_ThrowScreenNotAvailableException() {
		String screenName = "screen 1";
		Movie movie = new Movie("Parmanu", "1:50:00", "abc", "John Abrahim");
		assertTrue(movieDAO.insert(screenName, movie));
	}

}
