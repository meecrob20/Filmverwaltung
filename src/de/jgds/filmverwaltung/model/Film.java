package de.jgds.filmverwaltung.model;

public class Film {

	private int id;
	private int rating;
	private String name;
	private boolean onWatchlist;
	private String description;

	@Override
	public String toString() {
		return "" + id + ":" + name;
	}

	public boolean isOnWatchlist() {
		return onWatchlist;
	}

	public int getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOnWatchlist(boolean onWatchlist) {
		this.onWatchlist = onWatchlist;
	}

	public void setId(int id) {
		this.id = id;
	}

}
