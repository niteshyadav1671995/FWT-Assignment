package com.yash.moviebookingsystem.serviceimpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.service.MovieService;

public class MovieServiceImplTest {

	private MovieDAO movieDao = mock(MovieDAO.class);
	private MovieService movieService = new MovieServiceImpl(movieDao);

	@Test(expected = NullFieldException.class)
	public void addMovie_GivenMovieObjectAndScreenNameIsNull_ThrowNullFieldException() {
		Movie movie = null;
		String screenName = null;
		movieService.addMovie(screenName, movie);
	}

	@Test(expected = NullFieldException.class)
	public void addMovie_GivenMovieObjectIsNull_ThrowNullFieldException() {
		Movie movie = null;
		String screenName = "Screen 1";
		movieService.addMovie(screenName, movie);
	}

	@Test(expected = NullFieldException.class)
	public void addMovie_GivenScreenNameIsNull_ThrowNullFieldException() {
		Movie movie = new Movie("Parmanu", "1:50:00", "abc", "John Abrahim");
		String screenName = null;
		movieService.addMovie(screenName, movie);
	}

	@Test(expected = EmptyFieldException.class)
	public void addMovie_GivenScreenNameIsEmptyAndMovieObjectIsCorrect_ThrowEmptyFieldException() {
		Movie movie = new Movie("Parmanu", "1:50:00", "abc", "John Abrahim");
		String screenName = "";
		movieService.addMovie(screenName, movie);
	}

	@Test(expected = EmptyFieldException.class)
	public void addMovie_GivenScreenNameIsCorrectAndAnyFieldInMovieObject_ThrowEmptyFieldException() {
		Movie movie = new Movie("", "1:50:00", "abc", "John Abrahim");
		String screenName = "Screen 1";
		movieService.addMovie(screenName, movie);
	}

	@Test
	public void addMovie_GivenScreenNameAndMovieObjectIsCorrect_ShouldReturnTrue() {
		Movie movie = new Movie("Parmanu", "1:50:00", "abc", "John Abrahim");
		String screenName = "Screen 1";
		when(movieDao.insert(screenName, movie)).thenReturn(true);
		assertTrue(movieService.addMovie(screenName, movie));
	}

	@Test
	public void addMovie_GivenScreenNameIsNotAvailableAndMovieObjectIsCorrect_ShouldReturnTrue() {
		Movie movie = new Movie("Parmanu", "1:50:00", "abc", "John Abrahim");
		String screenName = "Screen 1";
		when(movieDao.checkScreenAvailable(screenName)).thenReturn(false);
		assertFalse(movieService.addMovie(screenName, movie));
	}

}
