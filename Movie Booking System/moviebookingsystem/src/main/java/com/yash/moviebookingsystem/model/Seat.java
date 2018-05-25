package com.yash.moviebookingsystem.model;

public class Seat {

	private int id;
	private boolean status;
	
	public Seat(int id, boolean status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", status=" + status + "]";
	}

}
