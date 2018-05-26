package com.yash.moviebookingsystem.model;

import java.util.List;

public class Screen {
	private int id;
	private String name;
	private Movie movie;
	private List<Show> show;
	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	public Screen(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", movie=" + movie + ", show=" + show + "]";
	}

}
