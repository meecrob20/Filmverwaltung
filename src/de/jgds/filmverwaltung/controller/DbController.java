package de.jgds.filmverwaltung.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.jgds.filmverwaltung.model.Film;

/**
 * Der DbController erstellt die verbindung zur Datenbank und enth�lt die essenziellen	
 * SQL Befehle.
 * 
 * @author Lopes, Maya, J�ger
 *
 */
public class DbController {

	private static DbController instance;
	private Connection c = null;

	/**
	 * Konstruktor von DbController welcher die Methode initDBConnection ausf�hrt.
	 */
	private DbController() {
		initDBConnection();
	}
	/**
	 * Diese Methode stellt sicher dass nur ein 'DbController' Objekt existiert.
	 * 
	 * @return ein DbController Objekt das entweder schon existierte oder erzeugt
	 *         wurde
	 */
public static DbController getInstance() {
		if (instance == null) {
			instance = new DbController();
		}
		return instance;
	}

/**
 * Initialisiert die Verbindung mit der Datenbank und erzeugt selbige mitsamt Tabelle.
 */
	private void initDBConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Film.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Datenbank ge�ffnet");
		try {
			if (!tableExists("Film")) {
				Statement stmt = c.createStatement();
				String sql = "CREATE TABLE Film " + "(Id INTEGER PRIMARY KEY AUTOINCREMENT    NOT NULL,"
						+ " Name           TEXT    NOT NULL, "
						+ " Description		TEXT	NOT NULL, "
						+ " Rating           INT     NOT NULL," 
						+ " Genre			TEXT	NOT NULL, "
						+ " onWatchlist		BOOLEAN		NOT NULL)";
				stmt.executeUpdate(sql);
				stmt.close();
				System.out.println("Tabelle angelegt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �berpr�ft ob eine Tabelle schon existiert.
	 * @param tableName Name der zu �berpr�fenden Tabelle
	 * @return Wahrheitswert ob die Tabelle schon existiert oder nicht
	 */
	private boolean tableExists(String tableName) {
		boolean result = false;
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + tableName + "';";
			stmt.execute(sql);
			ResultSet rs = stmt.getResultSet();
			result = (rs.getInt(1) == 1);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
/*
	//zum testen der Datenbank
	
	public static void main(String[] args) {
		DbController dbc = DbController.getInstance();
		Film f = new Film();
		f.setName("Test Film");
		f.setDescription("TEST");
		f.setRating(1);
		f.setGenre("Action");
		f.setOnWatchlist(true);
		dbc.createFilm(f);
		for (Film film : dbc.getAlleFilme()) {
			System.out.println(film);
		}
	}
	*/

	/**
	 * Methode mit dem SQL Befehl zum Hinzuf�gen eines neuen Filmes.
	 * @param neuerFilm Film der Hinzugef�gt werden soll
	 */
	public void createFilm(Film neuerFilm) {
		try {
			String sql = "INSERT INTO Film (Name, Description, Rating, Genre, onWatchlist) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement stmt = c.prepareStatement(sql);
			// ID soll von der Datenbank generiert werden
			stmt.setString(1, neuerFilm.getName());
			stmt.setString(2, neuerFilm.getDescription());
			stmt.setInt(3, neuerFilm.getRating());
			stmt.setString(4, neuerFilm.getGenre());
			stmt.setBoolean(5, neuerFilm.isOnWatchlist());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Methode mit dem SQL Befehl zum aktualisieren eines Filmes.
	 * @param film der zu aktualisierende Film
	 */
	public void updateFilm(Film film) {
		try {
			String sql = "UPDATE Film SET Name=?, Description=?, Rating=?, Genre=?, onWatchlist=? WHERE ID = ?;";
			PreparedStatement stmt = c.prepareStatement(sql);
			// ID soll von der Datenbank generiert werden
			stmt.setString(1, film.getName());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getRating());
			stmt.setString(4, film.getGenre());
			stmt.setBoolean(5, film.isOnWatchlist());
			stmt.setInt(6, film.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Methode mit dem SQL Befehl zum L�schen eines Filmes.
	 * @param film der zu l�schende Film
	 */
	public void deleteFilm(Film film) {
		try {
			String sql = "DELETE FROM Film WHERE ID = ?;";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Methode mit dem SQL Befehl um alle Filme der Datenbank zu bekommen.
	 * @return alle Filme + Atribute in der Datenbank
	 */
	public ArrayList<Film> getAlleFilme() {
		ArrayList<Film> result = new ArrayList<>();
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT Id, Name, Description, Rating, Genre, onWatchlist FROM Film;";
			stmt.execute(sql);
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Film neuerFilm = new Film();
				neuerFilm.setId(rs.getInt(1));
				neuerFilm.setName(rs.getString(2));
				neuerFilm.setDescription(rs.getString(3));
				neuerFilm.setRating(rs.getInt(4));
				neuerFilm.setGenre(rs.getString(5));
				neuerFilm.setOnWatchlist(rs.getBoolean(6));
				result.add(neuerFilm);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
