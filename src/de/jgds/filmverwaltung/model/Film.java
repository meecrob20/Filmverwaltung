package de.jgds.filmverwaltung.model;

/**
 * In dieser Klasse werden die Attribute der Filme gespeichert, um später abgefragt oder
 * in die Datenbank geschrieben zu werden.
 * @author Lopes, Maya, Jäger
 *
 */
public class Film {

	private int id;
	private int rating;
	private String name;
	private boolean onWatchlist;
	private String description;
	private String genre;

	/**
	 * Stellt ein Objekt als String dar.
	 * 
	 * @return representativer String des Objektes.
	 */
	@Override
	public String toString() {
		return "" + id + ": " + name + "   ||Genre: " + genre + " ||" + "   ||Bewertung: " + rating + " ||";
	}

	/**
	 * Prüft ob der Film auf der Watchlist ist.
	 * @return Wahrheitswert ob der Film auf der Watchlist ist oder nicht
	 */
	public boolean isOnWatchlist() {
		return onWatchlist;
	}

	/**
	 * Gibt die ID des Filmes zurück.
	 * @return ID des Filmes
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gibt die Bewertung des Filmes zurück.
	 * @return Bewertung des Filmes
	 */
	public int getRating() {
		return rating;
	}
/**
 * Gibt den Namen des Filmes zurück.
 * @return Name des Filmes
 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gibt die Beschreibung des Filmes zurück.
	 * @return Beschreibung des Filmes
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Gibt das Genre des Filmes zurück.
	 * @return Genre des Filmes
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Legt die Bewertung des Filmes fest.
	 * @param rating Bewertung des Filmes
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Legt den Namen des Filmes fest.
	 * @param name Name des Filmes
	 */
	public void setName(String name) {
		this.name = name;
	}
	
/**
 * Legt fest ob der Film auf die Watchlist kommt oder nicht.
 * @param onWatchlist Wahrheitswert
 */
	public void setOnWatchlist(boolean onWatchlist) {
		this.onWatchlist = onWatchlist;
	}

	/**
	 * Legt die ID des Filmes fest.
	 * @param id ID des Filmes
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Legt die Beschreibung des Filmes fest.
	 * @param description Beschreibung des Filmes.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * Legt das Genre des Filmes fest.
	 * @param genre Genre des Filmes
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
