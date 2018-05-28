package com.yash.moviebookingsystem.daoimpl;

import java.util.List;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.exception.ScreenNotAvailableException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.util.JSONUtil;

public class MovieDAOImpl implements MovieDAO {

	private JSONUtil jsonUtil;

	public MovieDAOImpl() {
		jsonUtil = new JSONUtil();
	}

	@Override
	public boolean insert(String screenName, Movie movie) {
		boolean isInserted = false;
		if (checkScreenAvailable(screenName)) {
			isInserted = addMovieToTheScreen(screenName, movie);
		} else {
			throw new ScreenNotAvailableException("Screen Not Available");
		}
		return isInserted;
	}

	private boolean addMovieToTheScreen(String screenName, Movie movie) {
		boolean isInserted;
		List<Screen> listOfScreen = jsonUtil.readListOfScreen();
		for (Screen screenTest : listOfScreen) {
			if (screenTest.getName().equalsIgnoreCase(screenName)) {
				screenTest.setMovie(movie);
			}
		}
		isInserted = jsonUtil.updateListOfScreens(listOfScreen);
		return isInserted;
	}

	@Override
	public boolean checkScreenAvailable(String screenName) {
		boolean isAvailable = false;
		List<Screen> listOfScreen = jsonUtil.readListOfScreen();
		for (Screen screenTest : listOfScreen) {
			if (screenTest.getName().equalsIgnoreCase(screenName) && (screenTest.getMovie() == null)) {
				isAvailable = true;
			}
		}

		return isAvailable;
	}

}
