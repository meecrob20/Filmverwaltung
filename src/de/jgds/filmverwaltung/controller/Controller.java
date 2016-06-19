package de.jgds.filmverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.jgds.filmverwaltung.model.Film;
import de.jgds.filmverwaltung.view.AddMovieDialog;
import de.jgds.filmverwaltung.view.MainWindow;

/**
 * 
 * @author Danny
 *
 */
public class Controller implements ActionListener {
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Attribute
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private MainWindow window;
	private AddMovieDialog dialog;

	private static Controller instance = null;

	/**
	 * 
	 */
	private Controller() {
		window = new MainWindow();
	}

	/**
	 * Diese Methode stellt sicher dass nur ein 'Controller' Objekt existiert
	 * 
	 * @return
	 */
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	/**
	 * Diese Methode führt die 'init' Methode der Klasse MainWindow aus
	 */
	private void init() {
		window.init();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Controller.getInstance().init();

	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == window.getBtnAddMovie()) {
			openAddMovieDialog();
		} else if (e.getSource() == window.getBtnAddWatchlist()) {
			addWatchlist();
		} else if (e.getSource() == window.getBtnRemoveWatchlist()) {
			removeWatchlist();
		} else if (e.getSource() == dialog.getBtnAddMovie()) {
			addMovie();
		} else {
			System.out.println("nichts passiert");
		}

	}

	private void addMovie() {
		System.out.println("Titel: " + dialog.getTitel());
		System.out.println("Beschreibung: " + dialog.getDescription());
		System.out.println("Bewertung: " + dialog.getRating());
		System.out.println("Genre: " + dialog.getGenre());
		System.out.println("Gesehen? " + dialog.getSeen());
	
	}

	/**
	 * 
	 */
	private void removeWatchlist() {
		System.out.println("remove watchlist");
	}

	/**
	 * 
	 */
	private void addWatchlist() {
		System.out.println("add watchlist");
	}

	/**
	 * 
	 */
	private void openAddMovieDialog() {
	dialog = new AddMovieDialog(this);
	dialog.setVisible(true);
	}

	public ArrayList<Film> getAlleFilme() {
		return DbController.getInstance().getAlleFilme();
	}

	public ArrayList<Film> getAlleWatchlistFilme() {
		ArrayList<Film> watchlist = new ArrayList<>();
		for (Film f : getAlleFilme()) {
			if (f.isOnWatchlist()) {
				watchlist.add(f);
			}
		}
		return watchlist;
	}

}////////////////////////////////
