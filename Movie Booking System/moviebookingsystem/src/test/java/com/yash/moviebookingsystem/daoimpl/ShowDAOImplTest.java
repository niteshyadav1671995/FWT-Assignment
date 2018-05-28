package com.yash.moviebookingsystem.daoimpl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.util.JSONUtil;

public class ShowDAOImplTest {

	private ShowDAO showDAO=null;
	private JSONUtil jsonUtil=null;
	
	@Before()
	public void setUp() {
			jsonUtil = new JSONUtil();
			showDAO = new ShowDAOImpl(jsonUtil);
	}
	
	@Test(expected=NullFieldException.class)
	public void addShows_ScreenNameNull_ThrowNullFieldException() {
		String screenName=null;
		showDAO.addShows(screenName);
	}
	
	@Test(expected=EmptyFieldException.class)
	public void addShows_ScreenNameEmpty_ThrowEmptyFieldException() {
		String screenName="";
		showDAO.addShows(screenName);
	}
	
	@Test
	public void addShows_ScreenNameIsCorrect_ShouldReturnTrueIfShowAdded() {
		String screenName="screen 1";
		assertTrue(showDAO.addShows(screenName));
	}
	
	@Test(expected=NullFieldException.class)
	public void getScreen_ScreenNameNull_ThrowNullFieldException() {
		String screenName=null;
		showDAO.getScreen(screenName);
	}
	
	
}
