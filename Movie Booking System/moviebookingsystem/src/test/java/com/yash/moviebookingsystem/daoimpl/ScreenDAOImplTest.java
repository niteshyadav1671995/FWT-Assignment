package com.yash.moviebookingsystem.daoimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.model.Screen;

public class ScreenDAOImplTest {

	@Test
	public void add_ScreenObjectGiven_ShouldReturnSizeOfTheList() {
		ScreenDAO screenDAO = new ScreenDAOImpl();
		System.out.println("1");
		Screen screen = new Screen(101, "Screen 2");
		assertEquals(1, screenDAO.add(screen));
	}

	@Test
	public void add_ScreenObjectsGiven_ShouldReturnSizeOfTheList() {
		ScreenDAO screenDAO = new ScreenDAOImpl();
		System.out.println("2");
		Screen screen1 = new Screen(101, "Screen 1");
		Screen screen2 = new Screen(102, "Screen 2");
		Screen screen3 = new Screen(103, "Screen 3");
		assertEquals(1, screenDAO.add(screen1));
		assertEquals(2, screenDAO.add(screen2));
		assertEquals(3, screenDAO.add(screen3));
	}

	@Test
	public void add_ScreenObjectsMoreThanThreeGiven_ShouldReturnMoreThanThree() {
		ScreenDAO screenDAO = new ScreenDAOImpl();
		System.out.println("3");
		Screen screen1 = new Screen(101, "Screen 1");
		Screen screen2 = new Screen(102, "Screen 2");
		Screen screen3 = new Screen(103, "Screen 3");
		Screen screen4 = new Screen(104, "Screen 4");
		assertEquals(1, screenDAO.add(screen1));
		assertEquals(2, screenDAO.add(screen2));
		assertEquals(3, screenDAO.add(screen3));
		assertEquals(4, screenDAO.add(screen4));
	}

}
