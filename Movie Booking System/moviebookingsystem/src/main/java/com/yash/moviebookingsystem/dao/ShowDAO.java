package com.yash.moviebookingsystem.dao;

import com.yash.moviebookingsystem.model.Screen;

public interface ShowDAO {

	Screen getScreen(String screenName);

	boolean addShows(String screenName);

}
