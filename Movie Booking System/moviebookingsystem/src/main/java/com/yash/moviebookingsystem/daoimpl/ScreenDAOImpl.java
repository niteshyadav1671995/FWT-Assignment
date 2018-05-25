package com.yash.moviebookingsystem.daoimpl;

import java.util.List;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.util.JSONUtil;

public class ScreenDAOImpl implements ScreenDAO {

	private JSONUtil jsonUtil;

	public ScreenDAOImpl(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}

	public ScreenDAOImpl() {
		jsonUtil=new JSONUtil();
	}

	@Override
	public int add(Screen screen){
		int rowsAffected=jsonUtil.writeScreenToList(screen);
		return rowsAffected;
	}

	@Override
	public List<Screen> getScreens() {
		List<Screen> screenList=jsonUtil.readListOfScreen();
		return screenList;
	}

	
}
