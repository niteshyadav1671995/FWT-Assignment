package com.yash.moviebookingsystem.model;

import java.awt.List;

public class Row {

	private int id;
	private int category;
	private List seat;

	public Row(int id, int category, List seat) {
		super();
		this.id = id;
		this.category = category;
		this.seat = seat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public List getSeat() {
		return seat;
	}

	public void setSeat(List seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Row [id=" + id + ", category=" + category + ", seat=" + seat + "]";
	}

}
