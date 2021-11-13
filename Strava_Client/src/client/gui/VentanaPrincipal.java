package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.controller.LoginController;
import client.controller.RetoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal(LoginController loginController, RetoController retoController) {
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmReto = new JMenuItem("Reto");
		mntmReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReto vR = new VentanaReto(loginController, retoController);
				vR.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmReto);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vL = new VentanaLogin(loginController,retoController);
				vL.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmCerrarSesion);
		
		JLabel lblTitulo = new JLabel("Sesiones disponibles");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(56, 33, 275, 50);
		getContentPane().add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 94, 364, 250);
		getContentPane().add(panel);
		
		JButton btnCerrarSesion = new JButton("Crear Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearSesion vCS = new VentanaCrearSesion(loginController,retoController);
				vCS.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setBounds(56, 366, 110, 23);
		getContentPane().add(btnCerrarSesion);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(224, 366, 107, 23);
		getContentPane().add(btnAtras);

		this.setTitle("Strava - Menu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(401, 450);
	}
}
