package com.yash.moviebookingsystem.daoimpl;

import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.model.Screen;

public class ShowDAOImpl implements ShowDAO {

	public Screen getScreen(String screenName) {
		if (screenName == null) {
			throw new NullFieldException("Screen name can not be null");
		}
		return null;
	}

	public boolean addShows(String screenName) {
		if (screenName == null) {
			throw new NullFieldException("Screen Name can not null");
		}
		if (screenName.isEmpty()) {
			throw new EmptyFieldException("Screen Name can not be Emoty");
		}

		return true;
	}

}
