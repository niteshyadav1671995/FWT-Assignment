package com.yash.moviebookingsystem.dao;

import com.yash.moviebookingsystem.model.Screen;

/**
 * This is a dao of creating shows and adding the shows to the screen based on
 * movie.
 * 
 * @author lenovo
 *
 */
public interface ShowDAO {

	/**
	 * This method will return the screen object based on the screen name based
	 * on this object duration and shows will be decided.
	 * 
	 * @param screenName
	 *            Name of the screen.
	 * @return it will return the screen object.
	 */
	Screen getScreen(String screenName);

	/**
	 * This will add the shows to the given screen name.
	 * 
	 * @param screenName
	 *            Name of the screen.
	 * @return It will return when the shows will be added to the screen.
	 */
	boolean addShows(String screenName);

}
