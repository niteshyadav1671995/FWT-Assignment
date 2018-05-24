package com.yash.moviebookingsystem.dao;

import java.util.List;

import com.yash.moviebookingsystem.model.Screen;

public interface ScreenDAO {

	int add(Screen screen);

	List<Screen> getScreens();

}
