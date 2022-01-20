package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

public class VentanaRegistroFacebook extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JTextField textPass;
	
	
	
	public VentanaRegistroFacebook(LoginController loginController, RetoController retoController, SesionController sesionController) {
		getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(93, 160, 46, 14);
		getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(175, 157, 124, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(93, 227, 72, 14);
		getContentPane().add(lblPass);
		
		textPass = new JTextField();
		textPass.setBounds(175, 224, 124, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(169, 274, 145, 23);
		btnRegistro.setForeground(Color.BLACK);
		getContentPane().add(btnRegistro);
		
		JLabel lblFacebook = new JLabel("Registro con Google");
		lblFacebook.setBounds(141, 11, 208, 38);
		lblFacebook.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblFacebook.setForeground(Color.RED);
		getContentPane().add(lblFacebook);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(26, 326, 89, 23);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().add(btnAtras);
		
		JLabel lblInfo = new JLabel("Registrese en Strava utilizan un email y contrase\u00F1a asociadas\r\n a una cuenta de Facebook");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfo.setBounds(10, 60, 464, 68);
		getContentPane().add(lblInfo);
		
		btnRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLoginGoogle vl = new VentanaLoginGoogle(loginController, retoController, sesionController);
				vl.setVisible(true);
				dispose();
				
			}
		});
		
		 this.setSize(500, 405);
		
		
	}
	

}
