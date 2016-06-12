/**
 * 
 */
package de.jgds.filmverwaltung.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import de.jgds.filmverwaltung.controller.Controller;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * @author Danny
 *
 */
public class AddMovieDialog extends JDialog {
	private JTextField txtTitel;
	private Controller controller;
	private final ButtonGroup buttonGroupRating = new ButtonGroup();
	private final ButtonGroup buttonGroupYN = new ButtonGroup();

	
	/**
	 * 
	 * @param controller
	 */
	public AddMovieDialog(Controller controller) {

		this.controller = controller;

		init();

	}
/**
 * 
 */
	private void init() {
		setTitle("Filme Hinzuf\u00FCgen");

		setBounds(700, 200, 400, 700);

		JLabel lblAddMovie = new JLabel("F\u00FCge einen Film hinzu");
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
		txtTitel.setForeground(Color.LIGHT_GRAY);
		txtTitel.setText("titel");
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

		JTextArea taDescription = new JTextArea();
		taDescription.setForeground(Color.LIGHT_GRAY);
		taDescription.setText("taDescription");
		scrpDescription.setViewportView(taDescription);
		panel_4.setLayout(gl_panel_4);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JRadioButton rdbtnRating_1 = new JRadioButton("1");
		buttonGroupRating.add(rdbtnRating_1);

		JRadioButton rdbtnRating_2 = new JRadioButton("2");
		buttonGroupRating.add(rdbtnRating_2);

		JRadioButton rdbtnRating_3 = new JRadioButton("3");
		buttonGroupRating.add(rdbtnRating_3);

		JRadioButton rdbtnRating_4 = new JRadioButton("4");
		buttonGroupRating.add(rdbtnRating_4);

		JRadioButton rdbtnRating_5 = new JRadioButton("5");
		buttonGroupRating.add(rdbtnRating_5);
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

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JRadioButton rdbtnYes = new JRadioButton("Ja");
		buttonGroupYN.add(rdbtnYes);

		JRadioButton rdbtnNo = new JRadioButton("Nein");
		rdbtnNo.setSelected(true);
		buttonGroupYN.add(rdbtnNo);
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

		JButton btnAddMovie = new JButton("Film Hinzuf\u00FCgen");
		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddMovie.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getContentPane().add(btnAddMovie, BorderLayout.SOUTH);
		setResizable(false);
		setModal(true);
		setVisible(true);

	}
}//////////////////////////////////////
