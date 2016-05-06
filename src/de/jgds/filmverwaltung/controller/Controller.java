package de.jgds.filmverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.jgds.filmverwaltung.view.MainWindow;

public class Controller implements ActionListener {

	private MainWindow window;

	private static Controller instance = null;

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	private Controller() {
		window = new MainWindow();
	}

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
			System.out.println("anderer Button wurde gedrückt");
		}
	}

}
