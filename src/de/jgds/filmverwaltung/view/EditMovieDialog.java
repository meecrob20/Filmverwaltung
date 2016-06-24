package de.jgds.filmverwaltung.view;

import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import de.jgds.filmverwaltung.controller.Controller;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

/**
 * Klasse des EditMovie Dialogs.
 * 
 * @author Lopes, Maya, Jäger
 *
 */
public class EditMovieDialog extends JDialog {

	private Controller controller;
	private JTextField txtTitel;
	private JTextArea taDescription;
	private final ButtonGroup bgRating = new ButtonGroup();
	private final ButtonGroup bgYN = new ButtonGroup();
	private JButton btnEditMovie;
	private JComboBox<String> cbGenre;
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnRating_1;
	private JRadioButton rdbtnRating_2;
	private JRadioButton rdbtnRating_3;
	private JRadioButton rdbtnRating_4;
	private JRadioButton rdbtnRating_5;

	/**
	 * Standardkonstruktor des EditMovieDialogs.
	 */
	public EditMovieDialog() {

	}

	/**
	 * Konstrukter des EditMovie Dialogs.
	 * 
	 * @param controller
	 *            Objekt des Controllers
	 */
	public EditMovieDialog(Controller controller) {

		this.controller = controller;

		init();

	}

	/**
	 * Initialisiert und erstellt die Komponenten des Dialogfensters.
	 */
	private void init() {
		setTitle("Film Bearbeiten/Details");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(700, 200, 400, 700);

		JLabel lblAddMovie = new JLabel("Bearbeite die Infos des Filmes oder schau dir die Details an");
		getContentPane().add(lblAddMovie, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lblTitel = new JLabel("Titel: ");
		panel.add(lblTitel);

		JLabel lblDescription = new JLabel("Beschriebung: ");
		panel.add(lblDescription);

		JLabel lblRating = new JLabel("Bewertung: ");
		panel.add(lblRating);

		JLabel lblGenre = new JLabel("Genre: ");
		panel.add(lblGenre);

		JLabel lblSeen = new JLabel("Film Gesehen? ");
		panel.add(lblSeen);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);

		panel_1.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		txtTitel = new JTextField();
		txtTitel.setForeground(Color.BLACK);
		txtTitel.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3
				.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panel_3.createSequentialGroup().addContainerGap()
								.addComponent(txtTitel, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3
						.createSequentialGroup().addGap(50).addComponent(txtTitel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(56, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);

		JScrollPane scrpDescription = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_4.createSequentialGroup().addContainerGap()
						.addComponent(scrpDescription, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_4.createSequentialGroup().addContainerGap()
						.addComponent(scrpDescription, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addContainerGap()));

		taDescription = new JTextArea();
		taDescription.setForeground(Color.BLACK);
		scrpDescription.setViewportView(taDescription);
		panel_4.setLayout(gl_panel_4);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		rdbtnRating_1 = new JRadioButton("1");
		rdbtnRating_1.setSelected(true);
		bgRating.add(rdbtnRating_1);

		rdbtnRating_2 = new JRadioButton("2");
		bgRating.add(rdbtnRating_2);

		rdbtnRating_3 = new JRadioButton("3");
		bgRating.add(rdbtnRating_3);

		rdbtnRating_4 = new JRadioButton("4");
		bgRating.add(rdbtnRating_4);

		rdbtnRating_5 = new JRadioButton("5");
		bgRating.add(rdbtnRating_5);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(rdbtnRating_1).addGap(5)
						.addComponent(rdbtnRating_2).addGap(5).addComponent(rdbtnRating_3).addGap(5)
						.addComponent(rdbtnRating_4).addGap(5).addComponent(rdbtnRating_5)
						.addContainerGap(92, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_2.createSequentialGroup().addGap(47)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(rdbtnRating_1)
								.addComponent(rdbtnRating_2).addComponent(rdbtnRating_3).addComponent(rdbtnRating_4)
								.addComponent(rdbtnRating_5))
						.addContainerGap(56, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		cbGenre = new JComboBox<String>();
		cbGenre.addItem("Action");
		cbGenre.addItem("Adventure");
		cbGenre.addItem("Comedy");
		cbGenre.addItem("Crime");
		cbGenre.addItem("Drama");
		cbGenre.addItem("Fantasy");
		cbGenre.addItem("Horror");
		cbGenre.addItem("Science Fiction");
		cbGenre.addItem("Thriller");
		cbGenre.addItem("War");
		cbGenre.addItem("Western");

		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
						.addComponent(cbGenre, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(188, Short.MAX_VALUE)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5
						.createSequentialGroup().addGap(49).addComponent(cbGenre, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(57, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		rdbtnYes = new JRadioButton("Ja");
		bgYN.add(rdbtnYes);

		rdbtnNo = new JRadioButton("Nein");
		rdbtnNo.setSelected(true);
		bgYN.add(rdbtnNo);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addComponent(rdbtnYes).addGap(27).addComponent(rdbtnNo)
						.addContainerGap(202, Short.MAX_VALUE)));
		gl_panel_6
				.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
								.addGap(49).addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnYes).addComponent(rdbtnNo))
								.addContainerGap(52, Short.MAX_VALUE)));
		panel_6.setLayout(gl_panel_6);

		btnEditMovie = new JButton("Film Aktualisieren");
		btnEditMovie.addActionListener(Controller.getInstance());

		getContentPane().add(btnEditMovie, BorderLayout.SOUTH);
		setResizable(false);
		setModal(true);

	}

	/**
	 * Gibt den AddMovie Button zurück.
	 * 
	 * @return Button AddMovie
	 */
	public JButton getBtnEditMovie() {
		return this.btnEditMovie;
	}

	/**
	 * Gibt den Titel des Filmes wieder.
	 * 
	 * @return Titel des Filmes
	 */
	public String getTitel() {
		return this.txtTitel.getText();
	}

	/**
	 * Gibt die Beschreibung des Filmes wieder.
	 * 
	 * @return Beschreibung des Filmes
	 */
	public String getDescription() {
		return this.taDescription.getText();
	}

	/**
	 * Gibt die Bewertung des Filmes wieder.
	 * 
	 * @return Bewertung des Filmes
	 */
	public int getRating() {
		if (rdbtnRating_1.isSelected()) {
			return Integer.parseInt("1");
		} else if (rdbtnRating_2.isSelected()) {
			return Integer.parseInt("2");
		} else if (rdbtnRating_3.isSelected()) {
			return Integer.parseInt("3");
		} else if (rdbtnRating_4.isSelected()) {
			return Integer.parseInt("4");
		} else if (rdbtnRating_5.isSelected()) {
			return Integer.parseInt("5");
		} else {
			return 0;
		}

	}

	/**
	 * Gibt das Genre des Filmes wieder.
	 * 
	 * @return genre des Filmes
	 */
	public String getGenre() {

		String selectedItem = cbGenre.getSelectedItem().toString();

		return selectedItem;

	}

	/**
	 * Gibt wieder ob der Film gesehen wurde oder nicht.
	 * 
	 * @return Wahrheitswert
	 */
	public boolean getSeen() {

		if (rdbtnYes.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Setzt den Titel des Filmes.
	 * 
	 * @param titel
	 *            Titel des Filmes
	 */
	public void setTitel(String titel) {
		this.txtTitel.setText(titel);
	}

	/**
	 * Setzt die Beschreibung des Filmes.
	 * 
	 * @param des
	 *            Beschreibung
	 */
	public void setDescription(String des) {
		this.taDescription.setText(des);
	}

	/**
	 * Setzt die Bewertung des Filmes.
	 * 
	 * @param rating
	 *            Bewertung
	 */
	public void setRating(int rating) {
		if (rating == 1) {
			this.rdbtnRating_1.setSelected(true);
		} else if (rating == 2) {
			this.rdbtnRating_2.setSelected(true);
		} else if (rating == 3) {
			this.rdbtnRating_3.setSelected(true);
		} else if (rating == 4) {
			this.rdbtnRating_4.setSelected(true);
		} else if (rating == 5) {
			this.rdbtnRating_5.setSelected(true);
		} else {
			System.out.println("Nix rating");
		}
	}

	/**
	 * Setzt das Genre des Filmes auf übergebenen wert.
	 * 
	 * @param genre
	 *            Genre des Filmes
	 */
	public void setGenre(String genre) {
		this.cbGenre.setSelectedItem(genre);
	}

	/**
	 * Setzt den Radiobutton für wenn der Film gesehen wurde auf Ja, sosnt auf
	 * Nein.
	 * 
	 * @param x
	 *            Wahrheitswert ob der Film gesehen wurde oder nicht
	 */
	public void setSeen(boolean x) {
		if(x == false){
			this.rdbtnYes.setSelected(true);
		} else{
			this.rdbtnNo.setSelected(true);
		}
	}

}///////////////////////////////////////////////////////////////
