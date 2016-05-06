package de.jgds.filmverwaltung.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class MainWindow extends JFrame {
	private JTextField txtSuche;
	private JButton btnAddWatchlist;
	
	public MainWindow() {
	}

	public void init(){
		setTitle("Filmverwaltung");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 987, 490);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblName.setForeground(Color.CYAN);

		txtSuche = new JTextField();
		txtSuche.setForeground(Color.LIGHT_GRAY);
		txtSuche.setText("Suche");
		txtSuche.setColumns(10);

		JButton btnFilmHinzufuegen = new JButton("Film Hinzufuegen");

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblName))
						.addGroup(groupLayout.createSequentialGroup().addGap(20).addComponent(txtSuche,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE).addComponent(btnFilmHinzufuegen)
				.addGap(36))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(11)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSuche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFilmHinzufuegen))
						.addGap(73).addComponent(panel, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
						.addContainerGap()));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 206, 206, 206 };
		gbl_panel.rowHeights = new int[] { 277, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JList list = new JList(new String[] { "A", "A", "A" });
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		panel.add(list, gbc_list);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);

		btnAddWatchlist = new JButton("Hinzuf\u00FCgen Watchlist");
		btnAddWatchlist.addActionListener(Controller.getInstance());

		JButton btnRemoveWatchlist = new JButton("Entfernen von Watchlist");
		btnRemoveWatchlist.addActionListener(Controller.getInstance());
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(43)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAddWatchlist, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRemoveWatchlist, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113,
										Short.MAX_VALUE))
						.addContainerGap(45, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(75)
						.addComponent(btnAddWatchlist, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnRemoveWatchlist, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(126)));
		panel_1.setLayout(gl_panel_1);

		JList list_1 = new JList(new String[] { "A", "A", "A" });
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 2;
		gbc_list_1.gridy = 0;
		panel.add(list_1, gbc_list_1);
		getContentPane().setLayout(groupLayout);

		setVisible(true);

	}
	
	public JButton getBtnAddWatchlist() {
		return btnAddWatchlist;
	}

	public JTextField getTxtSuche() {
		return txtSuche;
	}

}
