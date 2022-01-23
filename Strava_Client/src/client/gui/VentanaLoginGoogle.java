package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.controller.DeporteController;
import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

public class VentanaLoginGoogle extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JTextField textPass;
	
	
	public VentanaLoginGoogle(LoginController loginController, RetoController retoController, SesionController sesionController,DeporteController deporteController) {
		getContentPane().setLayout(null);
		
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
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBounds(158, 226, 145, 23);
		btnLogin.setForeground(Color.BLACK);
		getContentPane().add(btnLogin);
		
		JLabel lblFacebook = new JLabel("GOOGLE");
		lblFacebook.setBounds(175, 24, 153, 38);
		lblFacebook.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblFacebook.setForeground(Color.RED);
		getContentPane().add(lblFacebook);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(25, 307, 89, 23);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().add(btnAtras);
		
        btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String email = textEmail.getText();
				String pass = textPass.getText();
				
				System.out.println(" - Login with Google into the server: '" + email + "' - '" + pass + "' ...");
				System.out.println("\t* Password : " + pass);		
				boolean resultado = loginController.loginGoogle(email, pass);
				boolean result = loginController.login(email, pass);
				System.out.println("\t* Login result: " + resultado);
				if (result && resultado) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto", "Confirmacion", 1);
					VentanaSesion vP = new VentanaSesion(loginController,retoController, sesionController,deporteController);
					vP.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Error", "Error", 0);
				}
	
												
			}
		});
        
        btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				// TODO Auto-generated method stub
				VentanaLogin vl = new VentanaLogin(loginController, retoController, sesionController,deporteController);
				vl.setVisible(true);
				dispose();
				
			}
		});
        
        
        this.setSize(500, 405);
		
	}
	

}
