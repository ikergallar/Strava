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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaReto extends JFrame {
	
	private DefaultListModel<RetoDTO> modelo;
	private List<RetoDTO> lista;
	private JTextField textNombre;
	private JTextField textFechaini;
	private JTextField textFin;
	private JTextField textDuracion;
	

	public VentanaReto(LoginController loginController, RetoController retoController) {
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Busca los mejores retos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(37, 11, 358, 62);
		getContentPane().add(lblTitulo);
		
		JList<RetoDTO> list = new JList<RetoDTO>();
		list.setBounds(225, 100, 180, 278);
		getContentPane().add(list);

		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearReto vCR = new VentanaCrearReto(loginController,retoController);
				vCR.setVisible(true);
				dispose();
			}
		});
		btnCrearReto.setBounds(161, 415, 110, 23);
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
		
		textNombre = new JTextField();
		textNombre.setBounds(31, 84, 96, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textFechaini = new JTextField();
		textFechaini.setBounds(31, 143, 96, 20);
		getContentPane().add(textFechaini);
		textFechaini.setColumns(10);
		
		textFin = new JTextField();
		textFin.setBounds(31, 211, 96, 20);
		getContentPane().add(textFin);
		textFin.setColumns(10);
		
		textDuracion = new JTextField();
		textDuracion.setBounds(31, 269, 96, 20);
		getContentPane().add(textDuracion);
		textDuracion.setColumns(10);
		
		JButton btnBuscarReto = new JButton("Buscar reto");
		btnBuscarReto.setBounds(38, 379, 89, 23);
		getContentPane().add(btnBuscarReto);
		
		modelo = new DefaultListModel<RetoDTO>();
		lista = retoController.getRetos();
		
		for(RetoDTO re : lista) {
			modelo.addElement(re);
			list.setModel(modelo);	
		}
		
		btnBuscarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String fechaIni = textFechaini.getText();
				String fechaFin = textFin.getText();
				int duracion = Integer.valueOf(textDuracion.getText());
				
				/*modelo = new DefaultListModel<RetoDTO>();
				lista = retoController.buscarRetos(nombre, fechaIni, fechaFin, duracion);
				
				for(RetoDTO re : lista) {
					modelo.addElement(re);
					list.setModel(modelo);	
				}
				*/
				JOptionPane.showMessageDialog(null, "Inicio de sesion correcto", "Confirmacion", 1);

				
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaa: ");		

			}
		});
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(450, 500);

	}
}
