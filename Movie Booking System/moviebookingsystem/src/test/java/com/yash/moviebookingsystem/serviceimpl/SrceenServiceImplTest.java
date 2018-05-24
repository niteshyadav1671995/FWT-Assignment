package com.yash.moviebookingsystem.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.exception.NullFieldException;
import com.yash.moviebookingsystem.exception.SizeExceedsException;
import com.yash.moviebookingsystem.exception.ValueAlreadyAvailableException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.ScreenService;

public class SrceenServiceImplTest {

	private ScreenDAO screenDAO = mock(ScreenDAO.class);
	private ScreenService screenService = new ScreenServiceImpl(screenDAO);

	@Test(expected = NullFieldException.class)
	public void addScreen_GivenIfScreenIsNull_ThrowNullFieldException() {
		Screen screen = null;
		screenService.addScreen(screen);
	}

	@Test
	public void addScreen_GivenScreenNameIsEmpty_ShouldReturnZero() {
		Screen screen = new Screen(101, "");
		when(screenDAO.add(any(Screen.class))).thenReturn(0);
		assertEquals(0, screenService.addScreen(screen));
	}

	@Test
	public void addScreen_GivenScreenNameIsCorrect_ShouldReturnOne() {
		Screen screen = new Screen(101, "Screen 1");
		when(screenDAO.add(any(Screen.class))).thenReturn(1);
		assertEquals(1, screenService.addScreen(screen));
	}

	@Test(expected = ValueAlreadyAvailableException.class)
	public void addScreen_GivenScreenNameIsCorrect_ThrowValueAlreadyAvailableException() {
		Screen screen = new Screen(101, "Screen 1");
		when(screenDAO.add(any(Screen.class))).thenThrow(ValueAlreadyAvailableException.class);
		screenService.addScreen(screen);
	}

	@Test(expected = SizeExceedsException.class)
	public void addScreen_GivenScreenObjectIsAddedMoreThanThrice_ThrowException() {
		Screen fourthScreen = new Screen(104, "Screen 4");
		List<Screen> screenList = Arrays.asList(new Screen(101, "screen 1"), new Screen(102, "screen 2"),
				new Screen(103, "screen 3"), new Screen(104, "screen 4"));
		when((screenDAO.getScreens())).thenReturn(screenList);
		screenService.addScreen(fourthScreen);
	}

}
