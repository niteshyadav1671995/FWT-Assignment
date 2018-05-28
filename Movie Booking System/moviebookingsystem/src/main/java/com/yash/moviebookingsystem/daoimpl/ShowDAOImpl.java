package com.yash.moviebookingsystem.daoimpl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.util.JSONUtil;

public class ShowDAOImpl implements ShowDAO {

	private JSONUtil jsonUtil;

	public ShowDAOImpl(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}

	
	public Screen getScreen(String screenName) {
		Screen screen = null;
		if (screenName == null) {
			throw new NullFieldException("Screen name can not be null");
		}
		if (screenName != null) {
			screen = jsonUtil.getScreenObject(screenName);
		}
		return screen;
	}

	public boolean addShows(String screenName) {
		if (screenName == null) {
			throw new NullFieldException("Screen Name can not null");
		}
		if (screenName.isEmpty()) {
			throw new EmptyFieldException("Screen Name can not be Emoty");
		}
		int hour;
		int id = 100;
		Screen screen = jsonUtil.getScreenObject(screenName);
		String durationinString = screen.getMovie().getDuration();
		Time movieDuration = convertStringTimeToTimeObject(durationinString);
		Time showStartTime = new Time(9, 00, 00);
		Time showEndTime = new Time(0, 0, 0);
		List<Show> listOFShows = new ArrayList<Show>();
		List<Screen> listOfScreen = addShowsToTheList(screenName, id, movieDuration, showStartTime, showEndTime,
				listOFShows);
		jsonUtil.updateListOfScreens(listOfScreen);
		return true;
	}

	private List<Screen> addShowsToTheList(String screenName, int id, Time movieDuration, Time showStartTime,
			Time showEndTime, List<Show> listOFShows) {
		int hour;
		hour = showStartTime.getHours();
		Time[] time = new Time[4];
		for (int i = 0; i < 4; i++) {
			listOFShows.add(new Show(id++, new Time(hour, 0, 0)));
			hour += 4;
			showEndTime.setHours(showStartTime.getHours() + movieDuration.getHours());
			showEndTime.setMinutes(showStartTime.getMinutes()+movieDuration.getMinutes());
			showEndTime.setSeconds(showStartTime.getSeconds()+movieDuration.getSeconds());
			showStartTime.setHours(showStartTime.getHours() + 4);
		}
		List<Screen> listOfScreen = jsonUtil.readListOfScreen();
		for (Screen demoScreen : listOfScreen) {
			if (demoScreen.getName().equalsIgnoreCase(screenName)) {
				demoScreen.setShow(listOFShows);
			}
		}
		return listOfScreen;
	}

	private Time convertStringTimeToTimeObject(String durationinString) {
		String[] timeSlices = durationinString.split(":");
		int hour = Integer.parseInt(timeSlices[0]);
		int min = Integer.parseInt(timeSlices[1]);
		int sec = Integer.parseInt(timeSlices[2]);
		Time movieDuration = new Time(hour, min, sec);
		return movieDuration;
	}

}
