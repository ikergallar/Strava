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
import javax.swing.JSpinner;

public class VentanaReto extends JFrame {
	
	private JTextField textNombre;
	private JTextField textFechaini;
	private JTextField textFin;
	

	public VentanaReto(LoginController loginController, RetoController retoController) {
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Busca los mejores retos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(37, 11, 358, 62);
		getContentPane().add(lblTitulo);
		
		JList<RetoDTO> list = new JList<RetoDTO>();
		list.setBounds(364, 84, 330, 278);
		getContentPane().add(list);

		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearReto vCR = new VentanaCrearReto(loginController,retoController);
				vCR.setVisible(true);
				dispose();
			}
		});
		btnCrearReto.setBounds(207, 501, 110, 23);
		getContentPane().add(btnCrearReto);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal P = new VentanaPrincipal(loginController,retoController);
				P.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(316, 501, 110, 23);
		getContentPane().add(btnAtras);
		
		textNombre = new JTextField();
		textNombre.setBounds(133, 97, 96, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textFechaini = new JTextField();
		textFechaini.setBounds(133, 151, 96, 20);
		getContentPane().add(textFechaini);
		textFechaini.setColumns(10);
		
		textFin = new JTextField();
		textFin.setBounds(133, 211, 96, 20);
		getContentPane().add(textFin);
		textFin.setColumns(10);
		
		JButton btnBuscarReto = new JButton("Buscar reto");
		btnBuscarReto.setBounds(140, 344, 89, 23);
		getContentPane().add(btnBuscarReto);
		
		JButton btnApuntarse = new JButton("Apuntarse ");
		btnApuntarse.setBounds(490, 397, 89, 23);
		getContentPane().add(btnApuntarse);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(153, 272, 30, 20);
		getContentPane().add(spinner);
				
		btnBuscarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String fechaIni = textFechaini.getText();
				String fechaFin = textFin.getText();
				int duracion = (Integer) spinner.getValue();
				
				DefaultListModel<RetoDTO> modelo;
				List<RetoDTO> lista;
				
				modelo = new DefaultListModel<RetoDTO>();
				lista = retoController.buscarRetos(nombre, fechaIni, fechaFin, duracion);
				
				if(lista != null) {				
					for(RetoDTO re : lista) {
						modelo.addElement(re);
						list.setModel(modelo);	
					}
				}else {
					JOptionPane.showMessageDialog(null, "No existe ningun reto con esas caracteristicas", "Confirmacion", 1);

				}
				
			}
		});
		
		
		btnApuntarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RetoDTO reto = (RetoDTO) list.getSelectedValue();
				
				retoController.apuntarseReto(loginController.getToken(), reto.getIdReto());
				
			}
		});
		

		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(750, 600);

	}
}
