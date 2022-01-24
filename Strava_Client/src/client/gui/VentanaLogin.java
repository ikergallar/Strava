package client.gui;

import javax.swing.*;

import client.controller.DeporteController;
import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JTextField textPass;
	
	public VentanaLogin(LoginController loginController, RetoController retoController, SesionController sesionController, DeporteController deporteController) {
		getContentPane().setLayout(null);
				
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setForeground(new Color(244, 164, 96));
		lblTitulo.setBounds(204, 39, 76, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(94, 95, 46, 14);
		getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(175, 92, 124, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(94, 152, 81, 14);
		getContentPane().add(lblPass);
		
		textPass = new JTextField();
		textPass.setBounds(175, 149, 124, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		JButton btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setBounds(172, 206, 145, 23);
		getContentPane().add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String email = textEmail.getText();
				String pass = textPass.getText();
				
				String user = loginController.getUserTipo(email);
				boolean existeUsuario = loginController.existeUsuario("",email);

				if(existeUsuario) {
					if(user.equals("Email")) {
						
						System.out.println(" - Login into the server: '" + email + "' - '" + "' ...");
						System.out.println("\t* Password : " + pass);		
						boolean result = loginController.login(email, pass);
						System.out.println("\t* Login result: " + result);
						System.out.println("\t* Token: " + loginController.getToken());
						
						if(result) {
							JOptionPane.showMessageDialog(null, "Inicio de sesion correcto", "Confirmacion", 1);
							VentanaSesion vP = new VentanaSesion(loginController,retoController, sesionController,deporteController);
							vP.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", 2);
							textEmail.setText("");
							textPass.setText("");

						}
					}else {
						JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Error", 2);
						textEmail.setText("");
						textPass.setText("");

					}
				}else {
					JOptionPane.showMessageDialog(null, "Debe registrarse antes de iniciar sesion", "Error", 2);
					textEmail.setText("");
					textPass.setText("");
				}
													
			}
		});
						
		JLabel lblRegistro = new JLabel("No tienes una cuenta Strava?");
		lblRegistro.setBounds(54, 351, 178, 14);
		getContentPane().add(lblRegistro);
		
		JButton btnRegistro = new JButton("Registrate");
		btnRegistro.setBackground(new Color(192, 192, 192));
		btnRegistro.setOpaque(false);
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setForeground(Color.BLACK);
		btnRegistro.setBounds(204, 347, 113, 23);
		getContentPane().add(btnRegistro);
		
		JLabel lblResgitroGF = new JLabel("Registrate con");
		lblResgitroGF.setBounds(54, 376, 99, 14);
		getContentPane().add(lblResgitroGF);
		
		JButton btnGoogle = new JButton("Google");
		btnGoogle.setOpaque(false);
		btnGoogle.setForeground(Color.BLACK);
		btnGoogle.setContentAreaFilled(false);
		btnGoogle.setBorderPainted(false);
		btnGoogle.setBackground(Color.LIGHT_GRAY);
		btnGoogle.setBounds(123, 372, 113, 23);
		getContentPane().add(btnGoogle);
		
		JButton btnFacebook = new JButton("Facebook");
		btnFacebook.setOpaque(false);
		btnFacebook.setForeground(Color.BLACK);
		btnFacebook.setContentAreaFilled(false);
		btnFacebook.setBorderPainted(false);
		btnFacebook.setBackground(Color.LIGHT_GRAY);
		btnFacebook.setBounds(204, 372, 113, 23);
		getContentPane().add(btnFacebook);
		
		JButton btnLFacebook = new JButton("Facebook");
		btnLFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLoginFace vLF = new VentanaLoginFace(loginController, retoController,sesionController,deporteController);
				vLF.setVisible(true);
				dispose();
			}
		});
		btnLFacebook.setBounds(265, 269, 99, 30);
		//ImageIcon facebook = new ImageIcon("../img/Facebook.png");
		//btnLFacebook.setIcon(new ImageIcon(facebook.getImage().getScaledInstance(btnLFacebook.getWidth(), btnLFacebook.getHeight(), Image.SCALE_SMOOTH)));;
		getContentPane().add(btnLFacebook);
		
		JButton btnLGoogle = new JButton("Google");
		btnLGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLoginGoogle vLG = new VentanaLoginGoogle(loginController, retoController,sesionController,deporteController);
				vLG.setVisible(true);
				dispose();
			}
		});
		btnLGoogle.setBounds(123, 269, 99, 30);
		getContentPane().add(btnLGoogle);
		
		btnRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistro vR = new VentanaRegistro(loginController, retoController,sesionController, deporteController);
				vR.setVisible(true);
				dispose();
		
			}
		});
		
		btnGoogle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaRegistroGoogle vrg = new VentanaRegistroGoogle(loginController, retoController, sesionController,deporteController);
				vrg.setVisible(true);
				dispose();
				
			}
		});
		
	btnFacebook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaRegistroFacebook vrf = new VentanaRegistroFacebook(loginController, retoController, sesionController,deporteController);
				vrf.setVisible(true);
				dispose();
				
			}
		});
		
		
		this.setTitle("Strava - Login");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(514,470);
	}
}
