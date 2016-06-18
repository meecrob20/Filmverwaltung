package de.jgds.filmverwaltung.model;

public class Film {

	private int id;
	private int bewertung;
	private String name;
	private boolean onWatchlist;

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

	public int getBewertung() {
		return bewertung;
	}

	public String getName() {
		return name;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
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
