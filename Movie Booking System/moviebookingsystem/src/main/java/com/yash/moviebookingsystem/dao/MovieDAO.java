package com.yash.moviebookingsystem.dao;

import com.yash.moviebookingsystem.model.Movie;

public interface MovieDAO {

	boolean insert(String screenName, Movie movie);

	boolean checkScreenAvailable(String screenName);

}
