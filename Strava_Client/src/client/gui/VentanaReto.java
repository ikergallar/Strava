package client.gui;

import javax.swing.JFrame;

import client.controller.LoginController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaReto extends JFrame {

	public VentanaReto(LoginController controller) {
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Busca los mejores retos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(37, 11, 358, 62);
		getContentPane().add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBounds(10, 94, 364, 250);
		getContentPane().add(panel);

		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearReto vCR = new VentanaCrearReto(controller);
				vCR.setVisible(true);
				dispose();
			}
		});
		btnCrearReto.setBounds(60, 415, 110, 23);
		getContentPane().add(btnCrearReto);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal P = new VentanaPrincipal(controller);
				P.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(270, 415, 110, 23);
		getContentPane().add(btnAtras);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(450, 500);

	}
}
