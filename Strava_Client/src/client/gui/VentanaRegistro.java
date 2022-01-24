package client.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import client.controller.DeporteController;
import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

import javax.swing.JSpinner;
import javax.swing.JButton;

public class VentanaRegistro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsername;
	private JTextField textEmail;
	private JTextField textPass;
	
	public VentanaRegistro(LoginController loginController, RetoController retoController,SesionController sesionController,DeporteController deporteController) {
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setForeground(new Color(244, 164, 96));
		lblTitulo.setBounds(194, 21, 107, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblUsername = new JLabel("Nombre de usuario:");
		lblUsername.setBounds(115, 71, 139, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("Correo:");
		lblEmail.setBounds(115, 114, 84, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(115, 158, 107, 14);
		getContentPane().add(lblPass);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(115, 207, 60, 14);
		getContentPane().add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(115, 253, 46, 14);
		getContentPane().add(lblAltura);
		
		textUsername = new JTextField();
		textUsername.setBounds(274, 68, 86, 20);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(274, 111, 86, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(274, 155, 86, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		JSpinner spinnerPeso = new JSpinner();
		spinnerPeso.setBounds(298, 204, 30, 20);
		getContentPane().add(spinnerPeso);
		
		JSpinner spinnerAltura = new JSpinner();
		spinnerAltura.setBounds(298, 250, 30, 20);
		getContentPane().add(spinnerAltura);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(140, 313, 114, 23);
		getContentPane().add(btnRegistrarse);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController,deporteController);
				vL.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(298, 313, 107, 23);
		getContentPane().add(btnAtras);
		
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = textUsername.getText();
				String email = textEmail.getText();
				String pass = textPass.getText();
				int altura = (Integer) spinnerAltura.getValue();
				int peso = (Integer) spinnerPeso.getValue();
				
				if (username.equals("") || email.equals("") || pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);

				} else {

					if (email.contains("@") && email.contains(".")) {	
						
						if(!loginController.existeUsuario(username,email)) {
							
							loginController.registro(username, email, pass, peso, altura);
							
							JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Confirmacion", 1);
							
							VentanaLogin vL = new VentanaLogin(loginController, retoController,sesionController,deporteController);
							vL.setVisible(true);
							dispose();
							
						} else {
							JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", 0);
						}

					} else {
					JOptionPane.showMessageDialog(null, "Direccion de correo no valida", "Error", 0);

					}
				}
			}
		});
		
		this.setTitle("Strava - Registro");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(541,400);
	}
}
