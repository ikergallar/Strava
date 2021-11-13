package client.gui;

import javax.swing.JFrame;

import client.controller.LoginController;
import client.controller.RetoController;
import server.data.dto.RetoDTO;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class VentanaReto extends JFrame {
	
	private DefaultListModel modelo;
	private List<RetoDTO> lista;
	

	public VentanaReto(LoginController loginController, RetoController retoController) {
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Busca los mejores retos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(37, 11, 358, 62);
		getContentPane().add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBounds(10, 94, 364, 250);
		getContentPane().add(panel);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		panel.add(list);
		
		modelo = new DefaultListModel<>();
		lista = retoController.getRetos();
		
		for(RetoDTO re : lista) {
			modelo.addElement(re);
			list.setModel(modelo);	
		}

		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearReto vCR = new VentanaCrearReto(loginController,retoController);
				vCR.setVisible(true);
				dispose();
			}
		});
		btnCrearReto.setBounds(60, 415, 110, 23);
		getContentPane().add(btnCrearReto);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal P = new VentanaPrincipal(loginController,retoController);
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
