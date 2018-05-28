package com.yash.moviebookingsystem.model;

import java.util.List;

public class Category {

	private int id;
	private int price;
	private String categoryName;

	public Category(int id, int price, String categoryName) {
		super();
		this.id = id;
		this.price = price;
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
