package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import client.controller.DeporteController;
import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

public class VentanaRegistroFacebook extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textUsername;
	private JTextField textEmail;
	private JTextField textPass;
	
	public VentanaRegistroFacebook(LoginController loginController, RetoController retoController, SesionController sesionController,DeporteController deporteController) {
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Nombre de usuario:");
		lblUsername.setBounds(115, 71, 121, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("Correo:");
		lblEmail.setBounds(115, 114, 84, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(115, 158, 102, 14);
		getContentPane().add(lblPass);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(115, 207, 60, 14);
		getContentPane().add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(115, 253, 60, 14);
		getContentPane().add(lblAltura);
		
		textUsername = new JTextField();
		textUsername.setBounds(274, 68, 102, 20);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(274, 111, 102, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(274, 155, 102, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		JSpinner spinnerPeso = new JSpinner();
		spinnerPeso.setBounds(298, 204, 30, 20);
		getContentPane().add(spinnerPeso);
		
		JSpinner spinnerAltura = new JSpinner();
		spinnerAltura.setBounds(298, 250, 30, 20);
		getContentPane().add(spinnerAltura);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(298, 340, 107, 23);
		getContentPane().add(btnRegistrarse);
				
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
								
							if(loginController.registroFacebook(username, email, pass, peso, altura)) {									
								JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Confirmacion", 1);
									
								VentanaLogin vL = new VentanaLogin(loginController, retoController,sesionController,deporteController);
								vL.setVisible(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Error en el registro", "Error", 0);
							}
								
						}else {
							JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", 0);
						}
								
					}else {
						JOptionPane.showMessageDialog(null, "Direccion de correo no valida", "Error", 0);
					}
				}
			}
		});
		btnRegistrarse.setBounds(169, 274, 145, 23);
		btnRegistrarse.setForeground(Color.BLACK);
		getContentPane().add(btnRegistrarse);
		
		JLabel lblFacebook = new JLabel("Registro con Facebook");
		lblFacebook.setBounds(141, 11, 287, 38);
		lblFacebook.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblFacebook.setForeground(Color.BLUE);
		getContentPane().add(lblFacebook);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(26, 326, 89, 23);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().add(btnAtras);
		
		 btnAtras.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController,deporteController);
					vL.setVisible(true);
					dispose();
					
				}
			});
		  
		 this.setSize(500, 402);
	
	}
}
