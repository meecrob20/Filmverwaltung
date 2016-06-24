package de.jgds.filmverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.jgds.filmverwaltung.model.Film;
import de.jgds.filmverwaltung.view.AddMovieDialog;
import de.jgds.filmverwaltung.view.EditMovieDialog;
import de.jgds.filmverwaltung.view.MainWindow;

/**
 * Der Controller ist für den Start und die Steuerung der Applikation zuständig.
 * 
 * @author Lopes, Maya, Jäger
 *
 */
public class Controller implements ActionListener, MouseListener {

	private MainWindow window;
	private AddMovieDialog dialog;
	private EditMovieDialog dialog2;
	private static Controller instance = null;

	/**
	 * Der Konstruktor der Klasse Controller erzeugt ein neues 'MainWindow'
	 * Objekt.
	 */
	private Controller() {
		window = new MainWindow();

		dialog = new AddMovieDialog();
		dialog2 = new EditMovieDialog();
	}

	/**
	 * Diese Methode stellt sicher dass nur ein 'Controller' Objekt existiert.
	 * 
	 * @return ein Controller Objekt das entweder schon existierte oder erzeugt
	 *         wurde
	 */
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	/**
	 * Diese Methode führt die 'init' Methode der Klasse MainWindow aus.
	 */
	private void init() {
		window.init();
	}

	public static void main(String[] args) {

		Controller.getInstance().init();

	}

	/**
	 * Nimmt die eingaben des benutzers und trägt sie in die Datenbank ein.
	 */
	private void addMovie() {
		DbController dbc = DbController.getInstance();
		Film f = new Film();
		f.setName(dialog.getTitel());
		f.setDescription(dialog.getDescription());
		f.setRating(dialog.getRating());
		f.setGenre(dialog.getGenre());
		f.setOnWatchlist(dialog.getSeen());
		dbc.createFilm(f);

		this.refreshLists();
		JOptionPane.showMessageDialog(dialog, "Film hinzugefügt!");

	}

	/**
	 * Nimmt die eingaben des benutzers und überträgt sie auf den zuvor
	 * ausgewählten Film. So wird der Film in der Datenbank aktualisiert.
	 */
	private void updateMovie() {
		
		int id;
		
			if(checkIfMovieSelected() == 1){
				id = window.getlistMovie().getSelectedValue().getId();
			} else{
				id = window.getList_Watchlist().getSelectedValue().getId();
			}
		
		
		
		
			DbController dbc = DbController.getInstance();
			Film f = new Film();
			f.setId(id);
			f.setName(dialog2.getTitel());
			f.setDescription(dialog2.getDescription());
			f.setRating(dialog2.getRating());
			f.setGenre(dialog2.getGenre());
			f.setOnWatchlist(!dialog2.getSeen());
			dbc.updateFilm(f);

			this.refreshLists();
			JOptionPane.showMessageDialog(dialog, "Film aktualisiert!");
		
	}

	/**
	 * Löscht den ausgewählten Film aus der Datenbank.
	 */
	private void deleteMovie() {

		if (checkIfMovieSelected() == 0) {
			JOptionPane.showMessageDialog(window, "Bitte Wähle einen Film aus.", "Warnung", JOptionPane.ERROR_MESSAGE);
		} else if (checkIfMovieSelected() == 1) {

			DbController dbc = DbController.getInstance();
			Film f = new Film();
			f.setId(window.getlistMovie().getSelectedValue().getId());
			dbc.deleteFilm(f);

			this.refreshLists();
			JOptionPane.showMessageDialog(dialog, "Film gelöscht!");

		} else if (checkIfMovieSelected() == 2) {

			DbController dbc = DbController.getInstance();
			Film f = new Film();
			f.setId(window.getList_Watchlist().getSelectedValue().getId());
			dbc.deleteFilm(f);

			this.refreshLists();
			JOptionPane.showMessageDialog(dialog, "Film gelöscht!");

		} else {
			System.out.println("Löschen fehlgeschlagen");
		}

	}

	/**
	 * Entfernt einen Ausgewählten Film von der Watchlist.
	 */
	private void removeWatchlist() {

		if (checkIfMovieSelected() == 0) {
			JOptionPane.showMessageDialog(window, "Bitte Wähle einen Film aus.", "Warnung", JOptionPane.ERROR_MESSAGE);
		}

		if (checkIfMovieSelected() == 1) {

			if (window.getlistMovie().getSelectedValue().isOnWatchlist() == true) {
				DbController dbc = DbController.getInstance();
				Film f = new Film();
				f.setId(window.getlistMovie().getSelectedValue().getId());
				f.setName(window.getlistMovie().getSelectedValue().getName());
				f.setDescription(window.getlistMovie().getSelectedValue().getDescription());
				f.setRating(window.getlistMovie().getSelectedValue().getRating());
				f.setGenre(window.getlistMovie().getSelectedValue().getGenre());
				f.setOnWatchlist(!window.getlistMovie().getSelectedValue().isOnWatchlist());
				dbc.updateFilm(f);

				refreshLists();
			} else {
				JOptionPane.showMessageDialog(window, "Dieser Film ist nicht in der Watchlist.", "Warnung",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (checkIfMovieSelected() == 2) {

			DbController dbc = DbController.getInstance();
			Film f = new Film();
			f.setId(window.getList_Watchlist().getSelectedValue().getId());
			f.setName(window.getList_Watchlist().getSelectedValue().getName());
			f.setDescription(window.getList_Watchlist().getSelectedValue().getDescription());
			f.setRating(window.getList_Watchlist().getSelectedValue().getRating());
			f.setGenre(window.getList_Watchlist().getSelectedValue().getGenre());
			f.setOnWatchlist(!window.getList_Watchlist().getSelectedValue().isOnWatchlist());
			dbc.updateFilm(f);

			refreshLists();

		}

	}

	/**
	 * Fügt einen Ausgewählten Film der Watchlist hinzu.
	 */
	private void addWatchlist() {
		if (checkIfMovieSelected() == 0) {
			JOptionPane.showMessageDialog(window, "Bitte Wähle einen Film aus.", "Warnung", JOptionPane.ERROR_MESSAGE);
		} else if (checkIfMovieSelected() == 2) {
			JOptionPane.showMessageDialog(window, "Dieser Film ist schon in der Watchlist.", "Warnung",
					JOptionPane.ERROR_MESSAGE);
		} else if (checkIfMovieSelected() == 1) {

			if (window.getlistMovie().getSelectedValue().isOnWatchlist() == false) {
				DbController dbc = DbController.getInstance();
				Film f = new Film();
				f.setId(window.getlistMovie().getSelectedValue().getId());
				f.setName(window.getlistMovie().getSelectedValue().getName());
				f.setDescription(window.getlistMovie().getSelectedValue().getDescription());
				f.setRating(window.getlistMovie().getSelectedValue().getRating());
				f.setGenre(window.getlistMovie().getSelectedValue().getGenre());
				f.setOnWatchlist(!window.getlistMovie().getSelectedValue().isOnWatchlist());
				dbc.updateFilm(f);

				refreshLists();
			} else {
				JOptionPane.showMessageDialog(window, "Dieser Film ist schon in der Watchlist.", "Warnung",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * Aktualisiert die Listen in denen die Filme angezeigt werden.
	 */
	private void refreshLists() {
		ArrayList<Film> allFilms = Controller.getInstance().getAlleFilme();
		ArrayList<Film> allFilmsOnWatchlist = Controller.getInstance().getAlleWatchlistFilme();

		window.setListMovie(allFilms.toArray(new Film[0]));
		window.setList_Watchlist(allFilmsOnWatchlist.toArray(new Film[0]));
	}

	/**
	 * Erzeugt ein Dialogfenster der Klasse AddMovieDialog.
	 */
	private void openAddMovieDialog() {
		dialog = new AddMovieDialog(this);
		dialog.setVisible(true);
	}

	/**
	 * Erzeugt ein Dialogfenster der Klasse EditMovieDialog.
	 */
	private void openEditMovieDialog() {

		if (checkIfMovieSelected() != 0) {
			dialog2 = new EditMovieDialog(this);
			setEditMovie();
			dialog2.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(window, "Bitte Wähle einen Film aus.", "Warnung", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Gibt alle Filme der Liste allFilms zurück.
	 * 
	 * @return alle Filme der Liste allFilms
	 */
	public ArrayList<Film> getAlleFilme() {
		return DbController.getInstance().getAlleFilme();
	}

	/**
	 * Gibt alle Filme der Liste allFilmsOnWatchlist zurück.
	 * 
	 * @return alle Filme der Liste allFilmsOnWatchlist
	 */
	public ArrayList<Film> getAlleWatchlistFilme() {
		ArrayList<Film> watchlist = new ArrayList<>();
		for (Film f : getAlleFilme()) {
			if (f.isOnWatchlist()) {
				watchlist.add(f);
			}
		}
		return watchlist;
	}

	/**
	 * Überprüft aus welcher Liste ein Film ausgewählt wurde.
	 * 
	 * @return 1 falls ein Film aus listAllFilms ausgewählt wurde, 2 falls ein
	 *         Film aus list_Watchlist ausgewählt wurde, 0 falls kein Film
	 *         ausgewählt wurde.
	 */
	private int checkIfMovieSelected() {
		if (!window.getlistMovie().isSelectionEmpty() && window.getList_Watchlist().isSelectionEmpty()) {
			return 1;
		} else if (window.getlistMovie().isSelectionEmpty() && !window.getList_Watchlist().isSelectionEmpty()) {
			return 2;
		} else {
			return 0;
		}
	}

	public void setEditMovie() {

		if (checkIfMovieSelected() == 1) {
			dialog2.setTitel(window.getlistMovie().getSelectedValue().getName());
			dialog2.setDescription(window.getlistMovie().getSelectedValue().getDescription());
			dialog2.setRating(window.getlistMovie().getSelectedValue().getRating());
			dialog2.setGenre(window.getlistMovie().getSelectedValue().getGenre());
			dialog2.setSeen(window.getlistMovie().getSelectedValue().isOnWatchlist());
		}else {
			dialog2.setTitel(window.getList_Watchlist().getSelectedValue().getName());
			dialog2.setDescription(window.getList_Watchlist().getSelectedValue().getDescription());
			dialog2.setRating(window.getList_Watchlist().getSelectedValue().getRating());
			dialog2.setGenre(window.getList_Watchlist().getSelectedValue().getGenre());
			dialog2.setSeen(window.getList_Watchlist().getSelectedValue().isOnWatchlist());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == window.getBtnAddMovie()) {
			openAddMovieDialog();
		} else if (e.getSource() == window.getBtnEditMovie()) {
			openEditMovieDialog();
		} else if (e.getSource() == window.getBtnAddWatchlist()) {
			addWatchlist();
		} else if (e.getSource() == window.getBtnRemoveWatchlist()) {
			removeWatchlist();
		} else if (e.getSource() == dialog.getBtnAddMovie()) {
			addMovie();
		} else if (e.getSource() == dialog2.getBtnEditMovie()) {
			updateMovie();
		} else if (e.getSource() == window.getBtnDeleteMovie()) {
			deleteMovie();
		} else {
			System.out.println("nichts passiert");
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == window.getlistMovie()) {
			window.getList_Watchlist().clearSelection();

		} else if (e.getSource() == window.getList_Watchlist()) {
			window.getlistMovie().clearSelection();

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}////////////////////////////////
