package de.jgds.filmverwaltung.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import de.jgds.filmverwaltung.controller.Controller;
import de.jgds.filmverwaltung.model.Film;
import javax.swing.JScrollPane;

/**
 * 
 * @author Danny
 *
 */
public class MainWindow extends JFrame {

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Attribute
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JTextField txtSearch;
	private JButton btnRemoveWatchlist;
	private JButton btnAddWatchlist;
	private JButton btnAddMovie;
	private JScrollPane scrollPaneMovie;
	private JScrollPane scrollPaneWatchlist;
	private JList listMovie;
	private JList list_Watchlist;

	/**
	 * 
	 */
	public MainWindow() {
		//this.init(); // Notwendig damit der Designer die GUI anzeigt
	}

	/**
	 * Diese Methode initialisiert und kreiert die Komponenten der GUI
	 */
	public void init() {
		setTitle("Filmverwaltung");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 120, 1500, 800);

		txtSearch = new JTextField();
		txtSearch.setForeground(Color.LIGHT_GRAY);
		txtSearch.setText("Suche");
		txtSearch.setColumns(10);

		btnAddMovie = new JButton("Film Hinzufuegen");
		btnAddMovie.addActionListener(Controller.getInstance());

		JPanel panel = new JPanel();

		JLabel lblAlleFilme = new JLabel("Alle Filme");

		JLabel lblWatchlist = new JLabel("Watchlist");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(20)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 1221, Short.MAX_VALUE)
								.addComponent(btnAddMovie).addGap(44))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(lblAlleFilme, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE).addGap(762)
								.addComponent(lblWatchlist, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(512))
						.addGroup(
								groupLayout.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panel,
												GroupLayout.PREFERRED_SIZE, 1464, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddMovie))
								.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAlleFilme, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblWatchlist, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		ArrayList<Film> allFilms = Controller.getInstance().getAlleFilme();
		ArrayList<Film> allFilmsOnWatchlist = Controller.getInstance().getAlleWatchlistFilme();

		scrollPaneMovie = new JScrollPane();
		listMovie = new JList(allFilmsOnWatchlist.toArray());
		scrollPaneMovie.setViewportView(listMovie);

		JPanel panel_1 = new JPanel();

		btnAddWatchlist = new JButton("Hinzufügen zu Watchlist");
		btnAddWatchlist.addActionListener(Controller.getInstance());

		btnRemoveWatchlist = new JButton("Entfernen von Watchlist");
		btnRemoveWatchlist.addActionListener(Controller.getInstance());

		JButton btnDeleteMovie = new JButton("Film Löschen");

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(27)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(
												btnAddWatchlist, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGap(
														33))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnDeleteMovie, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnRemoveWatchlist, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
												.addContainerGap()))));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(75)
								.addComponent(btnAddWatchlist, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnRemoveWatchlist, GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE)
								.addGap(300).addComponent(btnDeleteMovie, GroupLayout.PREFERRED_SIZE, 31,
										GroupLayout.PREFERRED_SIZE)
								.addGap(163)));
		panel_1.setLayout(gl_panel_1);

		scrollPaneWatchlist = new JScrollPane();

		list_Watchlist = new JList(allFilms.toArray());
		scrollPaneWatchlist.setViewportView(list_Watchlist);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(scrollPaneMovie, GroupLayout.PREFERRED_SIZE, 608,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPaneWatchlist, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addComponent(scrollPaneMovie, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addComponent(scrollPaneWatchlist, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		setVisible(true);

	}

	/**
	 * 
	 * @return
	 */
	public JButton getBtnRemoveWatchlist() {
		return btnRemoveWatchlist;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getBtnAddMovie() {
		return btnAddMovie;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getBtnAddWatchlist() {
		return btnAddWatchlist;
	}

	/**
	 * 
	 * @return
	 */
	public JTextField getTxtSuche() {
		return txtSearch;
	}

	public void setListMovie(JList allMovies) {
		this.listMovie = allMovies;
	}

	public void setList_Watchlist(JList watchlist) {
		this.list_Watchlist = watchlist;
	}
}///////////////////////////
