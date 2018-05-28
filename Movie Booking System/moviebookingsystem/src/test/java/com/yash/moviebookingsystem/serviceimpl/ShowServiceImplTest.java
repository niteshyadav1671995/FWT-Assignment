package com.yash.moviebookingsystem.serviceimpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.ShowService;

public class ShowServiceImplTest {

	private ShowDAO showDAO = mock(ShowDAO.class);
	private ShowService showService = new ShowServiceImpl(showDAO);

	@Test(expected = NullFieldException.class)
	public void displayPossibleShows_ScreenNameIsNull_ThrowNullFieldException() {
		showService.displayPossibleShows(null);
	}

	@Test
	public void getScreen_ScreenNameGiven_ShouldReturnTrueIfAvailable() {

		String screenName = "screen 1";
		Screen screen = new Screen(101, "screen 1");
		when(showDAO.getScreen(anyString())).thenReturn(screen);
		boolean isAvailable = showService.checkScreenAvailable(screenName);
		assertTrue(isAvailable);
	}

	@Test
	public void addShows_ScreenNameGiven_ShouldReturnTrueIfShowsAdded() {
		String screenName = "screen 1";
		when(showDAO.addShows(anyString())).thenReturn(true);
		boolean isShowsAdded = showService.addShows(screenName);
		assertTrue(isShowsAdded);
	}

	@Test
	public void addShows_ScreenNameGiven_ShouldReturnFalseIfShowsNotAdded() {
		String screenName = "screen 1";
		when(showDAO.addShows(anyString())).thenReturn(false);
		boolean isShowsAdded = showService.addShows(screenName);
		assertFalse(isShowsAdded);
	}

}
