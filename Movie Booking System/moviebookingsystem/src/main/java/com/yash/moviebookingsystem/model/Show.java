package com.yash.moviebookingsystem.model;

import java.sql.Time;
import java.util.List;

public class Show {
	private int id;
	private Time showTime;
	private List<Category> category;

	public Show(int id, Time showStartTime) {
		this.showTime = showStartTime;
		System.out.println(this.showTime+" "+showStartTime );
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", showTime=" + showTime + ", category=" + category + "]";
	}

}
