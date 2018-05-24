package com.yash.moviebookingsystem.serviceimpl;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.exception.SizeExceedsException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	ScreenDAO screenDAO;

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	@Override
	public int addScreen(Screen screen) {
		int rowsAffected = 0;
		if (screen == null) {
			throw new NullFieldException("Screen field is null");
		}
		if (screen.getName().equals("")) {
			rowsAffected = 0;
		}
		if (screenDAO.getScreens().size() > 3) {
			throw new SizeExceedsException("Screens can't more than three");
		}
		if (rowsAffected < 3) {
			rowsAffected = screenDAO.add(screen);
		}

		return rowsAffected;
	}

}
