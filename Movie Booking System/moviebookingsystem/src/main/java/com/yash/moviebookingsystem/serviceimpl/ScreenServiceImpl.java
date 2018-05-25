package com.yash.moviebookingsystem.serviceimpl;

import java.util.List;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.daoimpl.ScreenDAOImpl;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.exception.SizeExceedsException;
import com.yash.moviebookingsystem.exception.ValueAlreadyAvailableException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	ScreenDAO screenDAO;

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public ScreenServiceImpl() {
		this.screenDAO = new ScreenDAOImpl();
	}

	@Override
	public int addScreen(Screen screen) {
		int rowsAffected = 0;
		rowsAffected = checkAddingScreenIsPossible(screen, rowsAffected);
		if (screenDAO.getScreens().size() <= 3) {
			rowsAffected = addScreenToList(screen);
		}

		return rowsAffected;
	}

	private int addScreenToList(Screen screen) {
		int rowsAffected;
		List<Screen> listOfScreens = screenDAO.getScreens();
		for (Screen screenTest : listOfScreens) {
			if (screenTest.getName().equalsIgnoreCase(screen.getName())) {
				throw new ValueAlreadyAvailableException("Screen name already exist. Screen name should be unique");
			}
		}

		rowsAffected = screenDAO.add(screen);
		return rowsAffected;
	}

	private int checkAddingScreenIsPossible(Screen screen, int rowsAffected) {
		if (isScreenNull(screen)) {
			throw new NullFieldException("Screen field is null");
		}
		if (isScreenNameEmpty(screen)) {
			rowsAffected = 0;
		}
		if (isNoOfScreenGreaterThenThree()) {
			throw new SizeExceedsException("Screens can't more than three");
		}
		return rowsAffected;
	}

	private boolean isNoOfScreenGreaterThenThree() {
		return screenDAO.getScreens().size() >= 3;
	}

	private boolean isScreenNameEmpty(Screen screen) {
		return screen.getName().equals("");
	}

	private boolean isScreenNull(Screen screen) {
		return screen == null;
	}

}
