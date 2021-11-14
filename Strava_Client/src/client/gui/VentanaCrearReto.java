package client.gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.management.loading.PrivateClassLoader;
import javax.swing.DefaultComboBoxModel;

import client.controller.LoginController;
import client.controller.RetoController;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class VentanaCrearReto extends JFrame {
	private JTextField textNombre;
	private JTextField txtDuracDeLa;
	private JTextField txtDistacia;
	private JTextField textFechaini;
	private JTextField textFin;

	public VentanaCrearReto(LoginController loginController, RetoController retoController) {
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("<html>Crea tus propios retos y compartelos con los usuarios de Strava<html>");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 404, 86);
		getContentPane().add(lblTitulo);

		textNombre = new JTextField();
		textNombre.setText("Nombre del reto");
		textNombre.setBounds(38, 129, 255, 28);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JComboBox comDeporte = new JComboBox();
		comDeporte.setModel(new DefaultComboBoxModel(new String[] { "Running", "Ciclismo", "Ambos" }));
		comDeporte.setToolTipText("");
		comDeporte.setBounds(38, 168, 255, 28);
		getContentPane().add(comDeporte);

		/*JDateChooser dateFechaIni = new JDateChooser();
		dateFechaIni.setBounds(38, 207, 255, 28);
		getContentPane().add(dateFechaIni);

		JDateChooser dateFechaFin = new JDateChooser();
		dateFechaFin.setBounds(38, 248, 255, 28);
		getContentPane().add(dateFechaFin);*/
		
		textFechaini = new JTextField();
		textFechaini.setBounds(38, 208, 255, 28);
		getContentPane().add(textFechaini);
		textFechaini.setColumns(10);
		
		textFin = new JTextField();
		textFin.setBounds(38, 247, 255, 29);
		getContentPane().add(textFin);
		textFin.setColumns(10);


		txtDistacia = new JTextField();
		txtDistacia.setText("Distacia del reto (km)");
		txtDistacia.setColumns(10);
		txtDistacia.setBounds(38, 287, 255, 28);
		getContentPane().add(txtDistacia);

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
				String Deporte = (String)comDeporte.getSelectedItem();
				int distancia = Integer.parseInt(txtDistacia.getText());
				
				System.out.println(" - Creando un reto " + nombre + "'");
				retoController.crearReto(nombre, fechaIni, fechaFin, distancia, Deporte, loginController.getToken());
				System.out.println(" - Reto creado correctamente " + nombre + "'");

			}
		});

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(201, 385, 89, 23);
		getContentPane().add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal C = new VentanaPrincipal(loginController,retoController);
				C.setVisible(true);
				dispose();

			}
		});
		
		this.setSize(500,500);

	}

}
