package de.jgds.filmverwaltung.model;

public class Film {
	
	private int id;
	private int bewertung;
	private String name;
	private boolean onWatchlist;
	
	public boolean isOnWatchlist() {
		return onWatchlist;
	}
	public void setOnWatchlist(boolean onWatchlist) {
		this.onWatchlist = onWatchlist;
	}
	@Override
	public String toString() {
		return ""+id+":"+name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBewertung() {
		return bewertung;
	}
	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
