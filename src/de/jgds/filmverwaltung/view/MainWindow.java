package de.jgds.filmverwaltung.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame{

	public MainWindow() {
		setTitle("Filmverwaltung");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 340);
		
		JLabel lblHalloWelt = new JLabel("Hallo Welt");
		lblHalloWelt.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHalloWelt, BorderLayout.CENTER);
		
		JLabel lblLinks = new JLabel("Links");
		getContentPane().add(lblLinks, BorderLayout.WEST);
		
		JLabel lblHalloHierOben = new JLabel("Hallo hier oben");
		getContentPane().add(lblHalloHierOben, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}

}
