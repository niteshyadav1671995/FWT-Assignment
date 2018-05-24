package com.yash.moviebookingsystem.model;

public class Movie {

	private String title;
	private String production;
	private String duration;
	private String actors;

	public Movie(String title, String production, String duration, String actors) {
		super();
		this.title = title;
		this.production = production;
		this.duration = duration;
		this.actors = actors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", production=" + production + ", duration=" + duration + ", actors=" + actors
				+ "]";
	}

}
