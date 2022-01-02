package client.gui;

import javax.swing.*;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame{
	
	private JTextField textEmail;
	private JTextField textPass;
	
	public VentanaLogin(LoginController loginController, RetoController retoController, SesionController sesionController) {
		getContentPane().setLayout(null);
				
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setForeground(new Color(244, 164, 96));
		lblTitulo.setBounds(204, 39, 76, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(93, 111, 46, 14);
		getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(175, 108, 124, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(93, 175, 72, 14);
		getContentPane().add(lblPass);
		
		textPass = new JTextField();
		textPass.setBounds(175, 172, 124, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		JButton btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setBounds(154, 226, 145, 23);
		getContentPane().add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String email = textEmail.getText();
				String pass = textPass.getText();
				
				System.out.println(" - Login into the server: '" + email + "' - '" + "' ...");
				System.out.println("\t* Password : " + pass);		
				boolean result = loginController.login(email, pass);
				System.out.println("\t* Login result: " + result);
				System.out.println("\t* Token: " + loginController.getToken());
				
				JOptionPane.showMessageDialog(null, "Inicio de sesion correcto", "Confirmacion", 1);
				VentanaSesion vP = new VentanaSesion(loginController,retoController, sesionController);
				vP.setVisible(true);
				dispose();
												
			}
		});
						
		JLabel lblRegistro = new JLabel("No tienes una cuenta Strava?");
		lblRegistro.setBounds(54, 314, 178, 14);
		getContentPane().add(lblRegistro);
		
		JButton btnRegistro = new JButton("Registrate");
		btnRegistro.setBackground(new Color(192, 192, 192));
		btnRegistro.setOpaque(false);
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setForeground(Color.BLACK);
		btnRegistro.setBounds(204, 310, 113, 23);
		getContentPane().add(btnRegistro);
		
		JLabel lblResgitroGF = new JLabel("Registrate con");
		lblResgitroGF.setBounds(110, 278, 99, 14);
		getContentPane().add(lblResgitroGF);
		
		JButton btnGoogle = new JButton("Google");
		btnGoogle.setOpaque(false);
		btnGoogle.setForeground(Color.BLACK);
		btnGoogle.setContentAreaFilled(false);
		btnGoogle.setBorderPainted(false);
		btnGoogle.setBackground(Color.LIGHT_GRAY);
		btnGoogle.setBounds(219, 274, 113, 23);
		getContentPane().add(btnGoogle);
		
		JButton btnFacebook = new JButton("Facebook");
		btnFacebook.setOpaque(false);
		btnFacebook.setForeground(Color.BLACK);
		btnFacebook.setContentAreaFilled(false);
		btnFacebook.setBorderPainted(false);
		btnFacebook.setBackground(Color.LIGHT_GRAY);
		btnFacebook.setBounds(348, 274, 113, 23);
		getContentPane().add(btnFacebook);
		
		btnRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistro vR = new VentanaRegistro(loginController, retoController,sesionController);
				vR.setVisible(true);
				dispose();
		
			}
		});
		
		btnGoogle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLoginGoogle vlg = new VentanaLoginGoogle(loginController, retoController, sesionController);
				vlg.setVisible(true);
				dispose();
				
			}
		});
		
	btnFacebook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLoginFace vlg = new VentanaLoginFace(loginController, retoController, sesionController);
				vlg.setVisible(true);
				dispose();
				
			}
		});
		
		
		this.setTitle("Strava - Login");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500,400);
	}
}
