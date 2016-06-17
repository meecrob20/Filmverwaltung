package de.jgds.filmverwaltung.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.jgds.filmverwaltung.model.Film;

public class DbController {
	private static DbController instance;

	private Connection c = null;

	public static DbController getInstance() {
		if (instance == null) {
			instance = new DbController();
		}
		return instance;
	}

	private DbController() {
		initDBConnection();
	}

	private void initDBConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Datenbank geöffnet");
		try {
			if (!tableExists("Film")) {
				Statement stmt = c.createStatement();
				String sql = "CREATE TABLE Film " 
						+ "(Id INTEGER PRIMARY KEY AUTOINCREMENT    NOT NULL,"
						+ " Name           TEXT    NOT NULL, " 
						+ " Bewertung            INT     NOT NULL,"
						+ " onWatchlist		BOOLEAN		NOT NULL)";
				stmt.executeUpdate(sql);
				stmt.close();
				System.out.println("Tabelle angelegt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean tableExists(String tableName) {
		boolean result = false;
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + tableName + "';";
			stmt.execute(sql);
			ResultSet rs = stmt.getResultSet();
				result = (rs.getInt(1)==1);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		DbController dbc = DbController.getInstance();
		Film f = new Film();
		f.setName("Test Film");
		f.setBewertung(1);
		f.setOnWatchlist(true);;
		dbc.createFilm(f);
		for (Film film : dbc.getAlleFilme()){
			System.out.println(film);
		}
	}
	
	public void createFilm(Film neuerFilm){
		try {
			String sql = "INSERT INTO Film (Name, Bewertung, onWatchlist) VALUES (?, ?, ?);";
			PreparedStatement stmt = c.prepareStatement(sql);
			//ID soll von der Datenbank generiert werden
			stmt.setString(1, neuerFilm.getName());
			stmt.setInt(2, neuerFilm.getBewertung());
			stmt.setBoolean(3, neuerFilm.isOnWatchlist());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void updateFilm(Film film){
		try {
			String sql = "UPDATE Film SET Name=? , Bewertung=?, onWatchlist=? WHERE ID = ?;";
			PreparedStatement stmt = c.prepareStatement(sql);
			//ID soll von der Datenbank generiert werden
			stmt.setString(1, film.getName());
			stmt.setInt(2, film.getBewertung());
			stmt.setBoolean(3, film.isOnWatchlist());
			stmt.setInt(4, film.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Film> getAlleFilme(){
		ArrayList<Film> result = new ArrayList<>();
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT Id, Name, Bewertung, onWatchlist FROM Film;";
			stmt.execute(sql);
			ResultSet rs = stmt.getResultSet();
			while ( rs.next()){
				Film neuerFilm = new Film();
				neuerFilm.setId(rs.getInt(1));
				neuerFilm.setName(rs.getString(2));
				neuerFilm.setBewertung(rs.getInt(3));
				neuerFilm.setOnWatchlist(rs.getBoolean(4));
				result.add(neuerFilm);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
