package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.controller.LoginController;
import client.controller.RetoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;

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
		
//		JPanel panel = new JPanel();
//		panel.setBounds(173, 94, 179, 245);
//		getContentPane().add(panel);
		
		JList list = new JList();
		getContentPane().add(list);
		list.setBounds(173, 94, 179, 245);
//		JScrollPane sp=new JScrollPane(panel);
//		panel.add(sp);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(29, 174, 110, 20);
		getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Buscar Sesion");
		btnNewButton.setBounds(29, 289, 110, 23);
		getContentPane().add(btnNewButton);
		
		
		
//		String [] sesiones= {"Cardio", "Hit"};
		
//		lista = new JList<String>(sesiones);
//		lista.setVisibleRowCount(4);
//		JScrollPane sp=new JScrollPane(laminaLista);
//		laminaLista=new JPanel();
//		laminaLista.add(sp);
//		lista.addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				
//				List<String> valores = lista.getSelectedValuesList();
//				
//				StringBuilder texto = new StringBuilder("Sesion seleccionada: ");
//				
//				for (String elemento: valores) {
//					String palabra = elemento;
//					texto.append(palabra);
//					texto.append(" ");
//				}
//				
//				rotulo.setText(texto.toString());
//			}
//		});
//		laminaTexto=new JPanel();
//		rotulo=new JLabel("Sesion seleccionada: ");
//		laminaTexto.add(rotulo);
//		add(laminaLista, BorderLayout.NORTH);
//		add(laminaLista, BorderLayout.SOUTH);
//		
//		
		this.setTitle("Strava - Menu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(401, 450);
	}
}
