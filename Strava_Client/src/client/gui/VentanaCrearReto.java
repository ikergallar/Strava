package client.gui;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearReto extends JFrame {
	
	private JTextField textNombre;
	private JTextField textFechaini;
	private JTextField textFin;

	public VentanaCrearReto(LoginController loginController, RetoController retoController,
			SesionController sesionController) {
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("<html>Crea tus propios retos y compartelos con los usuarios de Strava<html>");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 404, 86);
		getContentPane().add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre del reto: ");
		lblNombre.setBounds(29, 136, 112, 14);
		getContentPane().add(lblNombre);

		JLabel lblFechaIni = new JLabel("Fecha de Inicio(dd/mm/aaaa):");
		lblFechaIni.setBounds(29, 215, 152, 14);
		getContentPane().add(lblFechaIni);

		JLabel lblFechaFin = new JLabel("Fecha final(dd/mm/aaaa):");
		lblFechaFin.setBounds(29, 254, 150, 14);
		getContentPane().add(lblFechaFin);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(193, 303, 30, 20);
		getContentPane().add(spinner);

		JLabel lblDistancia = new JLabel("Distancia(km): ");
		lblDistancia.setBounds(29, 306, 123, 14);
		getContentPane().add(lblDistancia);

		textNombre = new JTextField();
		textNombre.setText("Nombre del reto");
		textNombre.setBounds(189, 129, 255, 28);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JComboBox comDeporte = new JComboBox();
		comDeporte.setModel(new DefaultComboBoxModel(new String[] { "Running", "Ciclismo", "Ambos" }));
		comDeporte.setToolTipText("");
		comDeporte.setBounds(189, 169, 255, 28);
		getContentPane().add(comDeporte);

		textFechaini = new JTextField();
		textFechaini.setBounds(189, 208, 255, 28);
		getContentPane().add(textFechaini);
		textFechaini.setColumns(10);

		textFin = new JTextField();
		textFin.setBounds(189, 247, 255, 29);
		getContentPane().add(textFin);
		textFin.setColumns(10);

		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.setBounds(91, 385, 89, 23);
		getContentPane().add(btnCrearReto);

		btnCrearReto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String nombre = textNombre.getText();
				String fechaIni = textFechaini.getText();
				String fechaFin = textFin.getText();
				String Deporte = (String) comDeporte.getSelectedItem();
				int distancia = (Integer) spinner.getValue();

				System.out.println(" - Creando un reto " + nombre + "'");
				retoController.crearReto(nombre, fechaIni, fechaFin, distancia, Deporte, loginController.getToken());
				System.out.println(" - Reto creado correctamente " + nombre + "'");
				
				JOptionPane.showMessageDialog(null, "Reto creado correctamente", "Confirmacion", 1);


			}
		});

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(201, 385, 89, 23);
		getContentPane().add(btnAtras);

		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaReto C = new VentanaReto(loginController, retoController, sesionController);
				C.setVisible(true);
				dispose();

			}
		});

		this.setSize(500, 500);

	}
}