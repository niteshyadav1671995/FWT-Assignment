package com.yash.moviebookingsystem.serviceimpl;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.daoimpl.MovieDAOImpl;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public MovieServiceImpl() {
		this.movieDAO = new MovieDAOImpl();
	}

	@Override
	public boolean addMovie(String screenName, Movie movie) {
		boolean isAdded = false;
		checkForMovieAndSceenIsValid(screenName, movie);
		isAdded = movieDAO.insert(screenName, movie);
		return isAdded;
	}

	private void checkForMovieAndSceenIsValid(String screenName, Movie movie) {
		if (isScreenNameAndMovieObjectNull(screenName, movie)) {
			throw new NullFieldException("Screen name or movie can not be null.");
		}
		if (isScreenNameEmpty(screenName)) {
			throw new EmptyFieldException("Screen name can not be empty.");
		}
		if (isMovieFieldEmpty(movie)) {
			throw new EmptyFieldException("Any field Of Movie can not be empty.");
		}
	}

	private boolean isMovieFieldEmpty(Movie movie) {
		return movie.getTitle().isEmpty() || movie.getDuration().isEmpty() || movie.getActors().isEmpty()
				|| movie.getProduction().isEmpty();
	}

	private boolean isScreenNameEmpty(String screenName) {
		return screenName.isEmpty();
	}

	private boolean isScreenNameAndMovieObjectNull(String screenName, Movie movie) {
		return screenName == null || movie == null;
	}

}
