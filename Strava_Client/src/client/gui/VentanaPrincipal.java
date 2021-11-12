package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.controller.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal(LoginController controller) {
		getContentPane().setLayout(null);
				
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(163, 28, 89, 23);
		getContentPane().add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(" - Logout from the server...");		
				controller.logout();
				System.out.println("\t* Logout success!");
				VentanaLogin vL = new VentanaLogin(controller);
				vL.setVisible(true);
				JOptionPane.showMessageDialog(null, "Sesión cerrada correctamente", "Confirmacion", 1);
				dispose();
		
			}
		});
		
		this.setTitle("Strava - Menu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,400);
	}
	
}
