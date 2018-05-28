package com.yash.moviebookingsystem.service;

/**
 * This is the interface providing service to the shows for a screen on the
 * basis of movie.
 * 
 * @author lenovo
 *
 */
public interface ShowService {

	/**
	 * This method will display the possible show to the operator.
	 * 
	 * @param screenName
	 *            Name of the screen.
	 * @return
	 */
	int displayPossibleShows(String screenName);

	/**
	 * This method will check it screen is available
	 * 
	 * @param screenName
	 *            - Name of the screen.
	 * @return
	 */
	boolean checkScreenAvailable(String screenName);

	/**
	 * This method will add shows to the screen
	 * 
	 * @param screenName
	 * @return
	 */
	boolean addShows(String screenName);

}
