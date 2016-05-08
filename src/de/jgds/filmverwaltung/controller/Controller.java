package de.jgds.filmverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.jgds.filmverwaltung.view.MainWindow;

public class Controller implements ActionListener {
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Attribute
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private MainWindow window;

	private static Controller instance = null;

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Konstruktor
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private Controller() {
		window = new MainWindow();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Diese Methode stellt sicher dass nur ein 'Controller' Objekt existiert
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Diese Methode f�hrt die 'init' Methode der Klasse MainWindow aus
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void init() {
		window.init();
	}

	
	public static void main(String[] args) {

		Controller.getInstance().init();
		;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action performed");
		if (e.getSource() == window.getBtnAddWatchlist()) {
			System.out.println("Add Button");
		} else {
			System.out.println("anderer Button wurde gedr�ckt");
		}
	}

}