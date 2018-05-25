package com.yash.moviebookingsystem.model;

public class Screen {
	private int id;
	private String name;
	private Movie movie;

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
		return "Screen [id=" + id + ", name=" + name + "]";
	}

}
