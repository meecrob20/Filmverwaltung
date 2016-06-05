/**
 * 
 */
package de.jgds.filmverwaltung.view;

import javax.swing.JDialog;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import de.jgds.filmverwaltung.controller.Controller;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * @author Danny
 *
 */
public class AddMovieDialog extends JDialog {
	private JTextField txtTitel;
	private JTextField txtBeschreibung;

	public AddMovieDialog() {

		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("Filme Hinzuf\u00FCgen");

		JLabel lblFgeEinenFilm = new JLabel("F\u00FCge einen Film hinzu");
		getContentPane().add(lblFgeEinenFilm, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblTitel = new JLabel("Titel: ");
		panel.add(lblTitel);

		JLabel lblBeschreibung = new JLabel("Beschriebung: ");
		panel.add(lblBeschreibung);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);

		panel_1.setLayout(new GridLayout(2, 1, 0, 0));

		txtTitel = new JTextField();
		txtTitel.setText("titel");
		panel_1.add(txtTitel);
		txtTitel.setColumns(10);

		txtBeschreibung = new JTextField();
		txtBeschreibung.setText("beschreibung");
		panel_1.add(txtBeschreibung);
		txtBeschreibung.setColumns(10);

		setVisible(true);
	}

	/*public static void main(String[] args) {

		AddMovieDialog dialog = new AddMovieDialog();
	}*/   //zum testen von ADDMovieDialog

}//////////////////////////////////////
