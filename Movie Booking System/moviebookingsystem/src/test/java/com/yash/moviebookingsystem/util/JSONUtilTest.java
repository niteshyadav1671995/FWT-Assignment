package com.yash.moviebookingsystem.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yash.moviebookingsystem.model.Screen;

public class JSONUtilTest {

	@Test
	public void writeObject() {
		JSONUtil jsonUtil = new JSONUtil();
		Screen screen = new Screen(101, "Screen 2");
		assertEquals(1, jsonUtil.writeScreenToList(screen));
	}
}
