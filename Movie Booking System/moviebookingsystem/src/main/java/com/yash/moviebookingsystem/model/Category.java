package com.yash.moviebookingsystem.model;

import java.util.List;

public class Category {

	private int id;
	private int price;
	private String categoryName;
	private List<Row> rows;

	public Category(int id, int price, String categoryName, List<Row> rows) {
		super();
		this.id = id;
		this.price = price;
		this.categoryName = categoryName;
		this.rows = rows;
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

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", price=" + price + ", categoryName=" + categoryName + ", rows=" + rows + "]";
	}

	
}
