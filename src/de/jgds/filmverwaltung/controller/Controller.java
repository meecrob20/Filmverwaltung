package de.jgds.filmverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			addMovie();
		} else if (e.getSource() == window.getBtnAddWatchlist()) {
			addWatchlist();
		} else if (e.getSource() == window.getBtnRemoveWatchlist()) {
			removeWatchlist();
		} else {
			System.out.println("anderer Button wurde gedrückt");
		}

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
	private void addMovie() {
		AddMovieDialog dialog = new AddMovieDialog(this);
	}

}////////////////////////////////
