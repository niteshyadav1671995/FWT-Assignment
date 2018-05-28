package com.yash.moviebookingsystem.serviceimpl;

import java.sql.Time;

import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.ShowService;

public class ShowServiceImpl implements ShowService {

	private ShowDAO showDAO;

	
	public ShowServiceImpl(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}



	@Override
	public int displayPossibleShows(String screenName) {
		if (screenName == null) {
			throw new NullFieldException("Screen Name can not be null");
		}
		createPossibleShows(screenName);
		return 0;
	}

	private void createPossibleShows(String screenName) {
		Screen screen = showDAO.getScreen(screenName);
		String durationinString = screen.getMovie().getDuration();
		String[] timeSlices = durationinString.split(":");
		int hour = Integer.parseInt(timeSlices[0]);
		int min = Integer.parseInt(timeSlices[1]);
		int sec = Integer.parseInt(timeSlices[2]);
		Time movieDuration = new Time(hour, min, sec);
		Time showStartTime = new Time(9, 00, 00);
		Time showEndTime = new Time(0, 0, 0);
		for (int i = 0; i < 4; i++) {
			showEndTime.setHours(showStartTime.getHours() + movieDuration.getHours());
			System.out.println(showStartTime + " to " + showEndTime);
			showStartTime.setHours(showStartTime.getHours() + 4);
		}
	}

	@Override
	public boolean checkScreenAvailable(String screenName) {
		boolean isAvailable = false;
		System.out.println(showDAO.getScreen(screenName));
		Screen screen = showDAO.getScreen(screenName);

		if (screen.getName().equalsIgnoreCase(screenName)) {
			isAvailable = true;
		}
		return isAvailable;
	}
	
	public boolean addShows(String screenName) {
		boolean isShowsAdded = false;
		if(showDAO.addShows(screenName)) {
			isShowsAdded=true;
		}
		return isShowsAdded;
	}


}
